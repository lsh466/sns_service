package Login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/loginForm.do", method = RequestMethod.GET)
	public String loginForm(){
		System.out.println("===============LoginController()=============");
		return "loginForm";
	}
}
