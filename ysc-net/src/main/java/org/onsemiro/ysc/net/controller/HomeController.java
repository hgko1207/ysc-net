package org.onsemiro.ysc.net.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 메인 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
public class HomeController {

	@GetMapping("/")
    public String index(Model model) {
		 return "redirect:home";
    }
	
	@GetMapping("home")
	public void home(Model model) {
	}
}
