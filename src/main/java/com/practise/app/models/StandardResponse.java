package com.practise.app.models;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StandardResponse<T>{
	/**
	 * 
	 */
	T responseObj;
	List<ErrorCode> errorCode;
	
	
	/**
	 * @return the responseObj
	 */
	public T getResponseObj() {
		return responseObj;
	}
	/**
	 * @param responseObj the responseObj to set
	 */
	public void setResponseObj(T responseObj) {
		this.responseObj = responseObj;
	}
	
	public StandardResponse()
	{}
	
	public StandardResponse(T responseObj)
	{
		this.responseObj=responseObj;
	}
	/**
	 * @return the errorCode
	 */
	public List<ErrorCode> getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(List<ErrorCode> errorCode) {
		this.errorCode = errorCode;
	}

}
