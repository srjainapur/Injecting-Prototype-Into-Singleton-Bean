package com.java.bean.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import com.java.bean.scope.bean.IPrototype;
import com.java.bean.scope.bean.PrototypeBean;
import com.java.bean.scope.bean.SingletonBean;

@SpringBootApplication
public class BeanScopeScopedInterfaceProxyObjectApplication {
	
	@Bean
	@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode=ScopedProxyMode.INTERFACES)
	public IPrototype prototypeBean() {
		return new PrototypeBean();
	}
	
	@Bean
	public SingletonBean singletonBean() {
		return new SingletonBean();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext configCtx = SpringApplication.run(BeanScopeScopedInterfaceProxyObjectApplication.class, args);
		
		System.out.println("\n");
		SingletonBean bean = configCtx.getBean(SingletonBean.class);
        bean.showMessage();
        Thread.sleep(1000);
        
        System.out.println("\nAfter 2 second sleep");
        SingletonBean bean2 = configCtx.getBean(SingletonBean.class);
        bean2.showMessage();
	}

}
