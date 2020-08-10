package org.onsemiro.ysc.net.controller;

import java.io.IOException;

import org.onsemiro.ysc.net.domain.db.Business;
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
import org.springframework.web.multipart.MultipartFile;

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
	
	/**
	 * 사업 등록
	 * @param business
	 * @param images
	 * @return
	 */
	@PostMapping("regist")
	public ResponseEntity<?> regist(Business business, MultipartFile images) {
		try {
			business.setImage(images.getBytes());
			business.setImageType(images.getContentType());
			business.setUserId("admin");
			business.setUserName("관리자");
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		if (businessService.regist(business)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
