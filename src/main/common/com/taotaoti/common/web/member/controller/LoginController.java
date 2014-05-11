package com.taotaoti.common.web.member.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.HttpUtils;
import com.taotaoti.common.utils.MD5;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.member.dao.MessageDao;
import com.taotaoti.member.facade.MemberFacade;
import com.taotaoti.member.vo.AcountInfo;

@Controller
public class LoginController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	@Resource 
	private SessionProvider session;
	
	@Resource
	private RedisCacheManager redisCacheMgr;
	
	@Resource
	private MemberFacade memberFacade;
	@Resource
	private MessageDao messageDao;
	
	@RequestMapping(value = "/register")
	public ModelAndView register(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("schoolId") Integer schoolId, 
			//@RequestParam("major") String major, 
			@RequestParam("email") String email, 
			//@RequestParam("phone") String phone, 
			@RequestParam("username") String username, 
			@RequestParam("password") String password,
			ModelMap model){
			String dbPassword=MD5.getMd5(password);
			LOG.info("register");
			String photo="/resources/img/images/avatar-large.png";
			if(!email.endsWith(".eud")) 
			 return this.buildErrorByRedirectAndParam("/preRegister", model, "please write u school mail eg：xxxxx@xxx.eud");
			
			if(memberFacade.isRegisterMember(email, "")) 
				return this.buildErrorByRedirectAndParam("/preRegister", model, "User already exists！");
		
		   // 转型为MultipartHttpRequest
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// 根据前台的name名称得到上传的文件
			MultipartFile file = multipartRequest.getFile("file");
			if(!file.isEmpty()){
				// 获得文件名：
				String realFileName = file.getOriginalFilename();
				// 获取路径
				String ctxPath = request.getSession().getServletContext().getRealPath("/")
						+ File.separator + "resources"+ File.separator +"upload"+ File.separator +"photo"+ File.separator;
				// 创建文件
				File dirPath = new File(ctxPath);
				if (!dirPath.exists()) {
					dirPath.mkdir();
				}
				System.out.println(file.getName());
				
				if(!realFileName.endsWith(".jpg"))
				    return this.buildErrorByRedirectAndParam("/preRegister", model, "The picture is not in the correct format!");
			    
				realFileName=System.currentTimeMillis()+MD5.getMd5(realFileName)+".jpg";
				File uploadFile = new File(ctxPath + realFileName);
				
				try {
					FileCopyUtils.copy(file.getBytes(), uploadFile);
					photo=("/resources/upload/photo/"+realFileName);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		if(schoolId==null)
			    return this.buildErrorByRedirectAndParam("/preRegister", model, "please write you school name");
		
//		if(phone==null)
//			return this.buildErrorByRedirectAndParam("/preRegister", model, "please write you phone");
		String phone="";
//		String username="";
		String major="";
		 AcountInfo acountInfo=   memberFacade.registerMember(email, dbPassword, username, phone,schoolId,photo,major);
		if(acountInfo!=null){
			initVisterSessionAndRedis(request,response,acountInfo);
			 return this.buildSuccessByRedirectOnlyUrl("/index");
		}else {
			 return this.buildErrorByRedirectAndParam("/preRegister", model, "Sorry, Register fail ! please Try again!");
		}  
	}
	
	@RequestMapping(value = "/preRegister")
	public String preRegister(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
			List<MatchMap> listMaps=new ArrayList<MatchMap>();
			LOG.info("preGegister!");
			
			return this.buildSuccess(model, "/register", listMaps);
	}
	@RequestMapping(value = "/memberLogin", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("email") String email, 
			@RequestParam("password") String password,
			ModelMap model){
		    errors=new HashMap<String, Object>();
		   LOG.info("email="+email+" login ");
		   if(validatorUser(email, password)){
	    	String dbPassword=MD5.getMd5(password);
	    	AcountInfo acountInfo=   memberFacade.getMemberByEmailAndPassword(email, dbPassword);
			if(acountInfo!=null){
				initVisterSessionAndRedis(request,response,acountInfo);
				 LOG.info("to "+LoginConstant.getACCOUNT_HOME_URL());
				return LoginConstant.getACCOUNT_HOME_URL();
			}else {
				LOG.info("用户不存在");
				return this.buildBusinessError(model, LoginConstant.getUC_LOGIN_URL(), "user not find!");
			}
	    }else{
	    	LOG.info("参数错误！");
	    	return this.buildBusinessError(model, LoginConstant.getUC_LOGIN_URL(), "param error！");
	    }	
	}
	
	
	
	public boolean validatorUser(String email,String password){
		if(email!=null&& password!=null){
			if(email.contains("@")&&password.length()>=6){
				return true;
			}else{
				this.errors.put("validatorError", "Parameter verification is not legitimate");
			}
		}else
		     this.errors.put("validatorError", "Parameter verification is not NUll");
		return false;
	}
	
   public void initVisterSessionAndRedis(HttpServletRequest request,HttpServletResponse response,AcountInfo member){
		
		String userId=""+member.getId();
		Cookie cookieUserId = new Cookie(LoginConstant.TAOTAOTI_COOKIE_USERID, userId);  
		cookieUserId.setMaxAge(24 * 60 * 60 * 30);
		response.addCookie(cookieUserId);
		
		String taotaotiId=MD5.getMd5("TAOTAOTI"+member.getId());
		Cookie cookie = new Cookie(LoginConstant.TAOTAOTI_COOKIE_NAME, taotaotiId);  
		cookie.setMaxAge(24 * 60 * 60 * 30);
		response.addCookie(cookie);
		
		Cookie cookieEmail = new Cookie(LoginConstant.TAOTAOTI_COOKIE_EMAIL, member.getEmail());  
		cookieEmail.setMaxAge(24 * 60 * 60 * 30);
		response.addCookie(cookieEmail);
		
		Cookie cookiePassword = new Cookie(LoginConstant.TAOTAOTI_COOKIE_PASSWORD, member.getPassword());  
		cookiePassword.setMaxAge(24 * 60 * 60 * 30);
        response.addCookie(cookiePassword);
        
        visitor = new Visitor();
        visitor.setTaotaotiId(taotaotiId);
        visitor.setUserid(member.getId());
        visitor.setUsername(member.getName());
        visitor.setIp(HttpUtils.getHttpForwardIp(request));
        visitor.setEmail(member.getEmail());
        visitor.setAuthArr(member.getAuthArr());
        visitor.setRoleArr(member.getRoleArr());
        visitor.setPhoto(member.getPhoto());
        visitor.setMajor(member.getMajor());
        visitor.setJoinSum(member.getPartyJoinSum());
        visitor.setPoint(member.getPoints());
        visitor.setTeacher(false);
        
        int messageSum=messageDao.countsByMessageMemberId(member.getId());
        visitor.setMessageSum(messageSum);
        
		session.setAttributeAsVisitor(request, visitor);
		
		//redisCacheMgr.put(taotaotiId + UserWebConstant.USER_KEY, LoginConstant.SESSION_EXPIRE_TIME, visitor);
		
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
