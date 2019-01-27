package Join.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Join.service.impl.ServiceImpl;

@Controller
public class JoinController {
	
	@Autowired
	private ServiceImpl serviceimpl;
	
	@RequestMapping(value = "/loginForm/MemberJoin.do")
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mav = new ModelAndView();
		System.out.println(request.getParameter("id"));
		
		mav.setViewName("login");
		return mav;
		
	
	}
}
