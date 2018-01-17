package com.example;

import static org.junit.Assert.*;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

public class WsTest {

	@Test
	public void test() throws Exception {
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		Client client = factory.createClient("http://192.168.9.246:8088/ttfsws/services/ExternalInterfaceWS?wsdl");
		Object[] invoke = client.invoke("add", new Object[]{});
		System.out.println(invoke[0].toString());
	}

}
