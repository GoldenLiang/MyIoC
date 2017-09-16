package com.lc.spring.factory;

import java.lang.reflect.Field;

import com.lc.spring.bean.BeanDefinition;
import com.lc.spring.bean.BeanReference;
import com.lc.spring.bean.PropertyValue;

public class AutoWireCapableBeanFactory extends AbstractBeanFactory {

	@Override
	protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
		Object bean = createBeanInstance(beanDefinition);
		beanDefinition.setBean(bean);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}
	
	protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}
	
	//使用Field 的形式注入，Spring本身使用setter
	protected void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
		for(PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValueList()) {
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());			
			declaredField.setAccessible(true);
			Object value = propertyValue.getValue();
			if(value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getName());
			}
			declaredField.set(bean, value);
		}
	}

}
