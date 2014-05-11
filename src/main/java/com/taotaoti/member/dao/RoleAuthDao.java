
package com.taotaoti.member.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.member.bo.Roleauth;
public interface RoleAuthDao extends BaseDao<Integer,Roleauth> {

	public List<Roleauth> findAll(int roleId);
	public Roleauth createRoleauth(Roleauth roleauth);
	public int counts();
}