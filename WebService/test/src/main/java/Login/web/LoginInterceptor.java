package Login.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	// 컨트롤러보다 먼저 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		System.out.println("현재 로그인이 된 상황인지 LoginInterceptor가 판별 ");
		// 세션에 member가 널이 아님 -> 로그인한 상황임.
		if (obj != null) {
			System.out.println("LoginInterceptor가 로그인 중인 것으로 확인함. 컨트롤러 그대로 진행 ");
			return true;
		} 
		else //세션에 member에 값이 없음-> 로그인 안된 상황 -> 로그인 요청 페이지 
		{
			System.out.println("LoginInterceptor가 로그인 중이 아닌 것으로 확인함. 로그인 요청 페이지로 ");
			response.sendRedirect(request.getContextPath() + "/login_request.do");

			return false;
		}

	}

	// 컨트롤러의 메서드 처리가 끝나고 화면을 띄워주는 처리가 되기 직전 호출
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}

	// 컨트롤로가 수행되고 화면처리가 끝난 뒤 호출
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}

}
