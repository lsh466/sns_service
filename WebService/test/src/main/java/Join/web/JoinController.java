package Join.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Join.service.impl.ServiceImpl;
import Member.MemberDTO;

@Controller
public class JoinController {
	
	/*@Resource(name="JoinService")
	private JoinService joinservice;*/
	
	@Autowired
	private ServiceImpl serviceImpl;
	
	@RequestMapping(value = "/loginForm/MemberJoin.do")
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mav = new ModelAndView("jsonView");
		System.out.println(request.getParameter("id"));
		try{
			String str = serviceImpl.getId(request.getParameter("id"));
			//MemberDTO member = serviceImpl.getId(request.getParameter("id"));
			if(request.getParameter("id").equals(str) && str != null){
			System.out.println("찾아온 아이디 값은 : "+str);
			}
			System.out.println("끝");
			mav.addObject("RESULT_CODE","SUCCESS");
		}catch(Exception e){
			mav.addObject("RESULT_CODE","FAILURE");
		}
		return mav;
	}
}
