package num;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLowCondition {

	NumberGuessBean numGuessBean;
	String expectHint;
	
	@Before
	public void init(){
		numGuessBean = new NumberGuessBean();
		expectHint = "higher";
	}
	
	@Test
	public void testLowerGuess() {
		int lowThanAnswer = numGuessBean.answer - 1;
		numGuessBean.setGuess(String.valueOf(lowThanAnswer));
		assertEquals(expectHint, numGuessBean.getHint());
	}

}
