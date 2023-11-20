package com.ssafy.video.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	private static final String SALT = "SSAFIT";
	private static final int Time = 1000*60*60; // 유효시간 1시간
	
	
	//1. 토큰 생성 메서드
	// JwtTest에서 만든 토큰을 자동으로 만들어주는 메서드를 만들기
	//데이터가 하나만 인자로 들어온다라고 가정하고 / 테스트에 방해가 되는 유효기간 제거
	public String createToken(String key, String value) throws UnsupportedEncodingException {
		return Jwts.builder()
				.setHeaderParam("alg", "HS256") // 알고리즘은 HS256라고 하고
				.setHeaderParam("typ", "JWT") //헤더완료, 타입은 JWT라고 하겠다.
				.claim(key, value) // 파라미터 값이 들어감, payload(내용) : key는 value라고 저장하겠다.
				.setExpiration(new Date(System.currentTimeMillis()+Time)) //페이로드 완료, 유효시간 설정(현재시간 + 3초)
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) //서명완료, 암호화 알고리즘과 시크릿 키를 넣어줌
				.compact(); // String 형태로 바꿔줘서 String token으로 저장 가능
	}
	
	//2. 토큰 유효성 검사 메서드
	public void valid(String token) throws Exception {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}
}
