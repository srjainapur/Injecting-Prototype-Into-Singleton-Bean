package com.java.bean.scope.bean;

import java.time.LocalDateTime;

public class PrototypeBean {
	private String dateTimeString = LocalDateTime.now().toString();
	
	public String getDateTimeString() {
		return dateTimeString;
	}
}
