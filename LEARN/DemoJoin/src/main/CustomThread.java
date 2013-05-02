package main;

public class CustomThread implements Runnable {

	Thread t, st;
	String name;
	
	public CustomThread(String threadname) {
		name =  threadname;
		t = new Thread(this,	name);
		System.out.println("New thread: " + t);
		t.start();
	}
	
	public CustomThread(String threadname, Thread supThread) {
		name =  threadname;
		t = new Thread(this,	name);
		System.out.println("New thread: " + t);
		st = supThread;
		t.start();
	}
	
	@Override
	public void run() {
		try{
			
			for(int i = 5; i > 0; i--){
				System.out.println(name + ": " + i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			System.out.println(name + " thread interruption");
		}
		System.out.println(name + " thread is over");
	}


}
