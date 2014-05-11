package com.taotaoti.common.dto;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 暴露WEB/API接口的返回DTO
 * 
 * @version 2013-5-14 下午2:16:48
 * 
 */
public class SimpleResponseDTO<E> {

	/**
	 * @see Response
	 */
	private int status;

	private E errors;

	private Object result;

	/**
	 * 
	 */
	public SimpleResponseDTO() {
		this(Response.OK,null,null);
	}
	
	/**
	 * @param result
	 */
	public SimpleResponseDTO(Object result) {
		this(Response.OK, null, result);
	}

	/**
	 * @param status
	 * @param errors
	 */
	public SimpleResponseDTO(int status, E errors) {
		this(status, errors, null);
	}

	/**
	 * @param status
	 * @param errors
	 * @param result
	 */
	public SimpleResponseDTO(int status, E errors, Object result) {
		this.status = status;
		this.errors = errors;
		this.result = result;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the errors
	 */
	public E getErrors() {
		return errors;
	}

	/**
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(E errors) {
		this.errors = errors;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @return the result
	 */
	@SuppressWarnings("unchecked")
	public <T> T getResult(Class<T> t) {
		if (result != null) {
			boolean isSubClass = t.isAssignableFrom(result.getClass());
			return isSubClass ? (T) result : null;
		}
		return null;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	public boolean isSuccess() {
		return status == Response.OK;
	}

	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE)
				.append("status", status).append("errors", errors)
				.append("result", result).toString();
	}

}
