package com.lc.spring.context;

import java.util.Map;

import com.lc.spring.bean.BeanDefinition;
import com.lc.spring.factory.AbstractBeanFactory;
import com.lc.spring.factory.AutoWireCapableBeanFactory;
import com.lc.spring.io.ResourceLoader;
import com.lc.spring.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	private String configLocation;
	
	public ClassPathXmlApplicationContext(String configLocation) throws Exception {
		this(configLocation, new AutoWireCapableBeanFactory());
	}

	public ClassPathXmlApplicationContext(String configLocation,
			AbstractBeanFactory beanFactory) throws Exception {
		super(beanFactory);
		this.configLocation = configLocation;
		refresh();
	}

	public void refresh(String name, BeanDefinition beanDefinition) throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
		for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}
	}	
	
}
