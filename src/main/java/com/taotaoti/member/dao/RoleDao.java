
package com.taotaoti.member.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.member.bo.Role;

public interface RoleDao extends BaseDao<Integer, Role> {

	public List<Role> findAll();
	
	public void modifyRoleStatu(Integer authid, Integer statu);
	public void modifyRoleName(Integer authid, String name);
	
	public Role createRole(Role role);
	public boolean updateRole(Role role);

	public int counts();
}