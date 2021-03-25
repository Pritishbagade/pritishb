package com.demo.tradestore.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.demo.tradestore.service.TradeStoreService;

@Configuration
@EnableScheduling
public class TradeSchedulerConfig {
	@Autowired
	TradeStoreService tradeStoreService;

	 @Scheduled(cron = "0 0 6 * * ?")
	//@Scheduled(cron = "0 * * ? * *")
	public void scheduleExpireFlagUpdate() {
		tradeStoreService.updateExpireFlag();
	}
}
