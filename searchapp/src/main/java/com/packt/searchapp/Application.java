package com.packt.searchapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.token.Token;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 31.12.2018.
 * @version $Id$.
 * @since 0.1.
 */
@SpringBootApplication
//@ComponentScan
@EnableTransactionManagement(proxyTargetClass = true)
public class Application {
    private static final Logger LOG = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
//    @Autowired
//    TokenStore tokenStore;
//    @Bean
////    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
////        return args -> {
////            System.out.println("Beans provided by Spring Boot");
////            String[] beanNames = ctx.getBeanDefinitionNames();
////            Arrays.sort(beanNames);
////            Arrays.asList(beanNames).forEach(System.out::println);
////
////        };
////    }
}

