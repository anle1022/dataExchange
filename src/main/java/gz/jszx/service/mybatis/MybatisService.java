package gz.jszx.service.mybatis;

import gz.jszx.dao.mybatis.MybatisDao;
import gz.jszx.entity.Oa2Sysdic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MybatisService {

	@Autowired
	private MybatisDao mybatisDao;
	
	public Oa2Sysdic findOa2SysdicByID(long id){
		Oa2Sysdic sysdic = mybatisDao.findOa2SysdicById(id);
		System.out.println(sysdic.toString());
		return sysdic;
	}
}
