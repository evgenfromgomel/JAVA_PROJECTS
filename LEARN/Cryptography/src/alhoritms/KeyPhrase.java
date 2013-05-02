package alhoritms;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import interfaces.Cryptographical;

public class KeyPhrase implements Cryptographical {

	int[] sortCodes; 
	int[] codes;
	private String key;
	
	public KeyPhrase(String key){
		this.key = key;
		try {
			byte[] keyBytes = this.key.getBytes("Cp1251");
			codes = new int[keyBytes.length];
			for (int i = 0; i < keyBytes.length; i++) {
		         codes[i] =(keyBytes[i] + 256) % 256;
		    }
			sortCodes = new int[keyBytes.length];
			for (int i = 0; i < keyBytes.length; i++) {
				sortCodes[i] = codes[i];
		    }
			Arrays.sort(sortCodes);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String code(String[] input) {
		int numRows = 0;
		int numCols = key.length();
		if(input.length % key.length() == 0)
		numRows = input.length / key.length();
		else  numRows = input.length / key.length() + 1;
		String[][] codeTable = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numCols; j++){
				codeTable[i][j] = "";
			}
		}
		String[][] outTable = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numCols; j++){
				outTable[i][j] = "";
			}
		}
		int arrItr = 0;
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numCols; j++){
				codeTable[i][j] = input[arrItr];
				arrItr++;
				if(arrItr > input.length - 1) break;
			}
			if(arrItr > input.length - 1) break;
		}
		for(int i = 0; i < numCols; i++){
			int currPos = 0;
			int code = sortCodes[i];
			for(int j = 0; j < numCols; j++){
				if(codes[j] == code){
					currPos = j;
					break;
				}
			}
			for(int k = 0; k < numRows; k++){
				outTable[k][i] = codeTable[k][currPos]; 
			}
		}
		String codedText = "";
		for(int i = 0; i < numRows; i++)
			for(int j = 0; j < numCols; j++)
				codedText += outTable[i][j];
		return codedText;
	}

	@Override
	public String encode(String[] input) {
		int numRows = 0;
		int numCols = key.length();
		if(input.length % key.length() == 0)
		numRows = input.length / key.length();
		else  numRows = input.length / key.length() + 1;
		String[][] encodeTable = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numCols; j++){
				encodeTable[i][j] = "";
			}
		}
		String[][] outTable = new String[numRows][numCols];
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numCols; j++){
				outTable[i][j] = "";
			}
		}
		int arrItr = 0;
		for(int i = 0; i < numRows; i++){
			for(int j = 0; j < numCols; j++){
				encodeTable[i][j] = input[arrItr];
				arrItr++;
				if(arrItr > input.length - 1) break;
			}
			if(arrItr > input.length - 1) break;
		}
		for(int i = 0; i < numCols; i++){
			int currPos = 0;
			int code = codes[i];
			for(int j = 0; j < numCols; j++){
				if(sortCodes[j] == code){
					currPos = j;
					break;
				}
			}
			for(int k = 0; k < numRows; k++){
				outTable[k][i] = encodeTable[k][currPos]; 
			}
		}
		String encodedText = "";
		for(int i = 0; i < numRows; i++)
			for(int j = 0; j < numCols; j++)
				encodedText += outTable[i][j];
		
		return encodedText;
	}

}
