package com.java.bean.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.java.bean.scope.bean.PrototypeBean;
import com.java.bean.scope.bean.SingletonBean;

@SpringBootApplication
public class BeanScopeApplicationContextApproachApplication {
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PrototypeBean prototypeBean() {
		return new PrototypeBean();
	}
	
	@Bean
	public SingletonBean singletonBean() {
		return new SingletonBean();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext configCtx = SpringApplication.run(BeanScopeApplicationContextApproachApplication.class, args);
		
		SingletonBean bean = configCtx.getBean(SingletonBean.class);
        bean.showMessage();
        Thread.sleep(1000);

        bean = configCtx.getBean(SingletonBean.class);
        bean.showMessage();
	}

}
