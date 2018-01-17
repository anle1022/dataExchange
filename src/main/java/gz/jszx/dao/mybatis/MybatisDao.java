package gz.jszx.dao.mybatis;

import java.util.List;



import gz.jszx.entity.Oa2Sysdic;
import gz.jszx.entity.Test;

import org.springframework.stereotype.Repository;

@Repository
public interface MybatisDao {
	
	public List<Test> mybatisTest();
	 
	public List<Test> getTestString();

	public void addTest();
	public Oa2Sysdic findOa2SysdicById(long id);
}
