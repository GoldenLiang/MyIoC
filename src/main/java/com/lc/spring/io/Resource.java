package com.lc.spring.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lc
 * Resource 是Spring 内部定位资源的接口
 */
public interface Resource {

	InputStream getInputStream() throws IOException;
}
