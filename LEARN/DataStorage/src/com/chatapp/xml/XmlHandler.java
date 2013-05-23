package com.chatapp.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.chatapp.bean.Account;

public class XmlHandler {

	public static void addAccount(Account acc){
		try {
			JAXBContext contex = JAXBContext.newInstance(Account.class);
			Marshaller m = contex.createMarshaller();
			m.marshal(acc, new FileOutputStream("accounts.xml"));
			
			
		} catch (JAXBException e) {		
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
