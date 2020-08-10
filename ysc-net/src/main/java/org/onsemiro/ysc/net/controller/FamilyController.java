package org.onsemiro.ysc.net.controller;

import org.onsemiro.ysc.net.domain.db.Family;
import org.onsemiro.ysc.net.domain.param.SearchParam;
import org.onsemiro.ysc.net.service.FamilyService;
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
 * 임직원 관리 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("family")
public class FamilyController {
	
	@Autowired
	private FamilyService familyService;

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
		return new ResponseEntity<>(familyService.getList(param), HttpStatus.OK);
    }
	
	/**
	 * 임직원 등록 화면
	 * @param model
	 */
	@GetMapping("regist")
	public void regist(Model model) {
	}
	
	/**
	 * 임직원 등록
	 * @param family
	 * @return
	 */
	@PostMapping("regist")
	public ResponseEntity<?> regist(Family family) {
		if (familyService.regist(family)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 임직원 수정 화면
	 * @param model
	 * @param id
	 */
	@GetMapping("update")
	public void update(Model model, int id) {
		model.addAttribute("family", familyService.get(id));
	}
	
	/**
	 * 임직원 수정
	 * @param family
	 * @return
	 */
	@PutMapping("update")
	public ResponseEntity<?> update(Family family) {
		if (familyService.update(family)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 정보 삭제
	 * @param id
	 * @return
	 */
	@DeleteMapping("delete")
	@ResponseBody
	public ResponseEntity<?> delete(int id) {
		if (familyService.delete(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
