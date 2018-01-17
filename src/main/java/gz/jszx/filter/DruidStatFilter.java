package gz.jszx.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/druid/*", 
	initParams = { 
		@WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/*") // 忽略资源
})
public class DruidStatFilter extends WebStatFilter {

	
}