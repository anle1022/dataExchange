package gz.jszx.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gz.jszx.dao.jpa.expend.TestDaoCustom;
import gz.jszx.entity.Oa2Sysdic;
import gz.jszx.entity.Test;

@Repository
public interface TestDao extends JpaRepository<Oa2Sysdic, Long>{
	
}
