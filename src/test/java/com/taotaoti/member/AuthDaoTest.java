package com.taotaoti.member;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.taotaoti.common.BaseTestCase;
import com.taotaoti.member.bo.Auth;
import com.taotaoti.member.dao.AuthDao;

public class AuthDaoTest extends BaseTestCase {
	
	@Resource
	private AuthDao authDao;
	
	@Test
	public void testfindAll(){
		List ids=new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		List<Auth> list= authDao.findByAuthids(ids);
		//System.out.println(list.toArray(a));
	}
	@Test
	public void testModifyAuthCode(){
		//authDao.modifyAuthCode(1, "ADMIN_INDEX");
	}
	//@Test
	public void testSaveAuth(){
		Auth auth=new Auth();
		auth.setAuthcode("ADMIN_INDEX");
		Auth m=authDao.create(auth);
	}
	//@Test 
	public void otherMember(){
		System.out.println("auth==================="+authDao.counts());
	}
}
