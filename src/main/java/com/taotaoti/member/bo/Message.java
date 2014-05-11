package com.taotaoti.member.bo;

import java.sql.Timestamp;

import com.taotaoti.common.generic.annotation.Column;
import com.taotaoti.common.generic.annotation.Table;
import com.taotaoti.common.generic.bo.BaseObject;


@Table(db = "xuetao", name = "message", keyColumn = MessageColumns.messageId) 
public class Message  extends BaseObject<Integer>  implements java.io.Serializable {

	@Column(value=MessageColumns.messageId)
	private Integer messageId;
	@Column(value=MessageColumns.messageType)
	private Integer messageType;
	@Column(value=MessageColumns.messageContent)
	private String messageContent;
	@Column(value=MessageColumns.messageStatu)
	private Integer messageStatu ;
	@Column(value=MessageColumns.messageProductId)
	private Integer messageProductId;
	@Column(value=MessageColumns.messageMemberId)
	private Integer messageMemberId;
	@Column(value=MessageColumns.messageMemberName)
	private String messageMemberName;
	@Column(value=MessageColumns.messageCreateTime)
	private Timestamp messageCreateTime;
	
	
	public Message(){
		
	}
	public Message(Integer messageId, Integer messageType,
			String messageContent, Integer messageStatu,
			Integer messageProductId, Integer messageMemberId,
			Timestamp messageCreateTime) {
		super();
		this.messageId = messageId;
		this.messageType = messageType;
		this.messageContent = messageContent;
		this.messageStatu = messageStatu;
		this.messageProductId = messageProductId;
		this.messageMemberId = messageMemberId;
		this.messageCreateTime = messageCreateTime;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public Integer getMessageType() {
		return messageType;
	}
	public void setMessageType(Integer messageType) {
		this.messageType = messageType;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Integer getMessageStatu() {
		return messageStatu;
	}
	public void setMessageStatu(Integer messageStatu) {
		this.messageStatu = messageStatu;
	}
	public Integer getMessageProductId() {
		return messageProductId;
	}
	public void setMessageProductId(Integer messageProductId) {
		this.messageProductId = messageProductId;
	}
	public Integer getMessageMemberId() {
		return messageMemberId;
	}
	public void setMessageMemberId(Integer messageMemberId) {
		this.messageMemberId = messageMemberId;
	}
	public Timestamp getMessageCreateTime() {
		return messageCreateTime;
	}
	public void setMessageCreateTime(Timestamp messageCreateTime) {
		this.messageCreateTime = messageCreateTime;
	}
	public String getMessageMemberName() {
		return messageMemberName;
	}
	public void setMessageMemberName(String messageMemberName) {
		this.messageMemberName = messageMemberName;
	}
	
	
	
}