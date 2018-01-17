package gz.jszx.controller;

import java.util.List;

import gz.jszx.dao.jpa.DemoDao2;
import gz.jszx.entity.Dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/dept")
@CacheConfig(cacheNames="users")
public class DeptController {
	
	@Autowired
	private DemoDao2 deptDao;
	
	@RequestMapping(value="/dept",method=RequestMethod.POST)
	public String addDept(Dept dept){
//		deptDao.save(dept);
		return "ok";
	}
	
	/*@RequestMapping("/findAll")
	@ResponseBody
	@Cacheable
	public List<Dept> findAll(){
		return (List<Dept>) deptDao.findAll();
	}*/
	
}
