package com.taotaoti.member.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.taotaoti.common.dao.AbstractDao;
import com.taotaoti.common.generic.dao.operator.Match;
import com.taotaoti.common.generic.dao.operator.Order;
import com.taotaoti.member.bo.Columns;
import com.taotaoti.member.bo.Member;
import com.taotaoti.member.dao.MemberDao;


@Repository
public class MemberDaoImpl extends AbstractDao<Integer, Member> implements MemberDao{
	
	 protected final static Log LOG = LogFactory.getLog(MemberDaoImpl.class);
	@Override
	public List<Member> findAll() {
		return find();
	}
	@Override
	public void modifyEmail(Integer memberId, String email) {
		update(modify("email", email), match(Columns.memberId, memberId));
	}
	@Override
	public void modifyCreatePartySum(Integer memberId, int sum) {
		update(modify(Columns.MemberColumns.partyCreateSum, sum), match(Columns.memberId, memberId));
	}
	@Override
	public void modifyPassword(Integer memberId, String password) {
		update(modify("password", password), match(Columns.memberId, memberId));
	}
	@Override
	public void modifyJoinPartySum(Integer memberId ,int sum) {
		update(modify(Columns.MemberColumns.partyJoinSum, sum), match(Columns.memberId, memberId));
	}
	@Override
	public void modifyPoint(Integer memberId ,int point) {
		update(modify(Columns.MemberColumns.points, point), match(Columns.memberId, memberId));
	}
	@Override
	public void modifyPhoto(Integer memberId, String photo) {
		update(modify(Columns.MemberColumns.photo, photo), match(Columns.memberId, memberId));
	}
	@Override
	public Member createMember(Member member) {
		// TODO Auto-generated method stub
		return this.create(member);
	}
	@Override
	public List<Member> findByMemberId(Integer memberId, int page,
			int pageSize) {
		List<Match> matchs = new ArrayList<Match>();
		matchs.add(match(Columns.memberId, memberId));
		List<Order> orders = new ArrayList<Order>();
		orders.add(order(Columns.MemberColumns.updateTime,true));
		return super.page(matchs,orders,page,pageSize);
	}
	@Override
	public List<Member> findMembers(int page,
			int pageSize) {
		List<Match> matchs = new ArrayList<Match>();
		List<Order> orders = new ArrayList<Order>();
		orders.add(order(Columns.MemberColumns.updateTime,true));
		return super.page(matchs,orders,page,pageSize);
	}
	@Override
	public int countByMemberId(Integer memberId) {
		// TODO Auto-generated method stub
		return count(match(Columns.memberId, memberId));
	}
	@Override
	public int counts() {
		// TODO Auto-generated method stub
		return count();
	}
	@Override
	public Member findMemberByEmailAndPassword(String email, String password) {
		return this.findOne(match(Columns.MemberColumns.email, email),match(Columns.MemberColumns.password, password));
	}
	@Override
	public Member findMemberByEmail(String email) {
		return this.findOne(match(Columns.MemberColumns.email, email));
	}
}
