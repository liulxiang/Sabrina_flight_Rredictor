package com.taotaoti.member.vo;

import java.sql.Timestamp;

import com.taotaoti.member.bo.Member;

public class AcountInfo extends Member {
	private static final long serialVersionUID = 4089458387116208127L;
	private String[] authArr = new String[]{};
	private String[] roleArr = new String[]{};
	private String schoolName;
	
	public AcountInfo() {
     super();
	}
	public AcountInfo(Member member){
		this.id=member.getId();
		this.setId(member.getId());
		this.setCreateTime(member.getCreateTime());
		this.setEmail(member.getEmail());
		this.setName(member.getName());
		this.setPassword(member.getPassword());
		this.setRoleid(member.getRoleid());
		this.setUpdateTime(member.getUpdateTime());
		this.setSchoolId(member.getSchoolId());
		this.setPhoto(member.getPhoto());
		this.setMajor(member.getMajor());
		this.setDescription(member.getDescription());
		
		
		this.setPartyCreateSum(member.getPartyCreateSum());
		this.setFailSum(member.getFailSum());
		this.setPoints(member.getPoints());
		this.setReputation(member.getReputation());
		this.setSuccessSum(member.getSuccessSum());
		this.setPartyJoinSum(member.getPartyJoinSum());
		
		
	}
	public String[] getAuthArr() {
		return authArr;
	}
	public void setAuthArr(String[] authArr) {
		this.authArr = authArr;
	}
	public String[] getRoleArr() {
		return roleArr;
	}
	public void setRoleArr(String[] roleArr) {
		this.roleArr = roleArr;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

}
