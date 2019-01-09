package com.sns.webservice;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MemberDAOImpl implements memberDAO{

	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "mapper.memberMapper";
	
	

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		System.out.println("들어왔다");
		System.out.println(vo.getUser_id());
		System.out.println(vo.getUser_name());
		System.out.println(vo.getUser_pw());
		System.out.println(vo.getUser_email());
		
		sqlSession.insert(namespace+".insertMember",vo);
		System.out.println("end");
	}



	@Override
	public void selectUser(MemberVO member) {
		// TODO Auto-generated method stub
		System.out.println("Select start");
		sqlSession.select(namespace+".selectUser", (ResultHandler) member);
		System.out.println("Select end");
	}

	
	
	
	
	
	

}
