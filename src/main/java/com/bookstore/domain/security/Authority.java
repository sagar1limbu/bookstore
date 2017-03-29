package com.bookstore.domain.security;


import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{
	private final String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}

	public String getAuthority() {
		return authority;
	}
}

/*
self written code

public  class Authority implements GrantedAuthority
{
	private final String authority;
	public Authority(String authority){
		this.authority = authority;

	}

	public String getAuthority(){
		return authority;
	}
}*/
