package gz.jszx.webService;

import gz.jszx.dao.jpa.DemoDao2;
import gz.jszx.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptWebServiceImpl implements DeptWebService{

	@Autowired
	private DemoDao2 deptDao;
	
	
	@Override
	public String findDepts() {
//		return JsonUtil.toJson( deptDao.findAll());
		return "";
	}


	@Override
	public int add(int i, int j) {
		return i+j;
	}

}
