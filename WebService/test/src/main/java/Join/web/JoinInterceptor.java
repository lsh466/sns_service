package Join.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class JoinInterceptor extends HandlerInterceptorAdapter {

	// 컨트롤러보다 먼저 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		System.out.println("현재 로그인이 된 상황인지 JoinInterceptor가 판별 ");
		
		if (obj == null) {
			System.out.println("JoinInterceptor가 로그인 안된 걸로 확인. 그대로 컨트롤러 진행 ");
			return true;
		} else {
			// 세션의 member != null --> 로그인이 된 상황이니까 회원가입or로그인창으로 가면 안됨  --> main.do로.
			System.out.println("JoinInterceptor가 로그인 중인 것으로 확인. main.do로 보내줌 ");
			response.sendRedirect(request.getContextPath() + "/main.do");

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
