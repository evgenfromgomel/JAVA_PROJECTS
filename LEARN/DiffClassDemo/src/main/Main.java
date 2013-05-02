package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

interface Priorities{
	final int HIGH = 0;
	final int MID = 0;
	final int LOW = 0;
}

class Processes implements Priorities{

	int priority;
	String name;
	
	public Processes(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
	
	public Processes(String name){
		this.name = name;
		priority = MID;
	}
	
	@Override
	public String toString() {
		String str = name + ": " + priority;
		return str;
	}
}

public class Main {

	public static void main(String[] args){
		PriorityQueue<Processes> procs = new PriorityQueue<Processes>();
		Random rand = new Random();
		int val;
		for(int i = 0; i < 10; i++){
			val = rand.nextInt(3);
			System.out.println(val);
			procs.offer(new Processes("Process#" + i, val)); 
		}
		while(procs.peek() != null){
			System.out.println(procs.remove());
		}
	}

}
