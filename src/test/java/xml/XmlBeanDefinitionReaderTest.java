package xml;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.lc.spring.bean.BeanDefinition;
import com.lc.spring.io.ResourceLoader;
import com.lc.spring.xml.XmlBeanDefinitionReader;

public class XmlBeanDefinitionReaderTest {

	@Test
	public void test() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
		xmlBeanDefinitionReader.loadBeanDefinitions("tinyioc.xml");
		Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
		Assert.assertTrue(registry.size() > 0);
	}
}
