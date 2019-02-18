package Login.service.impl;

import java.util.HashMap;	

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Member.MemberDTO;

public class LoginDAO {

	private static final String namespace = "mapper.LoginMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	public MemberDTO chkIdPw(HashMap<String, Object> param){
		System.out.println("LoginDAO class");
		MemberDTO result = sqlSession.selectOne(namespace+".chkIdPw",param);
		System.out.println("LoginDAO class selectOne 실행됨");
		return result;
	}
	
}
