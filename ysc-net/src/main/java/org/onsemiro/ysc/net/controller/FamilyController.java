package org.onsemiro.ysc.net.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 임직원 관리 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("family")
public class FamilyController {

	@GetMapping("list")
	public void list(Model model) {
	}
	
	@GetMapping("regist")
	public void regist(Model model) {
	}
}
