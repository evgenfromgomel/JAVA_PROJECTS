package num;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOutOfBounds {

	NumberGuessBean numGuessBean;
	String expectHint;
	
	@Before
	public void init(){
		numGuessBean = new NumberGuessBean();
		expectHint = "a number next time";
	}
	
	@Test
	public void testLowerBorder() {
		int lowBound = 0;
		numGuessBean.setGuess(String.valueOf(lowBound));
		assertEquals(expectHint, numGuessBean.getHint());
		
	}

	@Test
	public void testHigherBorder(){
		int highBound = 102;
		numGuessBean.setGuess(String.valueOf(highBound));
		assertEquals(expectHint, numGuessBean.getHint());
	}
	
}
