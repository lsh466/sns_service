package project.Login.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import project.Login.service.LoginService;
import project.Member.MemberDTO;

@Component
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDAO loginDao;
	
	//로그인 아이디, 비밀번호 확인
	@Override
	public MemberDTO chkIdPw(HashMap<String, Object> params) {
		return loginDao.chkIdPw(params);
	}
	
	

}
