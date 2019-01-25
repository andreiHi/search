package com.arrival;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@ComponentScan
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement(proxyTargetClass = true)
@EntityScan(basePackages="com.arrival.entities")
public class ArrivalApplication {
	public static ConfigurableApplicationContext APPLICATION_CONTEXT;

	public static void main(String[] args) {
		APPLICATION_CONTEXT = SpringApplication.run(ArrivalApplication.class, args);
	}
}
