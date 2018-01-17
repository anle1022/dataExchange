package gz.jszx.dao.jpa;

import gz.jszx.entity.Demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoDao extends JpaRepository<Demo, String>{
	
//	public Demo addDemo(Demo demo);
}
