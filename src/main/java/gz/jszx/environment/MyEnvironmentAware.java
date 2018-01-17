package gz.jszx.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 主要是@Configuration，实现接口：EnvironmentAware就能获取到系统环境信息;
 * @author：Andy
 * @company：苍穹广州技术中心
 */
@Configuration
public class MyEnvironmentAware implements EnvironmentAware{

	@Value("${local0.url}")	
	private String url;
	
	@Override
	public void setEnvironment(Environment environment) {
		// TODO Auto-generated method stub
		System.out.println("Oracle数据库访问地址："+url);
		System.out.println("环境变量："+environment.getProperty("JAVA_HOME"));
		System.out.println("数据库用户名："+environment.getProperty("local0.username"));
		RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(environment,"mssql.");
		System.out.println("SqlServer数据库地址："+propertyResolver.getProperty("url"));
	}

}
