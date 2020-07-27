package org.onsemiro.ysc.net.domain.db;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.onsemiro.ysc.net.domain.Domain;

import lombok.Data;
import lombok.Getter;

/**
 * 학교 관리 도메인
 * 
 * @author hgko
 *
 */
@Entity
@Table(name = "tb_school")
@Data
public class School implements Domain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@CreationTimestamp
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	/** 이름 */
	@Column(nullable = false, length = 20)
	private String name;
	
	/** 학생 수 */
	private int number;
	
	@Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
	private SchoolType schoolType;
	
	@Column(length = 45)
	private String city;
	
	@Getter
	public enum SchoolType {
		초등학교("초등학교"),
		중학교("중학교");
		
		private String name;
		
		private SchoolType(String name) {
			this.name = name;
		}
	}
}
