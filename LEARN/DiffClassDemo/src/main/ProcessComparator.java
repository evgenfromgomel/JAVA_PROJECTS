package main;

import java.util.Comparator;

public class ProcessComparator implements Comparator<Processes> {

	@Override
	public int compare(Processes proc1, Processes proc2) {
		if(proc1.priority == proc2.priority) return 0;
		else if(proc1.priority > proc2.priority) return 1;
		else return 0;
	}

}
