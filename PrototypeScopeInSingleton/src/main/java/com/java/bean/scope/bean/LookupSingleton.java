package com.java.bean.scope.bean;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class LookupSingleton {
	
	public void showMessage() {
		PrototypeBean protBean = getPrototypeBean();
		System.out.println("Hi, the time is "+ protBean.getDateTimeString());
	}
	
	@Lookup
	public PrototypeBean getPrototypeBean() {
		// spring will override this method
		return null;
	}
}
