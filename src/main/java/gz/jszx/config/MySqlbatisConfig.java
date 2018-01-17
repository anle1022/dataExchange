package gz.jszx.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@MapperScan(basePackages="gz.jszx.dao.mysql", sqlSessionFactoryRef="sqlSessionFactory2")
public class MySqlbatisConfig {
	
	@Value("${mysql.driver}")
	private String driverClassName;
	@Value("${mysql.url}")
	private String url;
	@Value("${mysql.username}")
	private String userName;
	@Value("${mysql.password}")
	private String password;
	@Value("${mysql.initial-size}")
	private int initialSize;
	@Value("${mysql.max-idle}")
	private int maxIdle;
	@Value("${mysql.min-idle}")
	private int minIdle;
	@Value("${mysql.max-active}")
	private int maxActive;
	/*@Value("${mysql.maxWait}")
	private int maxWait;
	@Value("${mysql.validationQuery}")
	private String validationQuery;
	@Value("${mysql.testOnBorrow}")
	private boolean testOnBorrow;
	@Value("${mysql.testOnReturn}")
	private boolean testOnReturn;
	@Value("${mysql.testWhileIdle}")
	private boolean testWhileIdle;
	@Value("${mysql.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
	@Value("${mysql.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	@Value("${mysql.removeAbandoned}")
	private boolean removeAbandoned;
	@Value("${mysql.removeAbandonedTimeout}")
	private int removeAbandonedTimeout;
	@Value("${mysql.logAbandoned}")
	private boolean logAbandoned;
	@Value("${mysql.filters}")
	private String filters;
	@Value("${mysql.poolPreparedStatements}")
	private boolean poolPreparedStatements;
	@Value("${mysql.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;*/
	
	@Bean(name="dataSource_mysql")
	public DataSource atomicDataSource(){
		DruidXADataSource dataSource = new DruidXADataSource();
		dataSource.setUsername(userName);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setPassword(password);
		dataSource.setInitialSize(initialSize);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);
		/*dataSource.setMaxWait(maxWait);
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
        } */
		AtomikosDataSourceBean atomikosDataSource = new AtomikosDataSourceBean();
	    atomikosDataSource.setUniqueResourceName("dataSource_mysql");
	    atomikosDataSource.setXaDataSource(dataSource);
	    atomikosDataSource.setMinPoolSize(5);
	    atomikosDataSource.setMaxPoolSize(20);
	    atomikosDataSource.setTestQuery("SELECT 1 from dual");
	    return atomikosDataSource;
	}
	
	@Bean(name = "sqlSessionFactory2")
	public SqlSessionFactory sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(atomicDataSource());
		bean.setTypeAliasesPackage("gz.jszx.entity");
		// 分页插件
		//PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		//pageHelper.setProperties(properties);

		// 添加插件
		//bean.setPlugins(new Interceptor[] { pageHelper });

		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(
			SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	/*@Bean(name="mybatis_local")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(atomicDataSource());
	}*/
}
