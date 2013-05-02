package base;

public class Complex {

	
	private double re;
	private double im;
	
	public Complex(double re, double im){
		if((re < 0.000001 && re > 0) || (re > -0.000001 && re < 0)) this.re = 0;
		else this.re = re;
		if((im < 0.000001 && im > 0) || (im > -0.000001 && im < 0)) this.im = 0;
		else this.im = im;
	}
	
	  public Complex plus(Complex z){
	      return new Complex(re + z.re, im + z.im);
	   } 

	   public Complex minus(Complex z){
	      return new Complex(re - z.re, im - z.im); 
	   }

	   public Complex multiply(Complex z){ 
	      return new Complex(re * z.re - im * z.im, re * z.im + im * z.re);
	   }
	   
	   public String toString(){
		   return re + " " + im  + "i";
	   }
}
