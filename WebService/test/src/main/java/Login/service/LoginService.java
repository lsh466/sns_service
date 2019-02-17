package Login.service;

import java.util.HashMap;

import Member.MemberDTO;

public interface LoginService {
	
	public MemberDTO chkIdPw(HashMap<String, Object> dto);
	
	
	//아이디, 비밀번호 확인
	//public MemberDTO chkIdPw(HashMap<String, Object> params);
}
