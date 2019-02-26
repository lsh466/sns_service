package project.Login.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import project.Member.MemberDTO;

@Service("loginService")
public interface LoginService {

	//아이디, 비밀번호 확인
	public MemberDTO chkIdPw(HashMap<String, Object> params);
}
