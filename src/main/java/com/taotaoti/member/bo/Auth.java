package com.taotaoti.member.bo;

import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;
@Table(db = "xuetao", name = "auth", keyColumn = Columns.AuthColumns.authid) 
public class Auth  extends BaseObject<Integer>  implements java.io.Serializable {

	// Fields

	private Integer authid;
	private String authcode;

	// Constructors

	/** default constructor */
	public Auth() {
	}

	/** full constructor */
	public Auth(String authcode) {
		super();
		this.authcode = authcode;
	}

	// Property accessors

	public Integer getAuthid() {
		return this.authid;
	}

	public void setAuthid(Integer authid) {
		this.authid = authid;
	}

	public String getAuthcode() {
		return this.authcode;
	}

	public void setAuthcode(String authcode) {
		this.authcode = authcode;
	}

}