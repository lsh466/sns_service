package Join.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Join.service.Service;
import Member.MemberDTO;

@Repository
public class ServiceImpl implements Service{

	
	@Autowired
	public ServiceImpl(){
		
	}

	//아이디 중복 확인하기
	@Override
	public MemberDTO getId(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
