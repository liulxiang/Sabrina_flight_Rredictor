package com.taotaoti.xuetao.controller;

import java.io.IOException;
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
import com.taotaoti.common.utils.DateUtils;
import com.taotaoti.common.utils.MainCSV;
import com.taotaoti.common.utils.ObjToStringUtil;
import com.taotaoti.common.vo.MatchMap;
import com.taotaoti.common.web.session.SessionProvider;
import com.taotaoti.fight.vo.RequestFightVo;
import com.taotaoti.fwr.vo.RfwdateVo;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.member.dao.MessageDao;
import com.taotaoti.member.service.MemberMgr;
import com.taotaoti.weather.vo.RequestWeatherVo;

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
			@RequestParam(value="fightNo") String fightNo,
			ModelMap model){
		 Gson gson=new Gson();
		List<MatchMap> listMaps=new ArrayList<MatchMap>();
		if(curPage==null) curPage=0;
		if(pageSize==null) pageSize=12;
		if(categoryType==null) categoryType=2;
		String fightJson=null;
		fightJson=HttpClientUtils.getHtmlBody("https://api.flightstats.com/flex/schedules/rest/v1/json/flight/AA/"+fightNo+"/departing/"+DateUtils.formatCurrrentDate2()+"?appId=c4daadf2&appKey=46aa77182c010799973f50085c877d71");
		RequestFightVo fightVo=gson.fromJson(fightJson, RequestFightVo.class);
		System.out.println(ObjToStringUtil.objToString(fightVo));
		String josn=HttpClientUtils.getHtmlBody("https://api.flightstats.com/flex/weather/rest/v1/json/all/sfo?appId=c4daadf2&appKey=46aa77182c010799973f50085c877d71");
		RequestWeatherVo requestWeatherVo=gson.fromJson(josn, RequestWeatherVo.class);
		RfwdateVo rfwdateVo=new RfwdateVo(fightVo.getScheduledFlights().get(0), requestWeatherVo.getTaf());
		
		listMaps.add(new MatchMap("fightVo", fightVo.getScheduledFlights().get(0)));
		/**
		 * 根据航班号 通过R 生产测试数据
		 */
		RSabrinaUtil.dealDataByFilghtNo(fightNo);
		/**
		 * wd
		 */
		float wd=rfwdateVo.getWd();
		float r= RSabrinaUtil.getRResult();
	    listMaps.add(new MatchMap("todayRData",r));
	    listMaps.add(new MatchMap("wd", wd));
	    listMaps.add(new MatchMap("delay", wd+r));
	    
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
