package com.ua.robodream.courseProject.Config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://robot-do-user-1968994-0.b.db.ondigitalocean.com:25060/dotsenko");
        dataSource.setUsername("doadmin");
        dataSource.setPassword("AVNS_I6wlDKjGszZn1wvLr9t");
        return dataSource;
    }
}