package org.onsemiro.ysc.net.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 신청합니다 화면 관리 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("apply")
public class ApplyController {

	@GetMapping("list")
	public void list(Model model) {
	}
}
