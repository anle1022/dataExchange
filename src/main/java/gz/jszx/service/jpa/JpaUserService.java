package gz.jszx.service.jpa;

import gz.jszx.dao.jpa.DemoDao;
import gz.jszx.dao.jpa.DemoDao2;
import gz.jszx.dao.jpa.TestDao;
import gz.jszx.dao.jpa.UserDao;
import gz.jszx.dao.mybatis.UserMytaisDao;
import gz.jszx.dao.mysql.PersonDao;
import gz.jszx.entity.BdcUser;
import gz.jszx.entity.Demo;
import gz.jszx.entity.Oa2Sysdic;
import gz.jszx.entity.Person;
import gz.jszx.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaUserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserMytaisDao userMytaisDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private TestDao jpaDao;
	@Autowired
	private DemoDao demoDao;
	@Autowired
	private DemoDao2 demo2;
	
	public int addDemoWithJdbcTemplate(){
		Demo demo = new Demo("sammy", "山姆");
		return demo2.addDemoWithJdbcTemplate(demo);
	}
	
	public Demo findDemoById(String id){
		return demo2.findDemoById(id);
	}
	
	public Demo addDemo(){
		Demo demo = new Demo("andy","安乐");
		demoDao.save(demo);
		return demo;
	}
	
	public Oa2Sysdic findOa2SysdicById(long id){
		Oa2Sysdic sysdic = jpaDao.findOne(id);
		System.out.println(sysdic.toString());
		return sysdic;
	}
	
	public String findUserByUnitno(String unitno){
		BdcUser user = userDao.findBdcUserByUnitno(unitno);
		if(user != null){
			return JsonUtil.toJson(user);
		}
		return null;
	}
	
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.REQUIRED) 
	public String addUser(String unitno){
//		BdcUser user = new BdcUser("安乐","123");
		Integer i=0;
		try {
			BdcUser user = userDao.findBdcUserByUnitno(unitno);
			if(user != null){
				user.setUnitno(user.getUnitno()+"mybatis");
				i =userMytaisDao.addUserByMyBatis(user);
				Person person = new Person();
				person.setName(user.getUnitno());
				i = personDao.addPerson(person)+i;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i+"";
	}
}
