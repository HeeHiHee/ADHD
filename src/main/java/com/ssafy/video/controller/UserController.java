package com.ssafy.video.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.video.model.dto.User;
import com.ssafy.video.model.service.UserService;
import com.ssafy.video.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "유저 컨트롤러")
@RequestMapping("/api/user")
public class UserController {
	// 응답을 편하게 하기 위해 상수로 지정
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
//	private static final String FAIL_ID = "ID exists";
//	private static final String FAIL_NICK = "NICKNAME exists";

	@Autowired
	private JwtUtil jwtUtil;

	// UserService 라고 하는 친구를 주입
	@Autowired
	private UserService userService;

	// 유저 등록하기(회원가입)
	@ApiOperation("유저 등록하기(회원가입)")
	@PostMapping("/signup")
	public ResponseEntity<Map<String, Object>> signup(@RequestBody User user) throws UnsupportedEncodingException {
		Map<String, Object> result = new HashMap<String, Object>();
		HttpStatus status = null;
		
		User dbUser1 = userService.getUserOne(user.getUserId());
		User dbUser2 = userService.getUserNick(user.getUserNickname());
		
		// null 값이면 id가 중복되는 게 없으므로 회원가입 성공
		if(dbUser1 == null && dbUser2 == null) {
			userService.signup(user);
			result.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		}
		else {
			// 아이디가 겹칠 때
			if(dbUser1 != null) {
				result.put("message", 1);
				status = HttpStatus.INTERNAL_SERVER_ERROR;				
			}
			// 닉네임이 겹칠때
			else {
				result.put("message", 2);
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		}
		
		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	// 로그인
	@ApiOperation("로그인")
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(String id, String pw) {
		Map<String, Object> result = new HashMap<String, Object>();

		// User Service -> DAO -> DB //실제 유저인지 아닌지 확인 등등등....

		HttpStatus status = null;

		// User의 id가 Null이 아니거나 뭔가 작성이 되어있다면 로그인 성공 이라고 가정
		try {
			// 입력받은 유저의 아이디를 이용해 db에서 유저를 가져옴
			User dbUser = userService.login(id);

			// db에 저장된 유저의 비밀번호랑 입력받은 유저의 비밀번호를 비교
			if (dbUser != null && pw.equals(dbUser.getUserPw())) {
				// 비밀번호가 일치하면 로그인 성공
//				System.out.println(id + " " + pw);
//				System.out.println(dbUser.getUserId() + " " + dbUser.getUserPw());
				result.put("access_token", jwtUtil.createToken("id", id));
				result.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
			// 로그인 실패!
			else {
				result.put("message", FAIL);
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} catch (UnsupportedEncodingException e) {
			result.put("message", FAIL);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(result, status);
	}

	// 유저아이디에 해당하는 유저 조회
	@ApiOperation("유저아이디에 해당하는 유저 조회")
	@GetMapping("/{id}")
	public ResponseEntity<User> selectList(@PathVariable String id) {
		User user = userService.getUserOne(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	// 유저 정보 수정하기
	@ApiOperation("유저 정보 수정하기")
	@PutMapping("/mypage/userInfo")
	public ResponseEntity<Void> doUpdate(@RequestBody User user){
		userService.updateUser(user);		
		return new ResponseEntity<Void>(HttpStatus.OK);		
	}
	
	// 유저 탈퇴 
	@ApiOperation("유저 탈퇴")
	@PutMapping("/usercancel/{id}")
	public ResponseEntity<Void> UserCancel(@PathVariable String id){
		userService.UserCancel(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 유저 정지
	@ApiOperation("유저 정지")
	@PutMapping("/userban/{id}")
	public ResponseEntity<Void> UserBan(@PathVariable String id){
		userService.UserBan(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	

}