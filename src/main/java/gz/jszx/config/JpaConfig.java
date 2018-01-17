package gz.jszx.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
// 此处是你dao文件所在的包名
@EnableJpaRepositories("gz.jszx.dao.jpa")
public class JpaConfig {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.initialSize}")
	private int initialSize;
	@Value("${spring.datasource.minIdle}")
	private int minIdle;
	@Value("${spring.datasource.maxActive}")
	private int maxActive;
	@Value("${spring.datasource.maxWait}")
	private int maxWait;
	@Value("${spring.datasource.validationQuery}")
	private String validationQuery;
	@Value("${spring.datasource.testOnBorrow}")
	private boolean testOnBorrow;
	@Value("${spring.datasource.testOnReturn}")
	private boolean testOnReturn;
	@Value("${spring.datasource.testWhileIdle}")
	private boolean testWhileIdle;
	@Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
	@Value("${spring.datasource.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	@Value("${spring.datasource.removeAbandoned}")
	private boolean removeAbandoned;
	@Value("${spring.datasource.removeAbandonedTimeout}")
	private int removeAbandonedTimeout;
	@Value("${spring.datasource.logAbandoned}")
	private boolean logAbandoned;
	@Value("${spring.datasource.poolPreparedStatements}")
	private boolean poolPreparedStatements;
	@Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;
	@Value("${spring.datasource.filters}")
	private String filters;
	/**
	 * 配置dataSource ，
	 * 关联到AtomikosDataSourceBean中
	 * @return
	 */
	@Primary
	@Bean(name="dataSource_jpa")
	public DataSource dataSource() {
		DruidXADataSource dataSource = new DruidXADataSource();
		dataSource.setUsername(userName);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setPassword(password);
		dataSource.setInitialSize(initialSize);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);
		dataSource.setMaxWait(maxWait);
		dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setTestWhileIdle(testWhileIdle);
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setTestOnReturn(testOnReturn);
		dataSource.setPoolPreparedStatements(poolPreparedStatements);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

		try {  
			dataSource.setFilters(filters);  
        } catch (SQLException e) {  
            e.printStackTrace();
        } 
		AtomikosDataSourceBean atomikosDataSource = new AtomikosDataSourceBean();
		atomikosDataSource.setUniqueResourceName("dataSource_jpa");
		atomikosDataSource.setXaDataSource(dataSource);
		atomikosDataSource.setMinPoolSize(5);
		atomikosDataSource.setMaxPoolSize(20);
		atomikosDataSource.setTestQuery("SELECT 1 from dual");
		return atomikosDataSource;
	}

	/**
	 * Jpa实体工厂类注入
	 * @return
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		// 此处com.example.*.model是你的java bean所在的包名
		factory.setPackagesToScan("gz.jszx.entity");
		factory.setDataSource(dataSource());
		Map<String, Object> jpaProperties = new HashMap<String, Object>();
		jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		jpaProperties.put("hibernate.jdbc.batch_size", 50);
		/*jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		jpaProperties.put("spring.jpa.generate-ddl", true);
		jpaProperties.put("spring.jpa.hibernate.ddl-auto", "update");*/
		jpaProperties.put("spring.jpa.show-sql", true);
		factory.setJpaPropertyMap(jpaProperties);
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	
	/*@Bean(name="Jpa_local") 
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager; 
	}*/
	 
}