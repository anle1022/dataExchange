package gz.jszx.dao.jpa.expend;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.NoRepositoryBean;

import gz.jszx.entity.Test;

@NoRepositoryBean
public class TestDaoImpl implements TestDaoCustom{
    
	@PersistenceContext  
	private EntityManager em;
 
	@SuppressWarnings("unchecked")
	@Override
	public List<Test> getTestString() {
		return  em.createQuery("from Test").getResultList() ;
	}

}