package org.zerock.mapper;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	/*
	 * private String URL = "jdbc:oracle:thin:@localhost:1521:XE"; private String Id
	 * = "book_ex"; private String pwd = "book_ex";
	 */
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		
		log.info(mapper.getList());
		mapper.getList().forEach(board -> log.info(board));
		/*
		 * try( //Class.forName("oracle.jdbc.driver.OracleDriver");
		 * 
		 * Connection con = DriverManager.getConnection(URL, Id, pwd)) { log.info(con);
		 * }catch(Exception e) { fail(e.getMessage()); }
		 */
	}
	
	/*
	 * public static void main(String[] args) { try {
	 * Class.forName("oracle.jdbc.driver.OracleDriver");
	 * System.out.println("드라이버 검색 성공"); }catch (ClassNotFoundException e) {
	 * System.out.println("드라이버 검색 실패"); System.exit(0); } }
	 */
	/*

	*/
}
