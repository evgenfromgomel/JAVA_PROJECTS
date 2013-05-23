package com.chatapp.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
	
	public Account() {
	}
	
	public Account(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	private String login;
	private String password;
	private String nickname;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	

}
