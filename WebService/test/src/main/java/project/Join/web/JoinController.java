package project.Join.web;

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

import project.Join.service.JoinService;
import project.Join.service.impl.ServiceImpl;

@Controller
public class JoinController {
	
	@Autowired
	private JoinService joinService;
	
	/*@Autowired
	private ServiceImpl serviceImpl;*/
	
	//회원가입 폼 view
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request){
		System.out.println("loginForm 페이지 요청");
		/* 인터셉터로 인해서 없어도 됨
		 * 
		 * HttpSession session = request.getSession();
		String session_id = (String) session.getAttribute("id");
		
		if(session_id == null) {
			return "loginForm";
		}
		else {
			return "main";
		}*/
		return "loginForm";
	}
	
	@RequestMapping(value = "/loginForm/MemberJoin.do")
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response, @RequestParam HashMap<String, Object> params){
		
		System.out.println("==============JoinController()============");
		ModelAndView mav = new ModelAndView("jsonView");
		System.out.println("parms 값 ==> "+params);
		try{
			
			HashMap<String, Object> result = joinService.getId(params);
			System.out.println("result 값은 : "+result);
			HashMap<String, Object> join;
			//String str = (String)result.get("data");
			if(result.get("data") != null){
				mav.addObject("RESULT_CODE", "FAILURE");
				mav.addObject("RESULT_MSG", "아이디가 중복됩니다. 다른 아이디를 입력해주세요");
			}else{
				System.out.println("회원가입하러 들어왔음");
				join = joinService.memberInsert(request, params);
				String code = (String)join.get("code");
				if("000".equals(code)){
					mav.addObject("RESULT_CODE","SUCCESS");
					mav.addObject("RESULT_MSG", join.get("data"));
				}else if("001".equals(code)){
					mav.addObject("RESULT_CODE", "FAILURE");
					mav.addObject("RESULT_MSG", join.get("data"));
				}else{
					mav.addObject("RESULT_CODE", "ERROR");
					mav.addObject("RESULT_MSG", join.get("data"));
				}//회원가입 else
			}// 아이디 중복확인 else
		}catch(Exception e){
			System.out.println("Exception() ");
			mav.addObject("RESULT_CODE","FAILURE");
			mav.addObject("RESULT_MSG", e.getMessage());
		}
		return mav;
	}
}
