package project.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import project.board.DTO.BoardDTO;

@Service("boardService")
public interface BoardService {
	public List<BoardDTO> showBoardList();
	public BoardDTO showBoardItem(HashMap<String, Integer> params);
}
