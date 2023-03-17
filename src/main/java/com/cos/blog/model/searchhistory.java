package com.cos.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="searchhistory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
		name = "GREEN_HISTORY_SEQ_GENERATOR"
		, sequenceName = "GREEN_HISTORY_SEQ"
		, initialValue = 1
		, allocationSize = 1
		)
public class searchhistory {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GREEN_HISTORY_SEQ_GENERATOR")
	private int id;
	@ManyToOne
	@JoinColumn(name="userid")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private green_Users  users;
	
	@Lob
	private String searchhistory;	

}
