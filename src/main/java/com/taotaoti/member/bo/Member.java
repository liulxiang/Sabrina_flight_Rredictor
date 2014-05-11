package com.taotaoti.member.bo;

import java.sql.Timestamp;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;

/**
 */
@Table(db = "xuetao", name = "Member", keyColumn = Columns.memberId)
public class Member extends BaseObject<Integer> {

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String password;
	private String sex;
	@Column(value=Columns.MemberColumns.schoolId)
	private Integer schoolId;
	@Column(value=Columns.MemberColumns.partyJoinSum)
	private Integer partyJoinSum;
	private String photo;
	private String description;
	private String phone;
	private Integer points;
	@Column(value=Columns.MemberColumns.reputation)
	private Integer reputation;
	@Column(value=Columns.MemberColumns.successSum)
	private Integer successSum;
	@Column(value=Columns.MemberColumns.failSum)
	private Integer failSum;
	@Column(value=Columns.MemberColumns.partyCreateSum)
	private Integer partyCreateSum;
	@Column(value=Columns.MemberColumns.major)
	private String major;
	@Column(value=Columns.MemberColumns.roleid)
	private Integer roleid;
	@Column(value=Columns.MemberColumns.createTime)
	private Timestamp createTime;
	@Column(value=Columns.MemberColumns.updateTime)
	private Timestamp updateTime;

	/** default constructor */
	public Member() {
	}

	public Member(String name, String email, String password, String sex,
			Integer schoolId, Integer partyJoinSum, String photo,
			String description, String phone, Integer points,
			Integer reputation, Integer successSum, Integer failSum,
			Integer partyCreateSum, String major, Integer roleid,
			Timestamp createTime, Timestamp updateTime) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.sex = sex;
		this.schoolId = schoolId;
		this.partyJoinSum = partyJoinSum;
		this.photo = photo;
		this.description = description;
		this.phone = phone;
		this.points = points;
		this.reputation = reputation;
		this.successSum = successSum;
		this.failSum = failSum;
		this.partyCreateSum = partyCreateSum;
		this.major = major;
		this.roleid = roleid;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getPartyJoinSum() {
		return partyJoinSum;
	}

	public void setPartyJoinSum(Integer partyJoinSum) {
		this.partyJoinSum = partyJoinSum;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getReputation() {
		return reputation;
	}

	public void setReputation(Integer reputation) {
		this.reputation = reputation;
	}

	public Integer getSuccessSum() {
		return successSum;
	}

	public void setSuccessSum(Integer successSum) {
		this.successSum = successSum;
	}

	public Integer getFailSum() {
		return failSum;
	}

	public void setFailSum(Integer failSum) {
		this.failSum = failSum;
	}

	public Integer getPartyCreateSum() {
		return partyCreateSum;
	}

	public void setPartyCreateSum(Integer partyCreateSum) {
		this.partyCreateSum = partyCreateSum;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
