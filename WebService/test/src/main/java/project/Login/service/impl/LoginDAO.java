package project.Login.service.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Member.MemberDTO;

@Service("loginDao")
public class LoginDAO {

	private static final String namespace = "mapper.LoginMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	public MemberDTO chkIdPw(HashMap<String, Object> params){
		System.out.println("LoginDAO class params 값 : "+params);
		MemberDTO result = sqlSession.selectOne(namespace+".chkIdPw",params);
		System.out.println("LoginDAO 종료");
		return result;
	}
}
