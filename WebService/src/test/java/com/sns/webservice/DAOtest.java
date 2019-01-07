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
	private Service service;
	/*@Test
	public void testTime()throws Exception{
		System.out.println(dao.getTime());
	}*/
	@Test
	public void testInsertMember()throws Exception{
		MemberVO vo = new MemberVO();
		
		vo.setUser_id("koreaa8");
		vo.setUser_name("리경태");
		vo.setUser_pw("1234");
		
		System.out.println("====================삽입전====================");
		service.insertMember(vo);
		System.out.println("====================삽입성공====================");
	}
}
