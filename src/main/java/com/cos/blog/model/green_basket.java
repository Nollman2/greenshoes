package com.cos.blog.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		name = "GREEN_BASKET_SEQ_GENERATOR"
		, sequenceName = "GREEN_BASKET_SEQ"
		, initialValue = 1
		, allocationSize = 1
	)
public class green_basket {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GREEN_BASKET_SEQ_GENERATOR")
	private int id;  	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userid")
	private green_Users users;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="productId")
	private green_product product;
	
	private int amount; //상품갯수+ 
	
	private String productsize;

}
