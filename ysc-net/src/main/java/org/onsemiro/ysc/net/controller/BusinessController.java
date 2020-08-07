package org.onsemiro.ysc.net.controller;

import org.onsemiro.ysc.net.domain.param.SearchParam;
import org.onsemiro.ysc.net.service.BusinessService;
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
 * 사업 관리 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("business")
public class BusinessController {
	
	@Autowired
	private BusinessService businessService;

	@GetMapping("list")
	public void list(Model model) {
	}
	
	/**
	 * 조회
	 * @param param
	 * @return
	 */
	@PostMapping("search")
    public ResponseEntity<?> search(@RequestBody SearchParam param) {
		return new ResponseEntity<>(businessService.getList(param), HttpStatus.OK);
    }
	
	@GetMapping("regist")
	public void regist(Model model) {
	}
}
