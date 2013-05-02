package base;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		double arr1024[] = new double[1024];
		Complex arr2[] = new Complex[4];
		
		for(int i = 0; i < 1024; i++){
			arr1024[i] = Double.valueOf(i);
		}
		
		for(int i = 0; i < 4; i++){
			arr2[i] = new Complex(i, 0.0);
		}
	
		
		FFT fft = new FFT();
		
	//	double outArr1024[] = fft.makeBinInvPermutation(arr1024);

	
		Complex arrOut[] = fft.dft(arr2);
		//System.out.println("/*************************/");
		for(int i = 0; i < arr2.length; i++){
			System.out.println(arr2[i]);
			}
		for(int i = 0; i < arrOut.length; i++){
		System.out.println(arrOut[i]);
		}
		//System.out.println("/*************************/");
		
		//System.out.println(arrOut);
		
	//	System.out.println(fft.getNumMixes(val));
	}

}
