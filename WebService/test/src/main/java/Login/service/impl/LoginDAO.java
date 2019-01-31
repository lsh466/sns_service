package Login.service.impl;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDAO {

	private static final String namespace = "mapper.LoginMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	public HashMap<String, Object> chkIdPw(HashMap<String, Object> params){
		System.out.println("LoginDAO class params 값 : "+params);
		HashMap<String, Object> result = sqlSession.selectOne(namespace+".chkIdPw",params);
		System.out.println(result);
		return result;
	}
}
