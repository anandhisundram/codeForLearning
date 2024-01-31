package com.practise.app.models;

import org.springframework.stereotype.Component;

@Component
public class StandardRequest<T> {
	/**
	 * 
	 */
	Context context;
	T payload;
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
	public T getPayload() {
		return payload;
	}
	/**
	 * @param payload the payload to set
	 */
	public void setPayload(T payload) {
		this.payload = payload;
	}

}
