package base;

public class FFT {
	
	double input[] = null;
	public static double PI_COEFF = Math.PI * 2;
	
	public FFT(){
	}
	
	public double[] makeMix(double arrayValues[]){
		int len = arrayValues.length;
		double tempArray[] = new double[len];
		tempArray[0] = arrayValues[0];
		tempArray[len - 1] = arrayValues[len - 1];
		int subArrCounter1 = 1;
		int subArrCounter2 = 1;
		for(int i = 1; i < len - 2 + 1 ; i++){
			if(i % 2 == 0){
				tempArray[subArrCounter1] = arrayValues[i];
				subArrCounter1++;
			}else if (i % 2 != 0){
				tempArray[(len - 2) / 2 + subArrCounter2] = arrayValues[i] ;
				subArrCounter2++;
			}
		}
		return tempArray;
	}
	
	public double[] makeBinInvPermutation(double inputArray[]){
		int binCnt = 1;
		for(int i = 1; i < getNumMixes(inputArray.length) + 1; i++){
			int numSubArrs =  binCnt;
			binCnt *= 2;
			int currArrPos = 0;
			for(int j = 0; j < numSubArrs; j++){
				int subArrLen = inputArray.length / numSubArrs;
				double arr1[] = new double[subArrLen];
				
				for(int k = 0; k < subArrLen; k++){
					arr1[k] = inputArray[k + currArrPos];
				}
				double arr2[] = makeMix(arr1);
				int tempK = 0;
				for(int k = 0; k < subArrLen; k++){
					inputArray[k + currArrPos] = arr2[k];
					tempK = k;
				}
				currArrPos += tempK + 1;
			}
		}
		return inputArray;
	}
	
	public Complex[] dft(Complex arr[]){
		int numPoint = arr.length;
		int numWcoef = numPoint / 2;
		Complex[] wCoefs = new Complex[numWcoef];
		for(int i = 0; i < numWcoef; i++){
			wCoefs[i] = getW(i, numPoint);
		}
		Complex[] outArr = new Complex[numPoint];
		Complex element1 = arr[0];
		Complex element2 = arr[numWcoef];
		int coefCounter = 0;
		for(int j = 0; j < numPoint / 2; j++){
			for(int i = 0; i < numWcoef; i++){
				Complex tempNum = wCoefs[coefCounter].multiply(element2);
				outArr[i] = element1.plus(tempNum);
				coefCounter++;
			}
			coefCounter = 0;
			for(int i = numWcoef; i < numPoint; i++){
				Complex tempNum = wCoefs[coefCounter].multiply(element2);
				outArr[i] = element1.minus(tempNum);
				coefCounter++;
			}
		}
		return outArr;
	}
	
	public Complex[] reversePermutation(Complex inputArray[]){
		int binCnt = 1;
		Complex ourArr[] = new Complex[inputArray.length];
		for(int i = 1; i < getNumMixes(inputArray.length) + 1; i++){
			int numSubArrs =  binCnt;
			binCnt *= 2;
			int currArrPos = 0;
			for(int j = 0; j < numSubArrs; j++){
				int subArrLen = inputArray.length / numSubArrs;
				Complex arr1[] = new Complex[subArrLen];
				
				for(int k = 0; k < subArrLen; k++){
					arr1[k] = inputArray[k + currArrPos];
				}
				Complex arr2[] = dft(arr1);
				ourArr = arr2;
			}
		}
		return ourArr;
	}
	
	public Complex[] doFFT(double input[]){
		double[] mixedArr = makeBinInvPermutation(input);
		Complex complArr[] = new Complex[input.length];
		Complex outArr[] = new Complex[input.length];
		for(int i = 0; i < mixedArr.length; i++)
			complArr[i] = new Complex(mixedArr[i], 0.0);
		outArr = reversePermutation(complArr);
		return outArr;
	}
	
	public int log2(int val){
		int cnt = 0;
		while(val % 2 == 0){
			cnt++;
			val /= 2;
		}
		return cnt;
	}
	
	public int getNumMixes(int val){
		return log2(val) - 1;
	}
	
	public Complex getW(int numLvl, int N){
		double angle = -1 * (PI_COEFF * numLvl) / N;
		return new Complex(Math.cos(angle), Math.sin(angle));
	}
}
