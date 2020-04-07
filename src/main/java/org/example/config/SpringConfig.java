package org.example.config;

import org.example.dao.UserDao;
import org.example.dao.UserDaoImpl;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSourse());
    }

    @Bean
    public DataSource getDataSourse(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/springapp?useSll=false?serverTimezone=UTC");
        dataSource.setUsername("***");
        dataSource.setPassword("***");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }

    @Bean
    public UserService getUserService(){
        return new UserServiceImpl();
    }

}
