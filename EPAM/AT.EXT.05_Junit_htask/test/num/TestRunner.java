package num;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestInstanceCreate.class, TestLowCondition.class,
		TestHighCondition.class, TestOutOfBounds.class, TestResetCorrect.class,
		TestTriesToWin.class })
public class TestRunner {

}
