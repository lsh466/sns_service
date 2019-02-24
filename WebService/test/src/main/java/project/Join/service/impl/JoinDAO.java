package project.Join.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("joinDao")
public class JoinDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "mapper.JoinMapper";
	//private Logger log = (Logger) LoggerFactory.getLogger(getClass());
	
	//아이디 중복 확인
	public HashMap<String, Object> getId(HashMap<String, Object> params){
		System.out.println("JoinDAO class()의 id : "+params.get("id"));
		return sqlSession.selectOne(namespace+".getid",params);
	}
	
	//회원가입
	public int memberInsert(HashMap<String,  Object> params){
		return sqlSession.insert(namespace+".memberInsert",params);
	}
}
