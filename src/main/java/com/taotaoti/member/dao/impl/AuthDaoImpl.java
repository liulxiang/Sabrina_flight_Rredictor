package com.taotaoti.member.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.member.bo.Auth;
import com.taotaoti.member.bo.Columns;
import com.taotaoti.member.dao.AuthDao;

@Repository
public class AuthDaoImpl extends AbstractDao<Integer, Auth> implements AuthDao{
	
	 protected final static Log LOG = LogFactory.getLog(AuthDaoImpl.class);
	@Override
	public List<Auth> findAll() {
		return find();
	}
	@Override
	public List<Auth> findByAuthids(List ids) {
		return this.get(ids);
	}
	@Override
	public void modifyAuthCode(Integer authid, String authCode) {
		update(modify(Columns.AuthColumns.authcode, authCode), match(Columns.AuthColumns.authid, authid));
	}
	@Override
	public Auth createAuth(Auth auth) {
		// TODO Auto-generated method stub
		return this.create(auth);
	}
	@Override
	public int counts() {
		// TODO Auto-generated method stub
		return count();
	}
}
