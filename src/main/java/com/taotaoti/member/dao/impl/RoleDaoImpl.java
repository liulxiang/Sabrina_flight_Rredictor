package com.taotaoti.member.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.member.bo.Columns;
import com.taotaoti.member.bo.Role;
import com.taotaoti.member.dao.RoleDao;

/**
 * dsp的dao实现
 */
@Repository
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao{
	
	 protected final static Log LOG = LogFactory.getLog(RoleDaoImpl.class);
	@Override
	public List<Role> findAll() {
		return find();
	}
	@Override
	public void modifyRoleName(Integer roleid, String name) {
		update(modify(Columns.RoleColumns.name, name), match(Columns.RoleColumns.roleid, roleid));
	}
	@Override
	public void modifyRoleStatu(Integer roleid, Integer statu) {
		update(modify(Columns.RoleColumns.statu, statu), match(Columns.RoleColumns.roleid, roleid));
	}
	@Override
	public boolean updateRole(Role role) {
		return update(role);
	}
	@Override
	public Role createRole(Role auth) {
		// TODO Auto-generated method stub
		return this.create(auth);
	}
	@Override
	public int counts() {
		// TODO Auto-generated method stub
		return count();
	}
}
