package com.taotaoti.common.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * 错误DTO
 *
 * @version 2013-4-12 下午3:22:16
 */
public class ErrorDTO {

	// 错误所在list中的索引位置
	private int index = -1;

	// 错误所在类中的变量名称
	private String field = "default";
	
	// 错误码
	private int code;

	// 错误信息,英文
	private String message;
	
	// 错误信息在resource的properties文件中存储的key，用于国际化
	private String resouseMessage;

	public ErrorDTO(int index, String field, int code, String message) {
		super();
		this.index = index;
		this.field = field;
		this.code = code;
		this.message = message;
	}
	
	public ErrorDTO(int index, String field, int code, String message, String resouseMessage) {
		super();
		this.index = index;
		this.field = field;
		this.code = code;
		this.message = message;
		this.resouseMessage = resouseMessage;
	}
	
	public ErrorDTO(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ErrorDTO(int code, String message, String resouseMessage) {
		super();
		this.code = code;
		this.message = message;
		this.resouseMessage = resouseMessage;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
		.append("index", index)
		.append("field", field)
		.append("code", code)
		.append("message", message)
        .toString();
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getResouseMessage() {
		return resouseMessage;
	}

	public void setResouseMessage(String resouseMessage) {
		this.resouseMessage = resouseMessage;
	}
	
}
