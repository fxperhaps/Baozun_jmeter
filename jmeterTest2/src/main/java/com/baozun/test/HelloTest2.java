package com.baozun.test;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class HelloTest2 extends AbstractJavaSamplerClient {
	/**
	 * input parameter
	 */
	private String name;
	/**
	 * Holds the result data (shown as Response Data in the Tree display).
	 */
	private String resultData;

	/**
	 * 这个方法是用来自定义java方法入参的。 params.addArgument("name","");表示入参名字叫name，默认值为空。
	 * 设置可用参数及的默认值；
	 */
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();
		params.addArgument("name", "");
		return params;
	}

	/**
	 * 每个线程测试前执行一次，做一些初始化工作；
	 */
	public void setupTest(JavaSamplerContext arg0) {
		System.out.println("---- setupTest ----");
	}

	/**
	 * 开始测试，从arg0参数可以获得参数值；
	 */
	public SampleResult runTest(JavaSamplerContext arg0) {
		name = arg0.getParameter("name");
		SampleResult sr = new SampleResult();

		sr.setSampleLabel("Java请求--sayHelloToPerson");
		try {
			// jmeter 开始统计响应时间标记
			sr.sampleStart();

			Hello test = new Hello();

			// 通过下面的操作就可以将被测方法的响应输出到Jmeter的察看结果树中的响应数据里面了。
			resultData = test.sayHelloToPerson(name);

			if (resultData != null && resultData.length() > 0) {
				sr.setResponseData("结果是：" + resultData, null);
				sr.setDataType(SampleResult.TEXT);
			}
			sr.setSuccessful(true);
		} catch (Throwable e) {
			sr.setSuccessful(false);
			e.printStackTrace();
		} finally {
			// jmeter 结束统计响应时间标记
			sr.sampleEnd();
		}
		return sr;
	}

	// 测试结束时调用；
	public void teardownTest(JavaSamplerContext arg0) {
		System.out.println("---- teardown ----");
	}
	
	

}