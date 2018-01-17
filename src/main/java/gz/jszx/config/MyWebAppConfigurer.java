package gz.jszx.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 静态文件资源管理
 * @author Administrator
 *
 */
@Configuration
@EnableWebMvc  
@ComponentScan(basePackages="gz.jszx.config",includeFilters={@Filter(type=FilterType.ANNOTATION,value=Controller.class)})
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	
	/**
	 * 资源文件目录映射
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//uri:/img/**  对应资源文件   /files/
		System.out.println("MyWebAppConfigurer.addResourceHandlers 静态资源管理");
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
		registry.addResourceHandler("/page/**").addResourceLocations("classpath:/page/");
		super.addResourceHandlers(registry);
	}
	
	 @Override 
	 public void configurePathMatch(PathMatchConfigurer configurer) { 
		 super.configurePathMatch(configurer); 
		 configurer.setUseSuffixPatternMatch(false); 
	 }
	/*
	@Bean
	public UrlBasedViewResolver setupViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/page/");
		resolver.setSuffix(".html");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}*/

	@Bean(name = "messageSource")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("com.keyhan.spring_mvc.messages.messages");
		source.setUseCodeAsDefaultMessage(true);
		return source;
	}
}
