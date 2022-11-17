package org.zerock.mapper;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() { 
		//BasicConfigurator.configure();
		log.info(mapper.getList());
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		//BasicConfigurator.configure();
		
		BoardVO board = new BoardVO();
		board.setTitle("���� �ۼ��ϴ� ��");
		board.setContent("���� �ۼ��ϴ� ����");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		//BasicConfigurator.configure();
		
		BoardVO board = new BoardVO();
		board.setTitle("���� �ۼ��ϴ� �� select key");
		board.setContent("���� �ۼ��ϴ� ���� select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		//BasicConfigurator.configure();
		
		BoardVO board = mapper.read(1L);
		
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		//BasicConfigurator.configure();
		
		log.info("DELETE COUNT: " + mapper.delete(1L));
	}
	
	@Test
	public void testUpdate() {
		BasicConfigurator.configure();
		
		BoardVO board = new BoardVO();
		board.setBno(4L);
		board.setTitle("������ ����");
		board.setContent("������ ����");
		board.setWriter("user00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
	}
}
