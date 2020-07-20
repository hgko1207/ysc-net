package org.onsemiro.ysc.net.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 메인 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("user")
public class UserController {

	@GetMapping("general")
	public void general(Model model) {
	}
	
	@GetMapping("teacher")
	public void teacher(Model model) {
	}
	
	@GetMapping("student")
	public void student(Model model) {
	}
}
