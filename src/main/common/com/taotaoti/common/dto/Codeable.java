package com.taotaoti.common.dto;

import java.io.Serializable;


/**
 * Codeable
 *
 * @version 2013-5-14 下午4:07:56
 */
public interface Codeable extends Serializable{
	
	/**
	 * 获取编码(如异常编码、错误编码等)
	 * <p>
	 *
	 * @return
	 */
	int getCode();

	/**
	 * 获取编码(如异常编码、错误编码等)对应的信息
	 * <p>
	 *
	 * @return
	 */
	String getMessage();
}
