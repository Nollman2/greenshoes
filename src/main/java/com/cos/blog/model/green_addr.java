package com.cos.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
		name = "GREEN_ADDR_SEQ_GENERATOR"
		, sequenceName = "GREEN_ADDR_SEQ"
		, initialValue = 1
		, allocationSize = 1
	)
public class green_addr {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GREEN_REPLY_SEQ_GENERATOR")
	private int id;  
	@Column(nullable=false, length=100)
	private String recipient;
	
	@Column(nullable=false, length=100)
	private String address;
	
	@Column(nullable=false, length=100)
	private String phonenumber;
	
	@Column(nullable=false, length=100)
	private String num;

}
