package com.java.bean.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.java.bean.scope.bean.PrototypeBean;
import com.java.bean.scope.bean.SingletonBean;

@SpringBootApplication
public class BeanScopeScopedProxyApproachApplication {
	
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode=ScopedProxyMode.TARGET_CLASS)
	public PrototypeBean prototypeBean() {
		return new PrototypeBean();
	}
	
	@Bean
	public SingletonBean singletonBean() {
		return new SingletonBean();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext configCtx = SpringApplication.run(BeanScopeScopedProxyApproachApplication.class, args);
		System.out.println("\n");
		SingletonBean sBean = (SingletonBean)configCtx.getBean(SingletonBean.class);
		sBean.showMessage();
		
		Thread.sleep(2000);
		
		System.out.println("\nAfter 2 second sleep");
		SingletonBean sBean2 = (SingletonBean)configCtx.getBean(SingletonBean.class);
		sBean2.showMessage();
	}

}
