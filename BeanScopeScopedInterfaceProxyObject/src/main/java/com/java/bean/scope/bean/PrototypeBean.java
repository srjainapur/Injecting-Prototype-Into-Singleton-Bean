package com.java.bean.scope.bean;

import java.time.LocalDateTime;

public class PrototypeBean implements IPrototype {
	
	public PrototypeBean() {
		System.out.println("Executing Default Constructor");
	}
	
	private String dateTimeString = LocalDateTime.now().toString();
	
	@Override
	public String getDateTimeString() {
		return dateTimeString;
	}
}
