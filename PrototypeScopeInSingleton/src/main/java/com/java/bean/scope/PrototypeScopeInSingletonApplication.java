package com.java.bean.scope;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import com.java.bean.scope.bean.LookupSingleton;
import com.java.bean.scope.bean.PrototypeBean;
import com.java.bean.scope.bean.SingletonBean;

@SpringBootApplication
public class PrototypeScopeInSingletonApplication {

	@Bean("prototypeBean")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public PrototypeBean prototypeBean() {
		return new PrototypeBean();
	}
	
	@Bean("singletonBean")
	public SingletonBean singletonBean() {
		return new SingletonBean();
	}
	
	/*@Bean("lookupSingleton")
	public LookupSingleton lookupSingleton() {
		return new LookupSingleton();
	}*/
	
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext configCtx = SpringApplication.run(PrototypeScopeInSingletonApplication.class, args);
		
		SingletonBean sBean = (SingletonBean)configCtx.getBean("singletonBean");
		sBean.showMessage();
		System.out.println("Prototype Bean HashCode " + sBean.prototypeBean.hashCode());
		
		Thread.sleep(1000);
	
		sBean = (SingletonBean)configCtx.getBean("singletonBean");
		System.out.println("Prototype Bean HashCode " +sBean.prototypeBean.hashCode());
		sBean.showMessage();
		
		System.out.println("\nAfter getting Prototype bean from Lookup");
		LookupSingleton lookUpBean = (LookupSingleton)configCtx.getBean("lookupSingleton");
		lookUpBean.showMessage();
		System.out.println("Prototype Bean HashCode " +lookUpBean.getPrototypeBean().hashCode());
		
		Thread.sleep(1000);
		lookUpBean = (LookupSingleton)configCtx.getBean("lookupSingleton");
		System.out.println("Prototype Bean HashCode "+lookUpBean.getPrototypeBean().hashCode());
		lookUpBean.showMessage();
	}
	
}
