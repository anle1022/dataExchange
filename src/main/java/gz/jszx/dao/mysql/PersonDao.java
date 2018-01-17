package gz.jszx.dao.mysql;

import gz.jszx.entity.Person;

import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao {

	public int addPerson(Person person);
}
