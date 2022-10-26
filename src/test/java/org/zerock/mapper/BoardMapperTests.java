package org.zerock.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"root-context.xml"})
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
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
