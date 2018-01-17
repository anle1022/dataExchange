package gz.jszx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class ScheduledTask {

	@Autowired
	private ScheduledTask task;
	
	@Scheduled(cron="0 0/1 * * * ?") 
	public void toDo(){
		//System.out.println(DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:dd"));
	}
}
