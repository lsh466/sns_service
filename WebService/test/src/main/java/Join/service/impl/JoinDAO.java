package Join.service.impl;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Member.MemberDTO;

@Service
public class JoinDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String namespace = "mapper.JoinMapper";
	
	public MemberDTO getId(String id){
		return sqlSession.selectOne(namespace+".getid");
	}
}
