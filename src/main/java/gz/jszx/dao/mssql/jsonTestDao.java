package gz.jszx.dao.mssql;

import gz.jszx.entity.mssql.SmsDxtz;

import org.springframework.stereotype.Repository;

@Repository
public interface jsonTestDao {
	
	public SmsDxtz findDxtzById(int id);
}
