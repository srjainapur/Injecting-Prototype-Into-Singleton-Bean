package com.java.bean.scope.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonBean {
	
	@Autowired
	private IPrototype iPrototype;
	
	public void showMessage(){
        System.out.println("Hi, the time is "+iPrototype.getDateTimeString());
        System.out.println("PrototypeBean HashCode " + iPrototype.hashCode());
    }
}
