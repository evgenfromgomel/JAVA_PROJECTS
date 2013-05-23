package num;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestTriesToWin {

	NumberGuessBean numGuessBean;
	
	@Before
	public void init(){
		numGuessBean = new NumberGuessBean();
	}
	
	@Test
	public void testTestTriesToWin() {
		int i;
		int borderLeft = 0;
		int borderRight = 100;
		int range;
		int tryConuter = 0;
		i = Math.round((borderRight - borderLeft) / 2);
		
		while(numGuessBean.getSuccess() != true){
			System.out.print("Try " + i);
			tryConuter++;
			numGuessBean.setGuess(String.valueOf(i));
			if (numGuessBean.getSuccess() == true){
				System.out.println("\n\nWe win at " + tryConuter + " try; Answer was " + numGuessBean.answer);
			}
			else{
				System.out.println(" Not win yet!");
				if (numGuessBean.getHint().equalsIgnoreCase("lower")){
					borderRight = i;
					range = (int) Math.ceil((borderRight - borderLeft) / 2);
					i = borderLeft + range;
				}
				else{
					borderLeft = i;
					range = (int) Math.ceil((borderRight - borderLeft) / 2);
					i =  borderLeft + range;
				}
			}
		}
		assertEquals(tryConuter, numGuessBean.getNumGuesses());
		
	}


	
}
