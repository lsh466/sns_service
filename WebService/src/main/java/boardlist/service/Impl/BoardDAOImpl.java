package boardlist.service.Impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import DTO.BoardVO;
import boardlist.service.BoardDAO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public List<BoardVO> boardList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("mapper.boardMapper.boardList");
	}

}
