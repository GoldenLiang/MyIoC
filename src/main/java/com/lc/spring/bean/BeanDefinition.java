package com.lc.spring.bean;

/**
 * IoC容器内部的数据结构,用来封装Bean 对象
 * @author lc
 *
 */
public class BeanDefinition {

	private Object bean;
	
	private Class beanClass;
	
	private String beanClassName;

	private PropertyValues propertyValues = new PropertyValues();
	
	public BeanDefinition() {
		
	}
	
	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
		try {
			this.beanClass = Class.forName(beanClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setBean(Object bean) {
		this.bean = bean;
	}
	
	public Object getBean() {
		return bean;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}
	
}
