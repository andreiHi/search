//package com.packt.searchapp.configuration;
//
//import com.packt.searchapp.domain.Topic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//
///**
// * @author Hincu Andrei (andreih1981@gmail.com)on 11.01.2019.
// * @version $Id$.
// * @since 0.1.
// */
//@Configuration
//public class CustomRestMvcConfiguration {
//
//    @Bean
//    public RepositoryRestConfigurer repositoryRestConfigurer() {
//        return new RepositoryRestConfigurer() {
//            @Override
//            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//                config.exposeIdsFor(Topic.class);
//                config.setReturnBodyForPutAndPost(true);
//            }
//        };
//    }
//}
