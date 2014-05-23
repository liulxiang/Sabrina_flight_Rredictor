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

import com.google.gson.Gson;
import com.taotaoti.common.controller.BaseController;
import com.taotaoti.common.httpclient.HttpClientUtils;
import com.taotaoti.common.redis.RedisCacheManager;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.member.dao.MessageDao;
import com.taotaoti.member.service.MemberMgr;
import com.taotaoti.weather.vo.FightWeather;

@Controller
public class WebController extends BaseController {
	private static final Logger LOG = LoggerFactory.getLogger(WebController.class);
	@Resource 
	private SessionProvider session;
	@Resource
	private RedisCacheManager redisCacheMgr;
	@Resource
	private MemberMgr memberMgr;
	@Resource
	private MemberDao memberDao;
	@Resource
	private MessageDao messageDao;
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model){
        List<MatchMap> listMaps=new ArrayList<MatchMap>();
		return this.buildSuccess(model, "/index", listMaps);
	}
	@RequestMapping(value = "/web/search")
	public String search(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value="curPage",required=false) Integer curPage,
			@RequestParam(value="pageSize",required=false) Integer pageSize,
			@RequestParam(value="content",required=false) String content,
			@RequestParam(value="categoryType",required=false) Integer categoryType,
			ModelMap model){
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		if(curPage==null) curPage=0;
		if(pageSize==null) pageSize=12;
		if(categoryType==null) categoryType=2;
		//https://api.flightstats.com/flex/schedules/rest/v1/json/flight/AA/1667/departing/2014/05/23?appId=c4daadf2&appKey=46aa77182c010799973f50085c877d71"
		String josn=HttpClientUtils.getHtmlBody("https://api.forecast.io/forecast/1a4fbce4b6f79f5715b2b1a3f9777d10/37.46,-122.24");
	    Gson gson=new Gson();
	     FightWeather fightWeather=gson.fromJson(josn, FightWeather.class);
	     listMaps.add(new MatchMap("fightWeather", fightWeather));
		return this.buildSuccess(model, "/web/search", listMaps);
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
