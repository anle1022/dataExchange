package gz.jszx.dao.mybatis;

import gz.jszx.entity.BdcUser;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMytaisDao {

	public int addUserByMyBatis(BdcUser user);
}
