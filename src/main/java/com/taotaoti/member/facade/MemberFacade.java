package com.taotaoti.member.facade;

import java.util.List;

import com.taotaoti.member.vo.AcountInfo;


public interface MemberFacade {
	
	public AcountInfo getAcountInfoByMemberId(int memberId);
	public List<AcountInfo> browseAcountInfos();
	public AcountInfo getMemberByEmailAndPassword(String email,String password);
	public AcountInfo getMemberByPhoneAndPassword(String phone,String password);
	public AcountInfo registerMember(String email, String dbpassword,
			String nickName, String phone,int schoolId,String photo,String major);
	public boolean isRegisterMember(String email, String phone);
}
