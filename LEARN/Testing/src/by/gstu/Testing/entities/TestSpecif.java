package by.gstu.Testing.entities;

import java.util.ArrayList;
import java.util.List;


public class TestSpecif {
	private List<Integer> testSpecId;
	private int testId;
	private List<Integer> questionIdList;

	public TestSpecif(List<Integer> testSpecIdValue, int testIdVal,
			List<Integer> questionIdListVal) {
		testSpecId = testSpecIdValue;
		testId = testIdVal;
		questionIdList = questionIdListVal;
	}

	public List<Integer> getTestSpecId() {
		return testSpecId;
	}

	public void setTestSpecId(List<Integer> testSpecIdValue) {
		testSpecId = testSpecIdValue;
	}

	public int getTestId() {
		return testId;
	}

	public void setLastName(int testIdValue) {
		testId = testIdValue;
	}

	public List<Integer> getQuestionList() {
		return questionIdList;
	}

	public void setQuestionList(List<Integer> questionIdListValue) {
		questionIdList = questionIdListValue;
	}

	public String toString() {
		return testSpecId + " " + testId;
	}
}
