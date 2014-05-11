/*******************************************************************************
 * CopyRight (c) 2000-2012 Baidu Online Network Technology (Beijing) Co., Ltd. All rights reserved.
 * Filename:    AdviewBaseTest.java
 * Creator:     <a href="mailto:xuxiaohu@baidu.com">Xu,Xiaohu</a>
 * Create-Date: 2013-5-8 下午5:29:30
 *******************************************************************************/
package com.taotaoti.member;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.common.BaseTestCase;
import com.taotaoti.member.bo.Auth;
import com.taotaoti.member.bo.Role;
import com.taotaoti.member.dao.AuthDao;
import com.taotaoti.member.dao.RoleDao;

public class RoleDaoTest extends BaseTestCase {
	
	@Resource
	private RoleDao roleDao;
	
	@Test
	public void testfindAll(){
		List<Role> list= roleDao.findAll();
		System.out.println(list.size());
	}
	//@Test
	public void testModifyAuthCode(){
		roleDao.modifyRoleName(1, "ADMIN");
	}
	@Test
	public void testSaveAuth(){
		Role role=new Role();
		role.setId(1);
		role.setName("管理员");
		role.setStatu(0);
		roleDao.create(role);
		//roleDao.updateRole(role);
	}
	//@Test 
	public void otherMember(){
		System.out.println("auth==================="+roleDao.counts());
	}
}
