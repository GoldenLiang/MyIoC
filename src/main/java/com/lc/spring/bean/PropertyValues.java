package com.lc.spring.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lc
 * 包装一个对象的所有PropertyValue 
 * 使用封装而不直接用List 的原因？可以封装一些操作
 */
public class PropertyValues {
	
	private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();
	
	public PropertyValues() {
		
	}
	
	public void addPropertyValue(PropertyValue pv) {
		//这里可以对重复PropertyName 进行判断，直接使用List 做不到
		this.propertyValueList.add(pv);
	}
	
	public List<PropertyValue> getPropertyValueList() {
		return this.propertyValueList;
	}
}
