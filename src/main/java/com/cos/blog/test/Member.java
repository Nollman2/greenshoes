package com.cos.blog.test;

import lombok.Builder;
import lombok.Data;

@Data //getter, setter
public class Member {
	private int id;
	private String userid;
	private String username;
	private String password;
	private String email;
	private String birthday;
	private String phonenumber;
	
	@Builder
	public Member(int id, String userid, String username, String password, String email, String birthday,
			String phonenumber) {
		super();
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.birthday = birthday;
		this.phonenumber = phonenumber;
	}
	
	
}
