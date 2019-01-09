package com.sns.webservice;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {

	private MemberDAO memberDao;
	
	//로그인 화면을 띄우기 위한 RequestMapping
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String main(HttpServletResponse response, HttpServletRequest request, @RequestParam HashMap<String, Object> params){
		
		ModelAndView mav = new ModelAndView();
		mav.addObject(params);
		return "login";
	}
	
	//회원가입 폼으로 가기 위한 RequestMapping
	@RequestMapping(value="/loginForm.do")
	public String memberRegister(){
		return "loginForm";
	}
	
	
	@RequestMapping(value="/loginForm/register.do", method=RequestMethod.GET)
	public void goReg(HttpServletResponse response, HttpServletRequest request, @RequestParam(value="id") String id, @RequestParam(value="pw1") String pw, @RequestParam(value="name") String name,@RequestParam(value="email") String email  ) throws IOException{
		System.out.println("들어왔습니다 컨트롤러");
		ModelAndView mav = new ModelAndView();
		/*System.out.println(params.getUser_id());
		System.out.println(params.getUser_name());*/
		//mav.addObject(params);
		//mav.setViewName("login");
		//memberDao.insertMember(params);
		PrintWriter out = response.getWriter();
		out.println("");
	
	}
}
