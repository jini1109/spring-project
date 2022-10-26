package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class DataSourceTests {
@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	@Test
	public void testConnection() {
		
		try(Connection con = dataSource.getConnection()){
			
			log.info(con);
			
		}catch(Exception e) {
			fail(e.getMessage());
		}
		
	}
	
	
}
