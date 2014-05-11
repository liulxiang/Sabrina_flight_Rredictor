package com.taotaoti.common.web.member.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.HttpUtils;
import com.taotaoti.common.utils.MD5;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.constants.GlobalConstant;
import com.taotaoti.member.constant.MemberConstant;
import com.taotaoti.member.facade.MemberFacade;
import com.taotaoti.member.vo.AcountInfo;

@Controller
@RequestMapping(value="/admin")
public class AdminLoginController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(AdminLoginController.class);
	@Resource(name="sessionProvider")
	private SessionProvider sessionProvider;
	
	@Resource(name="redisCacheMgr")
	private RedisCacheManager redisCacheMgr;
	
	@Resource
	private MemberFacade memberFacade;
	
	
	@RequestMapping(value = "/loginMe", method = RequestMethod.POST)
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
			if(acountInfo!=null&&acountInfo.getRoleid()==MemberConstant.ROLE_BAO_SUPER_ADMIN){
				 initVisterSessionAndRedis(request,response,acountInfo);
				 LOG.info("to "+GlobalConstant.getADMIN_UC_HOME_URL());
				return GlobalConstant.getADMIN_UC_HOME_URL();
			}else {
				LOG.info("用户不存在");
				return this.buildBusinessError(model, GlobalConstant.getADMIN_UC_LOGIN_URL(), "用户不存在");
			}
	    }else{
	    	LOG.info("参数错误！");
	    	return this.buildBusinessError(model, GlobalConstant.getADMIN_UC_LOGIN_URL(), "参数错误！");
	    }	
	}
	
	
	
	public boolean validatorUser(String email,String password){
		if(email!=null&& password!=null){
			if(email.contains("@")&&password.length()>=6){
				return true;
			}else{
				this.errors.put("validatorError", "参数验证不合法");
			}
		}else
		     this.errors.put("validatorError", "参数不能为空");
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
        visitor.setTeacher(true);
        
        sessionProvider.setAttributeAsVisitor(request, visitor);
		
		//redisCacheMgr.put(taotaotiId + UserWebConstant.USER_KEY, LoginConstant.SESSION_EXPIRE_TIME, visitor);
		
	}
	
	public RedisCacheManager getRedisCacheMgr() {
		return redisCacheMgr;
	}
	public void setRedisCacheMgr(RedisCacheManager redisCacheMgr) {
		this.redisCacheMgr = redisCacheMgr;
	}
}
