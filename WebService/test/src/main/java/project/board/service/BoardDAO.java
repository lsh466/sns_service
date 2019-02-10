package project.board.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.board.DTO.BoardDTO;

@Service("boardDao")
public class BoardDAO {		
		
		@Autowired
		private SqlSession sqlSession;
		
		public List<BoardDTO> showBoardList(){
			
			List<BoardDTO> result = sqlSession.selectList("board.showBoardList");
			System.out.println(result.toString());
		
			return result;
		}
}
