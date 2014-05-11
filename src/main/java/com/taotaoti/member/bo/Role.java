package com.taotaoti.member.bo;

import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Table(db = "xuetao", name = "role", keyColumn = Columns.RoleColumns.roleid)
public class Role extends BaseObject<Integer> {

	// Fields

	private Integer roleid;
	private String name;
	private Integer statu;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** full constructor */
	public Role(String name, Integer statu) {
		super();
		this.name = name;
		this.statu = statu;
	}

	// Property accessors

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatu() {
		return this.statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

}