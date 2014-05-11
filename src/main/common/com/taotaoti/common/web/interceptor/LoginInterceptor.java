package com.taotaoti.common.web.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.commons.ThreadContext;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.utils.CookieUtils;
import com.taotaoti.common.vo.Visitor;
import com.taotaoti.common.web.constant.UserWebConstant;
import com.taotaoti.common.web.member.controller.LoginConstant;
import com.taotaoti.common.web.member.controller.loginValidate.AccountLoginValidator;
import com.taotaoti.common.web.session.SessionProvider;

public class LoginInterceptor extends WebCommonInterceptor {

	public class WebCommonInterceptor {

	}

	private static final Log LOG = LogFactory.getLog(LoginInterceptor.class);
	@Autowired
	private SessionProvider session;
	
	private List<String> notJsonPathList;
	
	private List<String> notInterceptPathList;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
		ThreadContext.clean();
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// 去掉不需拦截的path
		String requestPath = request.getRequestURI();
		if(notInterceptPathList != null && notInterceptPathList.contains(requestPath)){
			return true;
		}
		
		// 验证是否JSON请求
		boolean jsonEnabled = true;
		if(notJsonPathList != null && notJsonPathList.contains(requestPath)){
			jsonEnabled = false;
		}
		
		/**
		 * 设置visitor
		 * 
		 */
		// 判断session中是否有visitor
		Visitor visitor =session.getSessionVisitor(request);
		if(visitor!=null){
			System.out.println("---------------------");
			session.setAttributeAsVisitor(request, visitor);
			return true;
		}
		
		// 没有获取到visitor，跳转到登录页
		String loginPage=request.getContextPath()+"/index";
		LOG.error("do not get visitor, redirect to login page==" +loginPage);
		response.sendRedirect(loginPage);
		return false;
	}

	/**
	 * @return the notJsonPathList
	 */
	public List<String> getNotJsonPathList() {
		return notJsonPathList;
	}

	/**
	 * @param notJsonPathList the notJsonPathList to set
	 */
	public void setNotJsonPathList(List<String> notJsonPathList) {
		this.notJsonPathList = notJsonPathList;
	}

	/**
	 * @return the notInterceptPathList
	 */
	public List<String> getNotInterceptPathList() {
		return notInterceptPathList;
	}

	/**
	 * @param notInterceptPathList the notInterceptPathList to set
	 */
	public void setNotInterceptPathList(List<String> notInterceptPathList) {
		this.notInterceptPathList = notInterceptPathList;
	}

	
}
