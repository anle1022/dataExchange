package gz.jszx.filter;

import org.apache.logging.log4j.core.config.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
//@Order(2)
public class MyStartRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------------服务启动执行，执行加载数据12345-----------------");
	}

}
