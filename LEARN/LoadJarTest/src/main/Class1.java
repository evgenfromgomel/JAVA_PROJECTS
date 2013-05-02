package main;

public class Class1 {

	
	public static int field1 = 5;
	public static int intValue;
	public static String str;
	public static double doubVal;
	public int intValueNst;
	public String strNst;
	public double doubValNst;
	
	public  Class1(){
		
	}
	
	public static void simplMethod(){
		System.out.print("simple method was invoked");
	}
	
	public  void methWithArgs(int intValue, String str, double doubVal ){
		this.intValueNst = intValue;
		this.strNst = str;
		this.doubValNst = doubVal;
	}
}
