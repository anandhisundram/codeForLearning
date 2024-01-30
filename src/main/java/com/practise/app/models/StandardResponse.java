package com.practise.app.models;

import java.util.List;

public class StandardResponse {
	/**
	 * 
	 */
	Context context;
	Payload payload;
	List<ErrorCode> errorCode;
	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}
	/**
	 * @param context the context to set
	 */
	public void setContext(Context context) {
		this.context = context;
	}
	/**
	 * @return the payload
	 */
	public Payload getPayload() {
		return payload;
	}
	/**
	 * @param payload the payload to set
	 */
	public void setPayload(Payload payload) {
		this.payload = payload;
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
