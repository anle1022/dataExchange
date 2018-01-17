package gz.jszx.config;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.atomikos.icatch.jta.UserTransactionManager;

@Configuration
public class JtaConfig {

	@Bean
	public UserTransaction userTransaction() throws SystemException{
		UserTransaction userTransaction = new UserTransactionManager();
		userTransaction.setTransactionTimeout(1000);
		return userTransaction;
	}
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager jtaTransactionManager() throws SystemException{
		UserTransactionManager userTransactionManager = new UserTransactionManager();
		JtaTransactionManager manager = new JtaTransactionManager(userTransaction(),userTransactionManager);
		return manager;
	}
	
}
