package com.lc.spring.bean;

import java.util.HashMap;
import java.util.Map;

import com.lc.spring.io.ResourceLoader;

/**
 * @author lc
 * 从配置中读取BeanDefinition
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

	private Map<String, BeanDefinition> registry;
	
	private ResourceLoader resourceLoader;

	protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
		this.registry = new HashMap<String, BeanDefinition>();
		this.resourceLoader = resourceLoader;
	}
	
	public Map<String, BeanDefinition> getRegistry() {
		return registry;
	}
	
	public ResourceLoader getResourceLoder() {
		return resourceLoader;
	}	

}
