package com.chatapp.main;

import com.chatapp.bean.Account;
import com.chatapp.xml.XmlHandler;

public class Runner {

	
	public static void main(String[] args) {
		
		XmlHandler.addAccount(new Account("vasya", "1"));
		XmlHandler.addAccount(new Account("kolya", "1"));
		XmlHandler.addAccount(new Account("petya", "1"));
		XmlHandler.addAccount(new Account("dima", "1"));

	}

}
