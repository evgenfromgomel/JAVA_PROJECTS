package main;

public class Callme {
	
	synchronized public void call(String msg){
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Call is interrupted");
		}
		System.out.println("]");
	}

}

class Caller implements Runnable{
	Thread t;
	Callme target;
	String msg;
	
	public Caller(Callme targetob, String msg) {
		this.msg = msg;
		target = targetob;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		target.call(msg);
		
	}
}
