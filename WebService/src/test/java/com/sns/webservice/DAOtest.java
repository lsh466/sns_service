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
		
		vo.setUserid("koreaa8");
		vo.setUsername("lee");
		vo.setUserpw("1234");
		vo.setUseremail("123@google.com");
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		vo.setReg_date(currentTime);
		
		
		
		System.out.println("====================삽입전====================");
		//memberDao.selectUser(vo);
		memberDao.insertMember(vo);
		System.out.println("====================삽입성공====================");
	}
}
