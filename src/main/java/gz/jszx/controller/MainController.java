package gz.jszx.controller;

import gz.jszx.test.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@Autowired
	private User user;
	
	@RequestMapping(value={"/login","/"})
	public String login(ModelMap map){
		map.put("username", "ylf");
		return "index";
	}
	
	@RequestMapping("/test1")
	public @ResponseBody String test1(){
		System.out.println(user.getJob());
		return "ok";
	}
	
}
