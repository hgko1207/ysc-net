package org.onsemiro.ysc.net.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.onsemiro.ysc.net.domain.db.Notice;
import org.onsemiro.ysc.net.domain.db.NoticeFile;
import org.onsemiro.ysc.net.domain.param.SearchParam;
import org.onsemiro.ysc.net.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
	 * 공지사항 등록
	 * @param notice
	 * @return
	 */
	@PostMapping("regist")
	public ResponseEntity<?> regist(Notice notice) {
		notice.setUserId("admin");
		notice.setUserName("관리자");
		
		try {
			List<NoticeFile> noticeFiles = new ArrayList<>();
			
			for (MultipartFile file : notice.getImages()) {
				String fileName = file.getOriginalFilename();
				if (!fileName.isEmpty()) {
					NoticeFile noticeFile = new NoticeFile();
					noticeFile.setFileName(fileName);
					noticeFile.setContent(file.getBytes());
					noticeFile.setContentType(file.getContentType());
					noticeFile.setNotice(notice);
					
					noticeFiles.add(noticeFile);
				}
			}
			
			notice.setFiles(noticeFiles);
			
			if (noticeService.regist(notice)) {
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * 공지사항 상세정보 화면
	 * @param model
	 */
	@GetMapping("detail/{id}")
	public String detail(Model model, @PathVariable int id) {
		Notice notice = noticeService.get(id);
		model.addAttribute("notice", notice);
		
		notice.setHit(notice.getHit() + 1);
		noticeService.update(notice);
		
		return "notice/detail";
	}
	
	/**
	 * 공지사항 수정 화면
	 * @param model
	 */
	@GetMapping("update")
	public void update(Model model) {
	}
}
