package Login.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import Login.service.impl.LoginServiceImpl;
import Member.MemberDTO;

@Controller
//@SessionAttributes("member")
public class LoginController {

	
	
	@Resource(name="loginserviceImpl")
	private LoginServiceImpl loginserviceImpl;
	
	
	@RequestMapping(value="/main.do")
	public String main(HttpServletRequest request, Model model){
		System.out.println("main 페이지 요청");
		/* 인터셉터로 인해서 없어도 됨
		 * 
		 * HttpSession session = request.getSession();
		String session_id = (String) session.getAttribute("id");
		
		if(session_id == null) {
			return "redirect:/";
		}
		else {
			model.addAttribute("id", session_id);
		}*/
		
		return "main";
		
	}
	
	@RequestMapping(value= {"/", "/login.do"})
	public ModelAndView login(HttpServletRequest request){
		System.out.println("login 페이지 요청");
		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("login");
		
		
		/* 인터셉터로 인해서 없어도 됨
	
		 * HttpSession session = request.getSession();
		String session_id = (String) session.getAttribute("id");
		if(session_id == null) {
			mav.setViewName("login");
		}
		else {
			mav.setViewName("main");
		}*/
		
		
		return mav;
	}
	
	
	@RequestMapping("/login_request.do")
	public String login_request() {
		return "login_request";
	}
	
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session /*SessionStatus status*/) {
		//status.setComplete();
		System.out.println("logout 페이지 요청");
		session.invalidate();
		return "logout";
	}

	
	@RequestMapping(value = "/goLogin.do", method = RequestMethod.POST)
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response,
			HttpSession session ,@RequestParam HashMap<String, Object> params)
	{
		System.out.println("===============LoginController()===============");
		System.out.println("LoginController의 params 값 "+params);
		ModelAndView mav = new ModelAndView("jsonView");
		
		try{
			MemberDTO result = loginserviceImpl.chkIdPw(params);
			System.out.println("LoginController()의 result.getUSER_ID :  "+result.getUSER_ID()); 
			//result = {data={USER_ID=t001, USER_PW=t001}}
			
			
			//if(result.get("data") != null)
			if(result != null)
			{
				mav.addObject("RESULT_CODE","SUCCESS");
				mav.addObject("RESULT_MSG", "로그인에 성공했습니다.");
				session.setAttribute("member", result);
				//mav.addObject("member", result);
				
			}else{
				mav.addObject("RESULT_CODE","FAILURE");
				mav.addObject("RESULT_MSG", "아이디, 비밀번호가 틀렸습니다. 다시 입력해주세요");
			}//else
		}catch(Exception e){
			mav.addObject("RESULT_CODE", "FAILURE");
			mav.addObject("RESULT_MSG", e.getMessage());
		}
		
		return mav;
	}
}
