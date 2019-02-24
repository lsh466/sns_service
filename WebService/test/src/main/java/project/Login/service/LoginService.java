package Login.service;

import java.util.HashMap;

public interface LoginService {

	//아이디, 비밀번호 확인
	public HashMap<String, Object> chkIdPw(HashMap<String, Object> params);
}
