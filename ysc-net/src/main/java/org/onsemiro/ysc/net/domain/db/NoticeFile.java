package org.onsemiro.ysc.net.domain.db;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.onsemiro.ysc.net.domain.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * 공지사항 첨부파일 관리 도메인
 * 
 * @author hgko
 *
 */
@Entity
@Table(name = "tb_notice_file")
@Data
public class NoticeFile implements Domain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/** 파일 이름 */
	@Column(nullable = false, length = 100)
	private String fileName;

	/** 파일 데이터 */
	@Column(columnDefinition = "longblob")
	private byte[] content;

	/** 파일 확장자 */
	@Column(nullable = false, length = 100)
	private String contentType;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@Transient
	private String image;
	
	@Transient
	private List<String> images;
	
	@ManyToOne
	@JoinColumn(name = "notice_id")
    @JsonIgnore
    private Notice notice;
}
