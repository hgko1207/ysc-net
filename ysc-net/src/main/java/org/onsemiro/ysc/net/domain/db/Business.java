package org.onsemiro.ysc.net.domain.db;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.onsemiro.ysc.net.domain.Domain;

import lombok.Data;

/**
 * 사업 관리 테이블 도메인
 * 
 * @author hgko
 *
 */
@Entity
@Table(name = "tb_business")
@Data
public class Business implements Domain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	/** 상세 정보 */
	@Column(nullable = false, length = 255)
	private String content;
	
	/** 파일 데이터 */
	@Column(columnDefinition = "longblob")
	private byte[] image;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	private LocalDateTime updateDate;
}
