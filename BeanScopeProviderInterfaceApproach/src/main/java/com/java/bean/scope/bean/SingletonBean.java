package com.java.bean.scope.bean;

import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonBean {
	
	@Autowired
	private Provider<PrototypeBean> prototypeBeanProvider;
	
	public void showMessage () {
        PrototypeBean bean = prototypeBeanProvider.get();
        System.out.println("Hi, the time is " + bean.getDateTime());
    }
}
