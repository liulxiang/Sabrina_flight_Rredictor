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
import com.taotaoti.member.bo.Message;
import com.taotaoti.member.bo.MessageColumns;
import com.taotaoti.member.constant.MessageConstant;
import com.taotaoti.member.dao.MessageDao;

@Repository
public class MessageDaoImpl extends AbstractDao<Integer, Message> implements MessageDao{
	
	 protected final static Log LOG = LogFactory.getLog(MessageDaoImpl.class);
	
	@Override
	public List<Message> findByMemberId(int memberId) {
		List<Match> matchs = new ArrayList<Match>();
		List<Order> orders = new ArrayList<Order>();
		orders.add(order(MessageColumns.messageCreateTime,false));
		matchs.add(match(MessageColumns.messageMemberId, memberId));
		matchs.add(match(MessageColumns.messageStatu, MessageConstant.MESSAGE_STATU_OK));
		return this.find(matchs, orders);
	}
	@Override
	public int countsByMessageMemberId(int memberId) {
		return this.count(match(MessageColumns.messageMemberId, memberId),match(MessageColumns.messageStatu, 0));
	}
	@Override
	public List<Message> findByProductTypeAndProductId(int productType,
			int productId,int curPage, int pageSize) {
		List<Match> matchs = new ArrayList<Match>();
		List<Order> orders = new ArrayList<Order>();
		orders.add(order(MessageColumns.messageCreateTime,false));
		matchs.add(match(MessageColumns.messageType, productType));
		matchs.add(match(MessageColumns.messageStatu, MessageConstant.MESSAGE_STATU_OK));
		matchs.add(match(MessageColumns.messageProductId, productId));
		return this.page(matchs, orders, curPage, pageSize);
	}
}
