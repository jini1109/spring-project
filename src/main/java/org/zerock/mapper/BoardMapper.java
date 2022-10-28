package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;

@Mapper
public interface BoardMapper {
	
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();

}
