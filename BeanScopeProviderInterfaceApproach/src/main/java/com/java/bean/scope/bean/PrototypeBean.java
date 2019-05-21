package com.java.bean.scope.bean;

import java.time.LocalDateTime;

public class PrototypeBean {
	private String dateTimeString = LocalDateTime.now().toString();

	public PrototypeBean() {
		System.out.println("executing PrototypeBean default constructor");
	}
	
    public String getDateTime() {
        return dateTimeString;
    }
}
