package com.ssafy.video.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.video.model.dto.User;
import com.ssafy.video.model.service.UserService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "유저 컨트롤러")
@RequestMapping("/api")
public class UserController {

	// UserService 라고 하는 친구를 주입
	@Autowired
	private UserService userService;

	// 유저 등록하기(회원가입)
	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody User user) {
		userService.signup(user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<?> login(User user, HttpSession session) {
		User user1 = userService.login(user);
		// 로그인 실패 (잘못했어)
		if (user1 == null)
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);

		session.setAttribute("loginUser", user1.getUserId());
		return new ResponseEntity<String>(user1.getUserId(), HttpStatus.OK);
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public ResponseEntity<Void> logout(HttpSession session) {
		session.invalidate();

		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 유저아이디에 해당하는 유저 조회
	@GetMapping("/user/{id}")
	public ResponseEntity<User> selectList(@PathVariable String id) {
		User user = userService.getUserOne(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}