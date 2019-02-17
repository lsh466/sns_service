package boardlist.service.Impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import DTO.BoardVO;
import boardlist.service.BoardDAO;
import boardlist.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO boardDao;
	
	@Override
	public List<BoardVO> boardList() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.boardList();
	}
}
