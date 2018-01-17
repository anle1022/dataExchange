package gz.jszx.dao.jpa;

import javax.annotation.Resource;

import gz.jszx.entity.Demo;
import gz.jszx.entity.Dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDao2{

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public int addDemoWithJdbcTemplate(Demo demo){
		String sql ="insert into Demo values(?,?)";
		return jdbcTemplate.update(sql,new Object[]{demo.getId(),demo.getName()});
	}
	
	public Demo findDemoById(String id){
		String sql="select * from demo where id=?";
		RowMapper<Demo> rowMapper = new BeanPropertyRowMapper<Demo>(Demo.class);
		return jdbcTemplate.queryForObject(sql,rowMapper,id);
	}
}
