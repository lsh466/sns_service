package Login.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import Login.service.LoginService;

public class LoginServiceImpl implements LoginService{

	@Resource(name="loginDao")
	private LoginDAO loginDao;
	
	//로그인 아이디, 비밀번호 확인
	@Override
	public HashMap<String, Object> chkIdPw(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		System.out.println("LoginServiceImpl class 동작");
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> getList = loginDao.chkIdPw(params);
		
		//System.out.println("아이디와 비밀번호는 ==> "+getList);
		result.put("data", getList);
		return result;
	}

	
	

}
