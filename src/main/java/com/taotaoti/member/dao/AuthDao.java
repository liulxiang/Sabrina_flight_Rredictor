
package com.taotaoti.member.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.member.bo.Auth;

public interface AuthDao extends BaseDao<Integer, Auth> {

	public List<Auth> findAll();
	public List<Auth> findByAuthids(List ids);
	
	public void modifyAuthCode(Integer authid, String authCode);
	
	public Auth createAuth(Auth auth);

	public int counts();
}