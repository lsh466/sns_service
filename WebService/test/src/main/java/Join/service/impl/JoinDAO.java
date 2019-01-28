package Join.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Member.MemberDTO;

@Service
public class JoinDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "mapper.JoinMapper";
	
	public String getId(String id){
		System.out.println("JoinDAO class()의 id : "+id);
		return sqlSession.selectOne(namespace+".getid",id);
	}
	
	
	public void insert(MemberDTO vo){
		sqlSession.insert(namespace+".insertMember",vo);
	}
}
