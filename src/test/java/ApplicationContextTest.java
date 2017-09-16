

import org.junit.Test;

import com.lc.spring.context.ApplicationContext;
import com.lc.spring.context.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

	@Test
	public void test() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("tinyioc.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.helloWorld();
	}
}
