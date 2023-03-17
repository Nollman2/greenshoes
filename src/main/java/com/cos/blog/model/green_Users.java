package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//ORAM -> 언어들의 Object를 테이블로 매핑해주는 기술

@Table(name="green_Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
		name = "GREEN_USER_SEQ_GENERATOR"
		, sequenceName = "GREEN_USER_SEQ"
		, initialValue = 1
		, allocationSize = 1
		)



public class green_Users {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GREEN_USER_SEQ_GENERATOR")//프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id;//시퀸스, auto_increment
	
	@Column(nullable=false, length=100,unique = true)
	private String username; //사용자 아이디
	
	@Column(nullable=false, length=50)
	private String userid; //사용자 이름
	
	@Column(nullable=false, length=100)
	private String password; //사용자 비밀번호
	
	@Column(nullable=false, length=100)
	private String email; //사용자 이메일

	@Column(nullable=false, length=100)
	private String birthday; //사용자 생일

	@Column(nullable=false, length=50)
	private String phonenumber; //사용자 폰번호

	@Enumerated(EnumType.STRING)
	private RoleType roles;//권한
	
	@Column(length=30)
	private String oauth;  //kakao, google
	
	@CreationTimestamp
	private Timestamp createDate;//가입일
	
	@OneToMany(mappedBy="users",fetch=FetchType.EAGER)
	private List<green_basket> baskets;

	
}
