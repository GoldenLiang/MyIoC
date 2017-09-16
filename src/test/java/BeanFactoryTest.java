import java.util.Map;

import org.junit.Test;

import com.lc.spring.bean.BeanDefinition;
import com.lc.spring.bean.PropertyValue;
import com.lc.spring.bean.PropertyValues;
import com.lc.spring.factory.AbstractBeanFactory;
import com.lc.spring.factory.AutoWireCapableBeanFactory;
import com.lc.spring.factory.BeanFactory;
import com.lc.spring.io.ResourceLoader;
import com.lc.spring.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
	
	@Test
	public void test() throws Exception {
		//1.初始化BeanDefinition
		BeanFactory beanFactory = new AutoWireCapableBeanFactory();
			
		//2.bean定义
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("HelloWorldService");	
	
		//3.设置属性
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("text", "Hello IoC"));
		beanDefinition.setPropertyValues(propertyValues);
		
		//4.生成bean
		beanFactory.registerBeanDefinition("helloWorldService", beanDefinition);
		
		//5.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
	
	@Test
	public void testLazy() throws Exception {
		//1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		
		//2.初始化BeanFactory 并注册bean
		AbstractBeanFactory beanFactory = new AutoWireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}
		
		//3.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
	
	@Test
	public void testPreInstantitate() throws Exception {
		//1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		
		//2.初始化BeanFactory 并注册bean
		AbstractBeanFactory beanFactory = new AutoWireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}
		
		//3.初始化bean
		beanFactory.preInstantiateSingletons();
		
		//4.获取bean
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
