package com.sea.swallow.model;

import java.io.Serializable;

/**
 * 请求包含的结果集
 * @author Administrator
 *
 * @param <T>
 */
public class ResultInfo<T> implements Serializable {

	private static final long serialVersionUID = 8013879066694115552L;
    
	/**
	 *  api接口请求状态 0 成功 1失败
	 */
	private int httpStatus;
	/**
	 * 请求包含的信息
	 */
	private String message;
	/**
	 * 服务器响应的数据
	 */
	private T data;
	
	public ResultInfo(){
		
	}
	
	public ResultInfo(int httpStatus,String message,T data)
	{
		this.httpStatus=httpStatus;
		this.message=message;
		this.data=data;
	}
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
