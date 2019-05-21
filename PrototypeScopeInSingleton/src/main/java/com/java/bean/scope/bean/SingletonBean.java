package com.java.bean.scope.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonBean {
	
	@Autowired
	public PrototypeBean prototypeBean;
	
	public void showMessage(){
        System.out.println("Hi, the time is "+prototypeBean.getDateTimeString());
    }
}
