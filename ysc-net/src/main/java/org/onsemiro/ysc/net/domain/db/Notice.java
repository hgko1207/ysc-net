package org.onsemiro.ysc.net.domain.db;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import org.onsemiro.ysc.net.domain.Domain;
import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

import lombok.Data;

/**
 * 공지사항 관리 테이블 도메인
 * 
 * @author hgko
 *
 */
@Entity
@Table(name = "tb_notice")
@Data
public class Notice implements Domain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** 제목 */
	@NotNull
	private String title;
	
	/** 내용 */
	@Lob
	@NotNull
	private String content;
	
	/** 작성자 ID */
	@Column(nullable = false, length = 20)
	private String userId;
	
	/** 작성자 이름 */
	@Column(nullable = false, length = 100)
	private String userName;
	
	private int hit;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	@OneToMany(mappedBy = "notice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<NoticeFile> files;
	
	@Transient
	private MultipartFile[] images;
}
