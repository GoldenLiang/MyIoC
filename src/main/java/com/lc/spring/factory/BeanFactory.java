 package com.lc.spring.factory;

/**
 * 使用HashMap 存储和维护BeanDefinition
 * @author lc
 */
public interface BeanFactory {

	public Object getBean(String name) throws Exception;
		
}
