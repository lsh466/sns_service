package Join.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Join.service.JoinService;
import Member.MemberDTO;

@Controller
public class JoinController {
	
	@Autowired
	private JoinService joinservice;
	
	@RequestMapping(value = "/loginForm/MemberJoin.do")
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mav = new ModelAndView();
		System.out.println(request.getParameter("id"));
		
		MemberDTO member = joinservice.getId(request.getParameter("id"));
		System.out.println("찾아온 아이디 값은 : "+member.getId());
		
		mav.setViewName("login");
		return mav;
	}
}
