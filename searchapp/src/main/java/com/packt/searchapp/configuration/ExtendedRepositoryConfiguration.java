package com.packt.searchapp.configuration;

import com.packt.searchapp.repository.ExtendedRepositoryImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Hincu Andrei (andreih1981@gmail.com)on 07.01.2019.
 * @version $Id$.
 * @since 0.1.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.packt.searchapp.repository", repositoryBaseClass = ExtendedRepositoryImpl.class)
public class ExtendedRepositoryConfiguration {

}
