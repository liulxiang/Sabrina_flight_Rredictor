package com.taotaoti.common.web.member.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.CookieUtils;
import com.taotaoti.common.web.member.controller.loginValidate.AccountLoginValidator;

@Controller
public class LogoutController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(LogoutController.class);
	@Resource
	private RedisCacheManager redisCacheMgr;
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// redis中移除visitor
		String taotaotiId = CookieUtils.getCookieValue(request, LoginConstant.TAOTAOTI_COOKIE_NAME);
//		if(taotaotiId != null){
//			redisCacheMgr.remove(taotaotiId + UserWebConstant.USER_KEY);
//		}
		CookieUtils.removeCookie(request, response,LoginConstant.TAOTAOTI_COOKIE_EMAIL );
		CookieUtils.removeCookie(request, response,LoginConstant.TAOTAOTI_COOKIE_NAME );
		CookieUtils.removeCookie(request, response,LoginConstant.TAOTAOTI_COOKIE_PASSWORD );
		CookieUtils.removeCookie(request, response,LoginConstant.TAOTAOTI_COOKIE_NAME );
		
		LOG.info(taotaotiId+"logout");
		AccountLoginValidator validator = AccountLoginValidator.getInstance();
		validator.logout(request);
		return this.buildErrorByRedirectOnlyUrl("/preRegister");
	}

	public RedisCacheManager getRedisCacheMgr() {
		return redisCacheMgr;
	}

	public void setRedisCacheMgr(RedisCacheManager redisCacheMgr) {
		this.redisCacheMgr = redisCacheMgr;
	}
}
