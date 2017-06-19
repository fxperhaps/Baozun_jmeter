/*
 * DubboTest.java Created On 2017年6月19日
 * Copyright(c) 2017 Mazan Inc.
 * ALL Rights Reserved.
 */
package com.baozun.test;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cl.user.servicei.UserService;

/**
 * DubboTest
 *
 * @time: 上午10:42:17
 * @author mazan
 */
public class DubboTest extends AbstractJavaSamplerClient {

	// 需要测试的接口
	private ClassPathXmlApplicationContext  appcontext;
	
	@Autowired
	private UserService userService;

	private long start = 0;// 记录测试开始时间；
	private long end = 0;// 记录测试结束时间；

	@Override
	public void setupTest(JavaSamplerContext context) {
		appcontext = new ClassPathXmlApplicationContext(new String[] { "spring/*.xml" });
		appcontext.start();
		userService = (UserService) appcontext.getBean("userService");
	}

	@Override
	public void teardownTest(JavaSamplerContext context) {
		end = System.currentTimeMillis();
		getNewLogger().info("cost time: " + (end - start) + "ms");
		
		if(null != context){
			appcontext.destroy();
		}
	}

	@Override
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("name", "hello dubbo");
		return params;
	}

	public SampleResult runTest(JavaSamplerContext context) {

		String name = context.getParameter("name");
		getNewLogger().info("dubbo test - {}  start", name);
		SampleResult sr = new SampleResult();
		// 开始测试
		sr.sampleStart();
		start = System.currentTimeMillis();
		sr.setSampleLabel("Dubbo请求--sayHello");
		try {

			String result = this.userService.sayHello();
			if (null != result && result.length() > 0) {
				sr.setResponseData("结果是：" + result, null);
				sr.setDataType(SampleResult.TEXT);
			}

			sr.setSuccessful(true);
		} catch (Exception e) {
			sr.setSuccessful(false);
			e.printStackTrace();
		} finally {
			sr.sampleEnd();
		}

		return sr;
	}

}
