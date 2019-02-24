package project.Join.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service("JoinService")
public interface JoinService {
	//아이디 중복 확인
	public HashMap<String, Object> getId(HashMap<String, Object> params);
	
	//회원가입
	public HashMap<String, Object> memberInsert(HttpServletRequest request, HashMap<String, Object> params);
}
