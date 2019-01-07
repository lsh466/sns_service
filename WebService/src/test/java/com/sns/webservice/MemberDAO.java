package com.sns.webservice;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO implements Service{

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "mapper.memberMapper";
	
	@Override
	public void insertMember(MemberVO member) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertMember",member);
		System.out.println("들어갔다 왓음");
		
	}

	
}
