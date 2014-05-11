package com.taotaoti.member.bo;

import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;
@Table(db = "xuetao", name = "roleauth", keyColumn = Columns.RoleauthColumns.id)
public class Roleauth extends BaseObject<Integer>{
	// Fields

	private Integer id;
	private Integer roleid;
	private Integer authid;

	// Constructors

	/** default constructor */
	public Roleauth() {
	}

	/** full constructor */
	public Roleauth(Integer roleid, Integer authid) {
		super();
		this.roleid = roleid;
		this.authid = authid;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getAuthid() {
		return this.authid;
	}

	public void setAuthid(Integer authid) {
		this.authid = authid;
	}

}