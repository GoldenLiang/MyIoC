package com.lc.spring.context;

import com.lc.spring.factory.AbstractBeanFactory;

/**
 * @author lc
 * 用来实现 从不同来源的不同类型的资源加载类定义 的效果
 */
public abstract class AbstractApplicationContext implements ApplicationContext {
	
	protected AbstractBeanFactory beanFactory;
	
	public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	public void refresh() throws Exception {
		
	}
	
	public Object getBean(String name) throws Exception {
		return beanFactory.getBean(name);
	}
}
