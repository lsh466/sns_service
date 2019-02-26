package Login.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import Login.service.LoginService;
import Member.MemberDTO;

@Repository
public class LoginServiceImpl implements LoginService{

	@Resource(name="loginDao")
	private LoginDAO loginDao;

	@Override
	public MemberDTO chkIdPw(HashMap<String, Object> param) {
		return loginDao.chkIdPw(param);
	}
	
	
	//로그인 아이디, 비밀번호 확인
	/*@Override
	public HashMap<String, Object> chkIdPw(HashMap<String, Object> params) {
		// TODO Auto-generated method stub
		System.out.println("LoginServiceImpl class 동작");
		HashMap<String, Object> result = new HashMap<String, Object>();
		HashMap<String, Object> getList = loginDao.chkIdPw(params);
		
		result.put("data", getList);
		
		//result = {data={USER_ID=t001, USER_PW=t001}}
		System.out.println("LoginServiceImpl class result값" + result);
		
		return result;
	}*/

	
	

}
