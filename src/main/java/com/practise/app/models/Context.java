package com.practise.app.models;

import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class Context {
	String action;
	String userId;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
