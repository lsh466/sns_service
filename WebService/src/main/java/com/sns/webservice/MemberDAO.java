package com.sns.webservice;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {
	private SqlSession sqlSession;
	private static final String namespace = "mapper.memberMapper";
	
	
	public void insertMember(MemberVO member) {
		// TODO Auto-generated method stub
		System.out.println("DAO까지 왔음");
		sqlSession.insert(namespace+".insertMember",member);
		System.out.println("들어갔다 왓음");
		
	}
}
