package com.taotaoti.xuetao.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.FileUtils;
import com.taotaoti.common.utils.MD5;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.member.dao.MessageDao;
import com.taotaoti.member.service.MemberMgr;

@Controller
@RequestMapping(value="/member")
public class MemberController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);
	@Resource 
	private SessionProvider session;
	@Resource
	private MemberDao memberDao;
	@Resource
	private MemberMgr memberMgr;
	@Resource
	private MessageDao messageDao;
	@Resource
	private RedisCacheManager redisCacheMgr;
	
	@RequestMapping(value = "/settings/settings")
	public String settings(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
	 	MatchMap member=new MatchMap("member", memberDao.get(v.getUserid()));
		listMaps.add(member);
		listMaps.add(new MatchMap("v", v));
		listMaps.add(new MatchMap("path", "/member/settings/settings"));
		listMaps.add(new MatchMap("pathName", "settings"));
		
		return this.buildSuccess(model, "/member/settings/settings", listMaps);
	}
	@RequestMapping(value = "/settings/password")
	public String password(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
		listMaps.add(new MatchMap("path", "/member/settings/password"));
		listMaps.add(new MatchMap("pathName", "password"));
		return this.buildSuccess(model, "/member/settings/password", listMaps);
	}
	@RequestMapping(value = "/settings/email")
	public String email(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		listMaps.add(new MatchMap("path", "/member/settings/email"));
		listMaps.add(new MatchMap("pathName", "email"));
		return this.buildSuccess(model, "/member/settings/email", listMaps);
	}
	@RequestMapping(value = "/settings/addParty")
	public String addParty(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		listMaps.add(new MatchMap("path", "/member/settings/addParty"));
		listMaps.add(new MatchMap("pathName", "addParty"));
		return this.buildSuccess(model, "/member/settings/addParty", listMaps);
	}
	
	@RequestMapping(value = "/settings/preBuyGood")
	public String preBuyGood(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="goodId") Integer goodId,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		listMaps.add(new MatchMap("goodId", goodId));
		return this.buildSuccess(model, "/member/settings/buyGood", listMaps);
	}
	@RequestMapping(value = "/settings/browseMessage")
	public String browseMessage(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		if(curPage==null||curPage<0) curPage=0;
		if(pageSize==null) pageSize=12;
		Visitor v=this.session.getSessionVisitor(request);
		MatchMap messages=new MatchMap("messages", messageDao.findByMemberId(v.getUserid()));
		listMaps.add(messages);
		return this.buildSuccess(model, "/member/settings/browseMessage", listMaps);
	}
	
	@RequestMapping(value = "/settings/modifyPassword")
	public ModelAndView modifyPassword(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="oldPassword") String oldPassword,
			@RequestParam(value="newPassword") String newPassword,
			@RequestParam(value="newPassword2") String newPassword2,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		if(!newPassword.equals(newPassword2)){
			LOG.error("新密码与确认密码不一致");
			return this.buildErrorByRedirectAndParam("/member/settings/password", model, "New password and confirm new password fields do not match");
		}
		Member member=memberDao.get(v.getUserid());
		if(!member.getPassword().equals(MD5.getMd5(oldPassword))){
			LOG.error("旧密码不正确！");
			return this.buildErrorByRedirectAndParam( "/member/settings/password",model, "The specified old password is incorrect for changing the password！");
		}
		memberDao.modifyPassword(v.getUserid(), MD5.getMd5(newPassword));
		return this.buildSuccessByRedirectOnlyUrl("/member/settings/settings");
	}
	
	@RequestMapping(value = "/settings/modifyEmail")
	public ModelAndView modifyEmail(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="password") String password,
			@RequestParam(value="newEmail") String newEmail,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
		Member member=memberDao.get(v.getUserid());
		if(!member.getPassword().equals(MD5.getMd5(password))){
			LOG.error("旧密码不正确！");
			return this.buildErrorByRedirectAndParam( "/member/settings/email",model, "The  password is incorrect for changing ！");
		}
	    if(memberMgr.isRegisterMember(newEmail, "")){
	    	return this.buildErrorByRedirectAndParam( "/member/settings/email",model, "email is exist");
	    }
		memberDao.modifyEmail(v.getUserid(), newEmail);
		v.setEmail(newEmail);
		this.session.setAttributeAsVisitor(request, v);
		return this.buildSuccessByRedirectOnlyUrl("/member/settings/settings");
	}
	@RequestMapping(value = "/settings/avatar")
	public String avatar(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
		Visitor v=this.session.getSessionVisitor(request);
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
	 	MatchMap member=new MatchMap("acountInfo", memberMgr.getAcountInfoByMemberId(v.getUserid()));
		listMaps.add(member);
		listMaps.add(new MatchMap("v", v));
		listMaps.add(new MatchMap("settingsPath", "/member/settings/avatar"));
		listMaps.add(new MatchMap("settingsPathName", "修改头像"));
		return this.buildSuccess(model, "/member/settings/avatar", listMaps);
	}
	@RequestMapping(value = "/settings/modifyPhoto")
	public ModelAndView modifyPhoto(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		Visitor v = this.session.getSessionVisitor(request);
		String commPath = File.separator +"resources" + File.separator + "upload"
				+ File.separator + "photo"
				+ File.separator;
		String pageUrl = "/member/settings/avatar";
		// 根目录路径，可以指定绝对路径，比如 /var/www/attached/
		String savePath = request.getSession().getServletContext()
				.getRealPath("/")
				+ commPath;
		// 根目录URL，可以指定绝对路径，比如 http://www.yoursite.com/attached/
		//String saveUrl = request.getContextPath() + File.separator + commPath;
		String saveUrl = commPath;
		// 图片扩展名
		String[] fileTypes = new String[] { "gif", "jpg", "jpeg", "png", "bmp" };
		// 最大文件大小
		long maxSize = 1000000;

		if (!ServletFileUpload.isMultipartContent(request)) {
			LOG.info("请选择文件。");
			return this.buildErrorByRedirectAndParam(pageUrl, model, "请选择文件。");
		}
		// 检查目录
		File uploadDir = new File(savePath);
		if (!uploadDir.isDirectory()) {
			LOG.info("上传目录不存在。");
			return this
					.buildErrorByRedirectAndParam(pageUrl, model, "上传目录不存在。");
		}
		// 检查目录写权限
		if (!uploadDir.canWrite()) {
			LOG.info("上传目录没有写权限");
			return this.buildErrorByRedirectAndParam(pageUrl, model,
					"上传目录没有写权限。");
		}
		// 创建文件夹
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		savePath += ymd + "/";
		saveUrl += ymd + "/";
		File dirFile = new File(savePath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> filess = multipartRequest.getFileMap();
		Iterator<String> keys = filess.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			MultipartFile multipartFile = filess.get(key);
			String fileName = multipartFile.getOriginalFilename();
			// 检查文件大小
			if (multipartFile.getSize() > maxSize) {
				LOG.info("上传文件大小超过限制");
				return this.buildErrorByRedirectAndParam(pageUrl, model,
						"上传文件大小超过限制。");
			}
			// 检查扩展名
			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
					.toLowerCase();
			if (!Arrays.<String> asList(fileTypes).contains(fileExt)) {
				LOG.info("上传文件扩展名是不允许的扩展名。");
				return this.buildErrorByRedirectAndParam(pageUrl, model,
						"上传文件扩展名是不允许的扩展名。");
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			String newFileName =v.getUserid()+"_"+ df.format(new Date()) + "_"
					+ new Random().nextInt(1000) + "." + fileExt;
			try {
				FileUtils.SaveFileFromInputStream(
						multipartFile.getInputStream(), savePath + newFileName);
			} catch (IOException e) {
				LOG.info("上传失败！");
				return this.buildErrorByRedirectAndParam(pageUrl, model,
						"上传文件失败。");
			}
			LOG.info("上传成功！");
			memberDao.modifyPhoto(v.getUserid(), saveUrl + newFileName);
			return this.buildSuccessByRedirectOnlyUrl("/member/settings/avatar");
		}

		return this.buildSuccessByRedirectOnlyUrl("/member/settings/avatar");
	}
	
	@RequestMapping(value = "/settings/modifyMemberInfo")
	public ModelAndView modifyMemberInfo(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("major") String major, 
			@RequestParam("phone") String phone, 
			@RequestParam("username") String username, 
			@RequestParam("description") String description, 
			ModelMap model){
		LOG.info("modify Member Info");
		Visitor v=this.session.getSessionVisitor(request);
		Member member=memberDao.get(v.getUserid());
		member.setMajor(major);
		member.setPhone(phone);
		member.setName(username);
		member.setDescription(description);
		member.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		memberDao.update(member);
		return this.buildSuccessByRedirectOnlyUrl("/member/settings/settings");
	}
	public SessionProvider getSession() {
		return session;
	}
	public void setSession(SessionProvider session) {
		this.session = session;
	}
	public RedisCacheManager getRedisCacheMgr() {
		return redisCacheMgr;
	}
	public void setRedisCacheMgr(RedisCacheManager redisCacheMgr) {
		this.redisCacheMgr = redisCacheMgr;
	}
}
