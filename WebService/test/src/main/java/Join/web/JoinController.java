package Join.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Join.service.impl.ServiceImpl;

@Controller
public class JoinController {
	
	@Resource(name="joinserviceImpl")
	private ServiceImpl serviceImpl;
	
	/*@Autowired
	private ServiceImpl serviceImpl;*/
	
	//회원가입 폼 view
	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm(){
		return "loginForm";
	}
	
	@RequestMapping(value = "/loginForm/MemberJoin.do")
	public ModelAndView loginForm(HttpServletRequest request,HttpServletResponse response, @RequestParam HashMap<String, Object> params){
		
		System.out.println("==============JoinController()============");
		ModelAndView mav = new ModelAndView("jsonView");
		System.out.println("parms 값 ==> "+params);
		try{
			
			HashMap<String, Object> result = serviceImpl.memberInsert(request, params);
			String code = (String)result.get("code");
			
			if("000".equals(code)){
				mav.addObject("RESULT_CODE","SUCCESS");
				mav.addObject("RESULT_MSG", result.get("data"));
			}else if("001".equals(code)){
				mav.addObject("RESULT_CODE", "FAILURE");
				mav.addObject("RESULT_MSG", result.get("data"));
			}else if("002".equals(code)){
				mav.addObject("RESULT_CODE", "FAILURE");
				mav.addObject("RESULT_MSG", result.get("data"));
			}else{
				mav.addObject("RESULT_CODE", "ERROR");
				mav.addObject("RESULT_MSG", result.get("data"));
			}//else 회원가입 insert
		}catch(Exception e){
			System.out.println("Exception() ");
			mav.addObject("RESULT_CODE","FAILURE");
			mav.addObject("RESULT_MSG", e.getMessage());
		}
		return mav;
	}
}
