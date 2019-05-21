package com.java.bean.scope.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class SingletonBean {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public void showMessage() {
		PrototypeBean prototypeBean = (PrototypeBean)applicationContext.getBean(PrototypeBean.class);
		System.out.println("Hi, the time is "+prototypeBean.getDateTime());
		System.out.println("PrototypeBean HashCode " + prototypeBean.hashCode());
	}
}
