package gz.jszx.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import com.alibaba.druid.support.http.WebStatFilter;

public class DruidStatFilter2 {
	
//	@Bean
	public FilterRegistrationBean druidWebStatFilter2(){
		FilterRegistrationBean register = new FilterRegistrationBean(new WebStatFilter());
		register.addServletNames("druidWebStatFilter");
		register.addUrlPatterns("/*");
		register.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
		return register;
	}
}
