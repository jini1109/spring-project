package org.zerock.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.sample.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = {"org.zerock.mapper"})
@ComponentScan("org.zerock.service")
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		
		hikariConfig.setUsername("book_ex");
		hikariConfig.setPassword("book_ex");
		
		//String JdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		//String userName = "book_ex";
		//String passWord = "book_ex";
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		Connection con = null;
		try { con = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:XE"
							, "book_ex"
							, "book_ex");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dataSource();
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
	
	@Bean
	public UserMapper userMapper() throws Exception {
		SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sessionTemplate.getMapper(UserMapper.class);
	}

}
