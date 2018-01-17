package gz.jszx.dao.jpa;

import gz.jszx.entity.BdcUser;
import gz.jszx.entity.Dept;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<BdcUser, String>{

	@Query("from BdcUser u where u.unitno=?1")
	public BdcUser findBdcUserByUnitno(String unitno);
	
}
