package num;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHighCondition {

	NumberGuessBean numGuessBean;
	String expectHint;
	
	@Before
	public void init(){
		numGuessBean = new NumberGuessBean();
		expectHint = "lower";
	}
	
	@Test
	public void testHigherGuess() {
		int lowThanAnswer = numGuessBean.answer + 1;
		numGuessBean.setGuess(String.valueOf(lowThanAnswer));
		assertEquals(expectHint, numGuessBean.getHint());
	}

}
