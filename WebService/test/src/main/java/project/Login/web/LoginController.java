package project.Login.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.Login.service.LoginService;
import project.Login.service.impl.LoginServiceImpl;
import project.Member.MemberDTO;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/main.do")
	public ModelAndView main(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/login_requestForm.do")
	public String loin_requestForm() {
		return "login_requestForm";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	
	@RequestMapping(value = "/goLogin.do", method = RequestMethod.POST)
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response,HttpSession session ,@RequestParam HashMap<String, Object> params){
		System.out.println("===============LoginController()===============");
		ModelAndView mav = new ModelAndView("jsonView");
		
		try{
			MemberDTO result = loginService.chkIdPw(params);
			if(result != null){
				mav.addObject("RESULT_CODE","SUCCESS");
				mav.addObject("RESULT_MSG", "로그인에 성공했습니다.");
				//mav.setViewName("boardlist");
				session.setAttribute("member", result);
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
