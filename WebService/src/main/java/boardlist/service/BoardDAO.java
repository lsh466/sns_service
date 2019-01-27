package boardlist.service;

import java.util.List;

import DTO.BoardVO;


public interface BoardDAO {
	public List<BoardVO> boardList() throws Exception;
}
