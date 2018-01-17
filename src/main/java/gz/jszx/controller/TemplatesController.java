package gz.jszx.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplatesController {

	@RequestMapping("/templates/thymeleaf")
	public String thymeleaf(Map<String, Object> map){
		map.put("hello", "你好，这是thymeleaf模板！");
		return "thymeleaf";
	}
	
	@Value("${application.hello:Hello sammy}")
	private String hello;
	
	@RequestMapping("/helloJsp")
	public String helloJsp(Map<String,Object> map){
		System.out.println("TemplatesController.helloJsp:"+hello);
		map.put("helloJsp", hello);
		return "helloJsp";
	}
}
