package alhoritms;

import interfaces.Cryptographical;

public class RwFence implements Cryptographical {
	
	private int key;
	private String[][] codeTable;
	private String[][] encodeTable;

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public RwFence(int key){
		this.key = key;
	}

	@Override
	public String code(String[] input) {
		int numCol = input.length;
		codeTable = new String[key][numCol];
		for(int i = 0; i < key; i++)
			for(int j = 0; j < numCol; j++)
				codeTable[i][j] = ""; 
		int lit = 0;
		boolean endFl = false;
		while(lit < numCol - 1){
			for(int i = 0; i < key; i++){
				codeTable[i][lit] = input[lit];
				lit++;
				if(lit > numCol - 1) endFl = true;
				if(endFl) break;
			}
			if(endFl) break;
			for(int j = key - 2; j >= 1; j--){
				codeTable[j][lit] = input[lit];
				lit++; 
				if(lit > numCol - 1) endFl = true;
				if(endFl) break;
			}
			if(endFl) break;
		}
		String codeText = "";
		for(int i = 0; i < key; i++){
			for(int j = 0; j < numCol; j++)
				if(!codeTable[i][j].equals("")) codeText += codeTable[i][j];
		}
		return codeText;
	}

	@Override
	public String encode(String[] input) {
		int numCol = input.length;
		encodeTable = new String[key][numCol];
		for(int i = 0; i < key; i++)
			for(int j = 0; j < numCol; j++)
				encodeTable[i][j] = ""; 
		int strK = key * 2 - 3;
		int k1 = strK - 1; 
		int k2 = 1;
		int stK = 0; 
		int lit = 0;
		int j = 0;
		for(int i = 0; i < key; i++){
			j = stK;
			if(i == 0 || i == key - 1){
				while(j < numCol - 1){
					if(lit > numCol - 1) break;
					encodeTable[i][j] = input[lit];
					j += strK + 1;
					lit++;
				}
			}
			else{
				encodeTable[i][j] = input[lit];
				lit++;
				while(j < numCol - 1){
					j += k1;
					if(j < numCol){
						encodeTable[i][j] = input[lit];
						lit++;
					} else break;
					j += k2 + 1;
					if(j < numCol){
						encodeTable[i][j] = input[lit];
						lit++;
					} else break;
				}
				k1 -= 2;
				k2 += 2;
			}
			stK++;
		}
		String output = "";
		lit = 0;
		boolean endFl = false;
		while(lit < numCol - 1){
			for(int i = 0; i < key; i++){
				output += encodeTable[i][lit];
				lit++;
				if(lit > numCol - 1) endFl = true;
				if(endFl) break;
			}
			if(endFl) break;
			for(j = key - 2; j >= 1; j--){
				output += encodeTable[j][lit];
				lit++; 
				if(lit > numCol - 1) endFl = true;
				if(endFl) break;
			}
			if(endFl) break;
		}				
		return output;
	}
	
	public void printCodeTable(){
		for(int i = 0; i < key; i++){
			for(int j = 0; j < codeTable[1].length; j++)
				if(codeTable[i][j].equals("")) System.out.print(" ");
				else System.out.print(codeTable[i][j]);
			System.out.print("\n");
		}
	}
	
	public void printEncodeTable(){
		for(int i = 0; i < key; i++){
			for(int j = 0; j < codeTable[1].length; j++)
				if(encodeTable[i][j].equals("")) System.out.print(" ");
				else System.out.print(encodeTable[i][j]);
			System.out.print("\n");
		}
	}

}
