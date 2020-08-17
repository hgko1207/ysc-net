package org.onsemiro.ysc.net.controller;

import org.onsemiro.ysc.net.domain.param.SearchParam;
import org.onsemiro.ysc.net.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 사용자 관리 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;

	/**
	 * 사용자 관리 화면
	 * @param model
	 */
	@GetMapping("list")
	public void list(Model model) {
	}
	
	/**
	 * 리스트 조회
	 * @param param
	 * @return
	 */
	@PostMapping("search")
    public ResponseEntity<?> search(@RequestBody SearchParam param) {
		return new ResponseEntity<>(userService.getList(param), HttpStatus.OK);
    }
	
	/**
	 * 사용자 정보 화면
	 * @param model
	 */
	@GetMapping("profile")
	public void profile(Model model) {
	}
}
