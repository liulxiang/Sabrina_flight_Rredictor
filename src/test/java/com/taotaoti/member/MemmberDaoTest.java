/*******************************************************************************
 * CopyRight (c) 2000-2012 Baidu Online Network Technology (Beijing) Co., Ltd. All rights reserved.
 * Filename:    AdviewBaseTest.java
 * Creator:     <a href="mailto:xuxiaohu@baidu.com">Xu,Xiaohu</a>
 * Create-Date: 2013-5-8 下午5:29:30
 *******************************************************************************/
package com.taotaoti.member;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.common.BaseTestCase;
import com.taotaoti.common.utils.ObjToStringUtil;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.dao.MemberDao;
import com.taotaoti.member.facade.MemberFacade;
import com.taotaoti.member.vo.AcountInfo;

public class MemmberDaoTest extends BaseTestCase {
	
	@Resource
	private MemberDao memberDao;
	@Resource
	private MemberFacade memberFacade;
	
	@Test
	public void testMemberFacade(){
		AcountInfo acountInfo=memberFacade.getMemberByEmailAndPassword("leon@chuancheng.cn","123456");
		System.out.println(ObjToStringUtil.objToString(acountInfo));
	}
	//@Test
	public void testfindAll(){
		List<Member> list= memberDao.findAll();
		System.out.println(list.size());
	}
	//@Test
	public void testModifyEmail(){
		memberDao.modifyEmail(1, "yufeifei@gmail.com");
	}
	@Test
	public void testSaveMember(){
		Member member=new Member();
		member.setEmail("sabrina@gmail.com");
		member.setCreateTime(new Timestamp(System.currentTimeMillis()));
		member.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		member.setPassword("password");
		member.setName("sabrina");
		member.setFailSum(0);
		member.setSuccessSum(0);
		member.setMajor("major");
		member.setPartyCreateSum(0);
		member.setPartyJoinSum(0);
		member.setPoints(0);
		member.setPartyJoinSum(0);
		member.setRoleid(0);
		member.setSchoolId(0);
		member.setReputation(0);
		
		System.out.println("=============================");
		Member m=memberDao.create(member);
		System.out.println("============================="+m.getId());
	}
	@Test 
	public void otherMember(){
		//memberDao.delete(13);
		System.out.println(memberDao.counts());
		//System.out.println(memberDao.countByAdvertiserId(1));
	}
	@Test
	public void findMember(){
		List<Member> members= memberDao.findMembers(1, 2);
		System.out.println(members.size());
		if(members.size()>0){
			System.out.println(members.get(0).getName());
			
		}
	}

	
}
