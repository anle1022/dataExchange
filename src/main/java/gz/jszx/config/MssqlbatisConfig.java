package gz.jszx.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
@MapperScan(basePackages="gz.jszx.dao.mssql", sqlSessionFactoryRef="sqlSessionFactory_mssql")
public class MssqlbatisConfig {
//	static final String PACKAGE = "com.jyall.ehr.mapper";
	@Value("${mssql.driver}")
	private String driverClassName;
	@Value("${mssql.url}")
	private String url;
	@Value("${mssql.username}")
	private String userName;
	@Value("${mssql.password}")
	private String password;
	@Value("${spring.datasource.initialSize}")
	private int initialSize;
	@Value("${spring.datasource.minIdle}")
	private int minIdle;
	@Value("${spring.datasource.maxActive}")
	private int maxActive;
	@Value("${spring.datasource.maxWait}")
	private int maxWait;
	@Value("${mssql.validationQuery}")
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
	@Value("${spring.datasource.filters}")
	private String filters;
	@Value("${spring.datasource.poolPreparedStatements}")
	private boolean poolPreparedStatements;
	@Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;
	
	@Bean(name="dataSource_mssql")
	public DataSource mssqlDataSource(){
		DruidDataSource dataSource = new DruidDataSource();
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
		/*AtomikosDataSourceBean atomikosDataSource = new AtomikosDataSourceBean();
	    atomikosDataSource.setUniqueResourceName("dataSource_mssql");
	    atomikosDataSource.setXaDataSource(dataSource);
	    atomikosDataSource.setMinPoolSize(5);
	    atomikosDataSource.setMaxPoolSize(20);
	    atomikosDataSource.setTestQuery(validationQuery);*/
	    return dataSource;
	}
	
	@Bean(name = "sqlSessionFactory_mssql")
	public SqlSessionFactory sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(mssqlDataSource());
		bean.setTypeAliasesPackage("gz.jszx.entity.mssql");
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
			bean.setMapperLocations(resolver.getResources("classpath:mapper/mssql/*.xml"));
			return bean.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	/*@Bean(name="msTransactionManager")
	public DataSourceTransactionManager msTransactionManager(@Qualifier("dataSource_mssql") DataSource dataSource ) {
		return new DataSourceTransactionManager(mssqlDataSource());
	}*/
}
