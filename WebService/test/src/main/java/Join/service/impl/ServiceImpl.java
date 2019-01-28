package Join.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Join.service.JoinService;
import Member.MemberDTO;

@Service
public class ServiceImpl implements JoinService{

	/*@Resource(name="JoinDAO")
	private JoinDAO joindao;*/

	@Autowired
	private JoinDAO joinDao;
	
	//아이디 중복 확인하기
	@Override
	public String getId(String id) {
	
		System.out.println("impl에서 id는 : "+id);
		//System.out.println("joindao()" +JoinDAO.toString());
		return joinDao.getId(id);
	}

	@Override
	public void insert(MemberDTO member) {
		// TODO Auto-generated method stub
		//joindao.insert(member);
	}
	
	
}
