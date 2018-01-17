package gz.jszx.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.logging.slf4j.Log4jLogger;
import org.springframework.stereotype.Component;

import com.alibaba.druid.filter.logging.Log4jFilter;
/**
 * 跨域过滤器
 * @author：Andy
 * @company：苍穹广州技术中心
 */
@Component
public class SimpleCORSFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
//        System.out.println("SimpleCORSFilter.doFilter method过滤器被使用**************************"); 
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}




}