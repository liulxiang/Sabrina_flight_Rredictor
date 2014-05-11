/*******************************************************************************
 * CopyRight (c) 2000-2012 Baidu Online Network Technology (Beijing) Co., Ltd. All rights reserved.
 * Filename:    AdviewBaseTest.java
 * Creator:     <a href="mailto:xuxiaohu@baidu.com">Xu,Xiaohu</a>
 * Create-Date: 2013-5-8 下午5:29:30
 *******************************************************************************/
package com.taotaoti.member;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.common.BaseTestCase;
import com.taotaoti.common.utils.ObjToStringUtil;
import com.taotaoti.member.service.MemberMgr;
import com.taotaoti.member.vo.AcountInfo;

public class MemberMgrTest extends BaseTestCase {
	
	@Resource
	private MemberMgr memberMgr;
	
	
	@Test
	public void testMemberFacade(){
		AcountInfo acountInfo=memberMgr.getMemberByEmailAndPassword("nickName@chuancheng.cn","111111111111");
		System.out.println(acountInfo.getName());
		System.out.println(acountInfo.getEmail());
		System.out.println(ObjToStringUtil.objToString(acountInfo));
	}
	@Test
	public void testModifyEmail(){
	}
//	@Test
//	public void testSaveMember(){
//		memberMgr.registerMember("nickName@chuancheng.cn", "111111111111", "nickName", "18610625648");
//	}
	
	
}
