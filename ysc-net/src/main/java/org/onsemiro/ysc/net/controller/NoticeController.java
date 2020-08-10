package org.onsemiro.ysc.net.controller;

import org.onsemiro.ysc.net.domain.param.SearchParam;
import org.onsemiro.ysc.net.service.NoticeService;
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
 * 공지사항 관리 컨트롤러 클래스
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

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
		return new ResponseEntity<>(noticeService.getList(param), HttpStatus.OK);
    }
	
	/**
	 * 공지사항 등록 화면
	 * @param model
	 */
	@GetMapping("regist")
	public void regist(Model model) {
	}
	
	/**
	 * 공지사항 상세정보 화면
	 * @param model
	 */
	@GetMapping("detail")
	public void detail(Model model) {
	}
	
	/**
	 * 공지사항 수정 화면
	 * @param model
	 */
	@GetMapping("update")
	public void update(Model model) {
	}
}
