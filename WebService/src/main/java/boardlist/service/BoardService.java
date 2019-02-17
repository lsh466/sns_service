package boardlist.service;

import java.util.List;

import DTO.BoardVO;

public interface BoardService {
	public List<BoardVO> boardList() throws Exception;
}
