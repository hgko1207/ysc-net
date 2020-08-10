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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@GetMapping("get")
	public ResponseEntity<?> get(int id) {
		return new ResponseEntity<>(businessService.get(id), HttpStatus.OK);
	}
	
	/**
	 * 사업 등록 화면
	 * @param model
	 */
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
	public ResponseEntity<?> regist(Business business) {
		try {
			business.setImage(business.getFile().getBytes());
			business.setImageType(business.getFile().getContentType());
			business.setUserId("admin");
			business.setUserName("관리자");
			
			if (businessService.regist(business)) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * 사업 정보 수정
	 * @param business
	 * @param images
	 * @return
	 */
	@PutMapping("update")
	public ResponseEntity<?> update(Business business) {
		Business result = businessService.get(business.getId());
		result.setName(business.getName());
		result.setContent(business.getContent());
		
		try {
			if (business.getFile() != null && business.getFile().getSize() > 0) {
				result.setImageType(business.getFile().getContentType());
				result.setImage(business.getFile().getBytes());
			}
			
			if (businessService.update(result)) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);			
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * 정보 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("delete")
	@ResponseBody
	public ResponseEntity<?> delete(int id) {
		System.err.println(id);
		if (businessService.delete(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
