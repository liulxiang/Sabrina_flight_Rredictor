package com.taotaoti.common.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 
 * 暴露WEB/API接口的返回DTO
 *
 * @version 2013-4-12 下午3:21:44
 * @see Response
 */
public class ResponseDTO<T, E> {

	int status = Response.OK;
	
	private List<E> errors = new ArrayList<E>();

	private List<T> result;

	public List<E> getErrors() {
		return errors;
	}

	public void setErrors(List<E> errors) {
		this.errors = errors;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}
	
	public boolean isSuccess(){
		return errors.size() == 0 ? true : false;
	}
	
	public int getErrorNum(){
		return errors.size();
	}
	
	public int getResultSize(){
		if (result != null) {
			return result.size();
		}
		return 0;
	}
	
	public String toString(){
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
		.append("status", status)
		.append("errors", errors)
		.append("result", result)
        .toString();
	}

}
