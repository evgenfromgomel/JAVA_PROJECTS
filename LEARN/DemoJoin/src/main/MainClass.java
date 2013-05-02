package main;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Callme targ = new Callme();
		Caller ct1 = new Caller(targ, "Привет");
		Caller ct2 = new Caller(targ, "Синхронизированный");
		Caller ct3 = new Caller(targ, "Мир");

		try{
			ct1.t.join();
			ct2.t.join();
			ct3.t.join();
		}catch(InterruptedException e){
			System.out.println("Main thread interruption");
		}
		
	}

}
