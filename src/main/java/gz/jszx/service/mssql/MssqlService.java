package gz.jszx.service.mssql;

import gz.jszx.dao.mssql.jsonTestDao;
import gz.jszx.entity.mssql.SmsDxtz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MssqlService {
	
	@Autowired
	private jsonTestDao testDao;
	
	public SmsDxtz findDxtzById(int id){
		SmsDxtz dxtz = null;
		dxtz = testDao.findDxtzById(id);
		System.out.println(dxtz.toString());
		return dxtz;
	}
}
