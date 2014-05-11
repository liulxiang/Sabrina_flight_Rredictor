
package com.taotaoti.member.dao;

import java.util.List;

import com.taotaoti.common.generic.dao.BaseDao;
import com.taotaoti.member.bo.Message;

public interface MessageDao extends BaseDao<Integer, Message> {

	public List<Message> findByMemberId(int memberId);
	public List<Message> findByProductTypeAndProductId(int productType,int productId,int curPage, int pageSize);
	public int countsByMessageMemberId(int memberId);
}