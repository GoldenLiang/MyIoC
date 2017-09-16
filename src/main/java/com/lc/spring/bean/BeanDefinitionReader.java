package com.lc.spring.bean;

public interface BeanDefinitionReader {

	void loadBeanDefinitions(String location) throws Exception;
}
