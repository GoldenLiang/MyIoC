package io;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import com.lc.spring.io.Resource;
import com.lc.spring.io.ResourceLoader;

public class ResourceLoaderTest {

	@Test
	public void test() throws IOException {
		ResourceLoader resourceLoader = new ResourceLoader();
		Resource resource = resourceLoader.getResource("tinyioc.xml");
		InputStream inputStream = resource.getInputStream();
		Assert.assertNotNull(inputStream);
	}
}
