package com.ssafy.video.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.video.util.JwtUtil;

@Component
public class JwtInterceptor implements HandlerInterceptor{
	// 로그인 한 사람만 사용할 수 있게 
	
	// 헤더에 access-token이라고 하는게 넘어오는지 확인하기 위해
	private static final String HEADER_AUTH = "access_token";
	
	
	@Autowired
	private JwtUtil jwtUtil; // 유효성 검사하기위해
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// OPTIONS을 한 번 던져서 유효한지 확인해
		if(request.getMethod().equals("OPTIONS"))
			return true; // 같다면 통과시켜
		
		// 요청이 가지고 있는 헤더
		// access-token가 넘어왔으면 token이 저장이 되었을것
		String token = request.getHeader(HEADER_AUTH);
		
		if(token != null) {
			jwtUtil.valid(token); // 유효성 검사 메서드
			return true;
		}
		
		throw new Exception("유효하지 않은 접근이다.");
		
	}
}
