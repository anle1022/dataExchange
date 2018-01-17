package gz.jszx.controller;

import java.util.List;

import javax.annotation.Resource;

import gz.jszx.dao.jpa.TestDao;
import gz.jszx.dao.mybatis.MybatisDao;
import gz.jszx.entity.Person;
import gz.jszx.entity.Test;
import gz.jszx.service.DynamicScheduledTask;
import gz.jszx.service.jpa.JpaUserService;
import gz.jszx.service.mssql.MssqlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
	
	@Resource
	private TestDao testDao;
	
	@Autowired
	private DynamicScheduledTask service;
	
	@Resource
	private MybatisDao mybatisDao;
	
	@Resource
	private MssqlService mssqlService;
	@Resource
	private JpaUserService jpaService;
	
	@RequestMapping("/jdbc1")
	public Object addByJdbcTemplate(){
		return jpaService.addDemoWithJdbcTemplate();
	}
	@RequestMapping("/jdbc2/{id}")
	public Object findDemoById(@PathVariable String id){
		return jpaService.findDemoById(id);
	}
	
	@RequestMapping("/add")
	public Object addJpaTest(){
		return jpaService.addDemo();
	}
	@RequestMapping("/json")
	public Object returnJson(){
		Person person = new Person("Andy",11);
		return person;
	}
	@RequestMapping("/jsonmssql/{id}")
	public Object returnjson2(@PathVariable int id){
		return mssqlService.findDxtzById(id);
	}
	
	@RequestMapping("/jsonjpa/{id}")
	public Object returnjson3(@PathVariable long id){
		return jpaService.findOa2SysdicById(id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String deleteTest(@PathVariable String id){
//		testDao.delete(id);
		return "ok";
	}
	
	@RequestMapping(value="connect",method=RequestMethod.GET)
	public void connectFTP(){
		
	}
	
	 // http://localhost:8080/RestWebService/getData/Sun/Royi 方式的调用  
    /*@RequestMapping(value = "/textExt")  
    public List<Test> textExt() {  
    	List<Test> textList = testService.textExt();
    	return textList;
    } */
}
