import java.util.Map;

import org.junit.Test;

import com.lc.spring.bean.BeanDefinition;
import com.lc.spring.factory.AutoWireCapableBeanFactory;
import com.lc.spring.factory.BeanFactory;
import com.lc.spring.io.ResourceLoader;
import com.lc.spring.xml.XmlBeanDefinitionReader;

public class XmlTest {

	@Test
	public void test() throws Exception {
		//1.读取配置
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		
		//2.
		BeanFactory beanFactory = new AutoWireCapableBeanFactory();
		for(Map.Entry<String, BeanDefinition> entry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
			beanFactory.registerBeanDefinition(entry.getKey(), entry.getValue());
		}
		
		//3.
		HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}

}
