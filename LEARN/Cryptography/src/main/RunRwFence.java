package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import alhoritms.RwFence;

public class RunRwFence {

	/**
	 * @param args
	 */
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {
		try {
		int key = 0;
		String[] textArr = null;
		RwFence rwFence = null;
		String inputString = "";
		System.out.println("Select activity:");
		System.out.println("1 - coding");
		System.out.println("2 - encoding");
		int selection = Integer.valueOf(reader.readLine());
		switch(selection){
		case 1: 
			System.out.println("Enter text to code:");
			inputString = reader.readLine();
			System.out.println("Enter key(number):");
			key = Integer.valueOf(reader.readLine());	
			textArr = strToArray(inputString);
			rwFence = new RwFence(key);
			String codeTxt = rwFence.code(textArr);
			System.out.println("Coded text: " + codeTxt);
			break;
		case 2:
			System.out.println("Enter text to encode:");
			inputString = reader.readLine();
			System.out.println("Enter key(number):");
			key = Integer.valueOf(reader.readLine());	
			textArr = strToArray(inputString);
			rwFence = new RwFence(key);
			String encodeTxt = rwFence.encode(textArr);
			System.out.println("Coded text: " + encodeTxt);
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
