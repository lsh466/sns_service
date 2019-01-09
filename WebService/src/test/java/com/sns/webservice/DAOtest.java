package com.sns.webservice;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class DAOtest {
	@Inject
	private memberDAO memberDao;
	
	
	@Test
	public void testInsertMember()throws Exception{
		MemberVO vo = new MemberVO();
		
		vo.setUser_id("kk");
		
		System.out.println("====================삽입전====================");
		//memberDao.selectUser(vo);
		memberDao.insertMember(vo);
		System.out.println("====================삽입성공====================");
	}
}
