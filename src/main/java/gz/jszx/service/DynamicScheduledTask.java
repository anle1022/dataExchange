package gz.jszx.service;

import java.util.Date;


import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service
public class DynamicScheduledTask implements SchedulingConfigurer{

	private String cron = "0/10 * * * * ?";
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(new Runnable() {
			
			@Override
			public void run() {
				//System.out.println("DynamicScheduledTask:"+DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
			}
		}, new Trigger() {
			
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				CronTrigger trigger = new CronTrigger(cron);
				Date nextExecDate = trigger.nextExecutionTime(triggerContext);
			    return nextExecDate;
			}
		});
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

}
