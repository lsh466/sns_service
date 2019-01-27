package Join.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import Join.service.JoinService;
import Member.MemberDTO;

@Service
public class ServiceImpl implements JoinService{

	@Inject
	private JoinDAO joindao;
	//아이디 중복 확인하기
	@Override
	public MemberDTO getId(String id) {
	
		System.out.println("impl에서 id는 : "+id);
		return joindao.getId(id);
	}
	
	
}
