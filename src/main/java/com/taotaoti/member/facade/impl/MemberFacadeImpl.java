package com.taotaoti.member.facade.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.taotaoti.member.facade.MemberFacade;
import com.taotaoti.member.service.MemberMgr;
import com.taotaoti.member.vo.AcountInfo;
@Component
public class MemberFacadeImpl implements MemberFacade {

	@Resource
	MemberMgr memberMgr;
	@Override
	public AcountInfo getAcountInfoByMemberId(int memberId) {
		
		return memberMgr.getAcountInfoByMemberId(memberId);
	}

	@Override
	public AcountInfo getMemberByEmailAndPassword(String email, String password) {
		return memberMgr.getMemberByEmailAndPassword(email, password);
	}

	@Override
	public List<AcountInfo> browseAcountInfos() {
		return memberMgr.browseAcountInfos();
	}

	@Override
	public AcountInfo registerMember(String email, String dbpassword,
			String nickName, String phone,int schoolId,String photo,String major) {
		return memberMgr.registerMember(email, dbpassword, nickName, phone,schoolId,photo,major);
	}

	@Override
	public boolean isRegisterMember(String email, String phone) {
		// TODO Auto-generated method stub
		return memberMgr.isRegisterMember(email, phone);
	}

	@Override
	public AcountInfo getMemberByPhoneAndPassword(String phone, String password) {
		return memberMgr.getMemberByPhoneAndPassword(phone, password);
	}

}
