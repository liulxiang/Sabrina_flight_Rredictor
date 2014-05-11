package com.taotaoti.common.dto;

import java.io.Serializable;

/**
 * SimpleErrorDTO
 * 
 * @version 2013-5-13 下午7:13:26
 */
public class SimpleErrorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	private int code;

	/**
	 * 错误信息
	 */
	private String message;

	/**
	 * 其他返回数据
	 */
	private Object data;

	/**
	 * 
	 */
	public SimpleErrorDTO() {
	}

	/**
	 * 
	 */
	public SimpleErrorDTO(Codeable code) {
		this(code.getCode(), code.getMessage());
	}
	
	/**
	 * 
	 */
	public SimpleErrorDTO(Codeable code,Object data) {
		this(code.getCode(), code.getMessage(), data);
	}
	/**
	 * @param code
	 * @param message
	 */
	public SimpleErrorDTO(int code, String message) {
		this(code, message, null);
	}

	/**
	 * @param code
	 * @param message
	 * @param data
	 */
	public SimpleErrorDTO(int code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the data
	 */
	@SuppressWarnings("unchecked")
	public <T> T getData(Class<T> t) {
		if (data != null) {
			boolean isSubClass = t.isAssignableFrom(data.getClass());
			return isSubClass ? (T) data : null;
		}
		return null;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
