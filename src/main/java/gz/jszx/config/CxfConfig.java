package gz.jszx.config;

import gz.jszx.webService.DeptWebService;
import gz.jszx.webService.DeptWebServiceImpl;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;

/**
 * CXF 发布WebService 配置类
 * @author ylf
 *
 */
@Configuration
public class CxfConfig {
	
	public CxfConfig(){
		System.out.println("CxfConfig loaded.....");
	}
	
	/**
	 * 注入CXF类和访问路径
	 * @return
	 */
	@Bean(name="servletRegistrationBean")
	public ServletRegistrationBean dispatcherServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new CXFServlet(), "/services/*");
		registration.setLoadOnStartup(0);  
		registration.setOrder(Ordered.HIGHEST_PRECEDENCE);  
		return registration;
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	/**
	 * webService 接口
	 * @return
	 */
	@Bean
	public DeptWebService webService() {
		return new DeptWebServiceImpl();
	}

	/**
	 * 切入点
	 * @return
	 */
	@DependsOn("servletRegistrationBean")
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), webService());
		endpoint.publish("/users");
		endpoint.setImplementorClass(DeptWebServiceImpl.class);
		return endpoint;
	}
}
