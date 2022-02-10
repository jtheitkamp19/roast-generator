package com.tomcat.service.roastgenerator.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
    /*@Value("${DB_URL}")
    private String databaseURL;

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url(databaseURL);

        System.out.println("Custom Datasource set");
        return builder.build();
    }*/
}
