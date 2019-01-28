package Join.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Join.service.JoinService;
import Join.service.impl.ServiceImpl;

@Controller
public class JoinController {
	
	/*@Resource(name="JoinService")
	private JoinService joinservice;*/

	@Autowired
	private ServiceImpl ServiceImpl;
	
	@RequestMapping(value = "/loginForm/MemberJoin.do")
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mav = new ModelAndView();
		System.out.println(request.getParameter("id"));
		
		String str = ServiceImpl.getId(request.getParameter("id"));
		//joinservice.insert(member);
		if(request.getParameter("id").equals(str) && str != null){
		System.out.println("찾아온 아이디 값은 : "+str);
		}
		System.out.println("끝");
		mav.setViewName("login");
		return mav;
	}
}
