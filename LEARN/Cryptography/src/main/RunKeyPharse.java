package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import alhoritms.KeyPhrase;
import alhoritms.RwFence;

public class RunKeyPharse {

	/**
	 * @param args
	 */
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		try {
		String inputString = "";
		String key = "";
		String[] textArr = null;
		KeyPhrase kPhrase = null;
		String codeTxt = "";
		System.out.println("Select activity:");
		System.out.println("1 - coding");
		System.out.println("2 - encoding");
		int selection = Integer.valueOf(reader.readLine());
		switch(selection){
		case 1: 
			System.out.println("Enter text to coding:");
			inputString = reader.readLine();
			System.out.println("Enter key phrase:");
			key = reader.readLine();	
			textArr = strToArray(inputString);
			kPhrase = new KeyPhrase(key);
			codeTxt = kPhrase.code(textArr);
			System.out.println("Coded text: " + codeTxt);
			break;
		case 2:
			System.out.println("Enter text to encoding:");
			inputString = reader.readLine();
			System.out.println("Enter key phrase:");
			key = reader.readLine();	
			textArr = strToArray(inputString);
			kPhrase = new KeyPhrase(key);
			String encodeTxt = kPhrase.encode(textArr);
			System.out.println("Encoded text: " + encodeTxt);
			break;
		}
	
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static String[] strToArray(String str){
		String[] textArr = new String[str.length()];
		for(int i = 0; i < textArr.length; i++)
			textArr[i] = String.valueOf(str.charAt(i));
		return textArr;
	}
 
}
