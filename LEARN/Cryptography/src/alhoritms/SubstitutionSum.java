package alhoritms;

import interfaces.Cryptographical;

public class SubstitutionSum implements Cryptographical {
	
	private byte key;
	private String borders = "AZaz";
	private byte upStCode = borders.getBytes()[0];
	private byte upEndCode = borders.getBytes()[1];
	private byte lowStCode = borders.getBytes()[2];
	private byte lowEndCode = borders.getBytes()[3];
	
	public SubstitutionSum(byte key){
		this.key = Byte.valueOf(key);
	}

	@Override
	public String code(String[] input) {
		byte[][] inputCodes = new byte[input.length][1];
		for(int i = 0; i < input.length; i++){
			inputCodes[i] = input[i].getBytes();
		}
		byte newCode = 0;
		byte[] codedArr = new byte[input.length];
		for(int i = 0; i < input.length; i++){
			if(inputCodes[i][0] != 32){
				if(inputCodes[i][0] >= lowStCode && inputCodes[i][0] <= lowEndCode){
					newCode = (byte) ((byte) (inputCodes[i][0] + key) % 256);
					if(newCode > lowEndCode){
						 int shift = newCode - lowEndCode - 1;
						 newCode = (byte)((byte)lowStCode + shift);
					}
				}if(inputCodes[i][0] >= upStCode && inputCodes[i][0] <= upEndCode){
					newCode = (byte) ((byte) (inputCodes[i][0] + key) % 256);
					if(newCode > upEndCode){
						 int shift = newCode - upEndCode - 1;
						 newCode = (byte)((byte)upStCode + shift);
					}
				}	
				codedArr[i] = newCode;
			}
			else{
				codedArr[i] = inputCodes[i][0];
			}
		}
		for(int i = 0; i < input.length; i++)
			System.out.println(inputCodes[i][0]);
		for(int i = 0; i < input.length; i++)
			System.out.println(codedArr[i]);
		String[] codedStrArr = new String[input.length];
		for(int i = 0; i < input.length; i++)
			codedStrArr[i] = String.valueOf(Character.toChars(codedArr[i]));
		String codedTxt = "";
		for(int i = 0; i < input.length; i++)
			codedTxt += codedStrArr[i];
		return codedTxt;
	}

	@Override
	public String encode(String[] input) {
		byte[][] inputCodes = new byte[input.length][1];
		for(int i = 0; i < input.length; i++){
			inputCodes[i] = input[i].getBytes();
		}
		byte newCode = 0;
		byte[] codedArr = new byte[input.length];
		for(int i = 0; i < input.length; i++){
			if(inputCodes[i][0] != 32){
				if(inputCodes[i][0] >= lowStCode && inputCodes[i][0] <= lowEndCode){
					newCode = (byte) ((byte) (inputCodes[i][0] + (byte)(256 - key)) % 256);
					if(newCode < lowStCode){
						 int shift = lowStCode - 1 - newCode;
						 newCode = (byte)((byte)lowEndCode - shift);
					}
				}if(inputCodes[i][0] >= upStCode && inputCodes[i][0] <= upEndCode){
					newCode = (byte) ((byte)(inputCodes[i][0] + (byte)(256 - key)) % 256);
					if(newCode < upEndCode){
						 int shift = upStCode - 1 - newCode;
						 newCode = (byte)((byte)upEndCode - shift);
					}
				}	
				codedArr[i] = newCode;
			}
			else{
				codedArr[i] = inputCodes[i][0];
			}
		}
		for(int i = 0; i < input.length; i++)
			System.out.println(inputCodes[i][0]);
		for(int i = 0; i < input.length; i++)
			System.out.println(codedArr[i]);
		String[] codedStrArr = new String[input.length];
		for(int i = 0; i < input.length; i++)
			codedStrArr[i] = String.valueOf(Character.toChars(codedArr[i]));
		String codedTxt = "";
		for(int i = 0; i < input.length; i++)
			codedTxt += codedStrArr[i];
		System.out.println(codedTxt);
		return null;
	}

}
