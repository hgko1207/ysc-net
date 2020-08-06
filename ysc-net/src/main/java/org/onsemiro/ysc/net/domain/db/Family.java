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
 * 임직원 관리 테이블 도메인
 * 
 * @author hgko
 *
 */
@Entity
@Table(name = "tb_family")
@Data
public class Family implements Domain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 20)
	private String name;
	
	@Column(nullable = false, length = 20)
	private String tel;
	
	/** 부서 */
	@Column(length = 45)
	private String dept;
	
	@Column(length = 255)
	private String content;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	private LocalDateTime updateDate;
}
