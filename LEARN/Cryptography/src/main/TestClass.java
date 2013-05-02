package main;

import java.io.UnsupportedEncodingException;

public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "AZaz ";
		byte[] b = s.getBytes();
		for(int i = 0; i < b.length; i++)
		System.out.println(b[i]);
		System.out.println(Character.toChars((102 + (256 - 5)) % 256));
		System.out.println((90 + 5) % 256);
		
	}

}
