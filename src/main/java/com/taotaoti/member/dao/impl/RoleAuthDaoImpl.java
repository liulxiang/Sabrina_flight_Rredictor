package com.taotaoti.member.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.common.generic.dao.operator.Match;
import com.taotaoti.member.bo.Auth;
import com.taotaoti.member.bo.Columns;
import com.taotaoti.member.bo.Roleauth;
import com.taotaoti.member.bo.Columns.RoleauthColumns;
import com.taotaoti.member.dao.AuthDao;
import com.taotaoti.member.dao.RoleAuthDao;

@Repository
public class RoleAuthDaoImpl extends AbstractDao<Integer, Roleauth> implements RoleAuthDao{
	
	 protected final static Log LOG = LogFactory.getLog(RoleAuthDaoImpl.class);
	@Override
	public int counts() {
		// TODO Auto-generated method stub
		return count();
	}
	@Override
	public List<Roleauth> findAll(int roleId) {
		// TODO Auto-generated method stub
		return find(match(RoleauthColumns.roleid,roleId));
	}
	@Override
	public Roleauth createRoleauth(Roleauth roleauth) {
		// TODO Auto-generated method stub
		return create(roleauth);
	}
}
