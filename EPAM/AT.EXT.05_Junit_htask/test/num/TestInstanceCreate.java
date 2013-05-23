package num;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInstanceCreate {

	NumberGuessBean numGuessBean;
	boolean defaultBoolean = false;
	int defaultInt = 0;
	String defaultNullString = "null";
	
	@Test
	public void testDefaultFieldValues() {
		numGuessBean = new NumberGuessBean();
		assertEquals(defaultBoolean, numGuessBean.getSuccess());
		assertEquals(defaultInt, numGuessBean.getNumGuesses());
		assertEquals(defaultNullString, numGuessBean.getHint());
	}

}
