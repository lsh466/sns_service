package project.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.board.DTO.BoardDTO;
import project.board.service.BoardDAO;
import project.board.service.BoardService;

@Component
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDao;
	@Override
	public List<BoardDTO> showBoardList() {
		// TODO Auto-generated method stub
		return boardDao.showBoardList();
	}

}
