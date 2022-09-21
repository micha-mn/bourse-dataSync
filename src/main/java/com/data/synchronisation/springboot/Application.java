package com.data.synchronisation.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/*@Bean
	  public ThreadPoolTaskExecutor taskExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(100);
	    executor.setMaxPoolSize(100);
	    executor.setQueueCapacity(500);
	    executor.setThreadNamePrefix("BourseDataSync-");
	    executor.initialize();
	    return executor;
	  }
	  */
}
