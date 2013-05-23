package num;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestResetCorrect {

	NumberGuessBean numGuessBean;
	boolean expectSuccess;
	int expectNumGuesses;
	int oldAnswer;
	
	@Before
	public void init(){
		numGuessBean = new NumberGuessBean();
		expectSuccess = false;
		expectNumGuesses = 0;
		oldAnswer = numGuessBean.answer;
	}
	
	@Test
	public void testResetCorrect() {
		for(int i = 0; i < 10000; i++){
			numGuessBean.setGuess(String.valueOf(i));
		}
		numGuessBean.reset();
		assertEquals(expectSuccess, numGuessBean.getSuccess());
		assertEquals(expectNumGuesses, numGuessBean.getNumGuesses());
		assertFalse(oldAnswer == numGuessBean.answer);
	}
	
	
}
