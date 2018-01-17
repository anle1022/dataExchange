package gz.jszx.controller;


import javax.annotation.Resource;
import gz.jszx.service.jpa.JpaUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private JpaUserService userService;
	
	@RequestMapping(value="/findUser",produces="text/html;charset=utf-8")
	public String findUser(String unitno){
		return userService.findUserByUnitno(unitno);
	}
	
	@RequestMapping(value="/addUser",produces="text/html;charset=utf-8")
	public String addUser(String unitno){
		return userService.addUser(unitno);
	}
}
