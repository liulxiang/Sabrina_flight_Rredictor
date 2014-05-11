package com.taotaoti.xuetao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.member.service.MemberMgr;

@Controller
@RequestMapping(value="/admin")
public class ManagerController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(ManagerController.class);
	@Resource 
	private SessionProvider session;
	@Resource
	private MemberDao memberDao;
	@Resource
	private MemberMgr memberMgr;
	@Resource
	private RedisCacheManager redisCacheMgr;
	

	@RequestMapping(value = "/browseMember")
	public String browseMember(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		if(curPage==null||curPage<0) curPage=0;
		if(pageSize==null) pageSize=12;
		MatchMap members=new MatchMap("members",memberMgr.browseAcountInfos());
		listMaps.add(members);
		return this.buildSuccess(model, "/admin/browseMember", listMaps);
	}
	@RequestMapping(value = "/deleteMember")
	public ModelAndView deleteMember(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="memberId") Integer memberId,
			ModelMap model){
		return this.buildSuccessByRedirectOnlyUrl("/admin/browseMember");
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
