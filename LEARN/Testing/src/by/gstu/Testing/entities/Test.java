package by.gstu.Testing.entities;


import org.apache.log4j.Logger;

import by.gstu.Testing.logic.ReadSubjects;
import by.gstu.Testing.servlets.Controller;

public class Test {
	static Logger logger = Logger.getLogger(Test.class);
	private int testId;
	private int subjectId;
	private String testName;

	public Test(int testIdValue, String testNameVal, int subjectIdValue) {
		testId = testIdValue;
		subjectId = subjectIdValue;
		testName = testNameVal;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testIdValue) {
		testId = testIdValue;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testNameValue) {
		testName = testNameValue;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectIdValue) {
		subjectId = subjectIdValue;
	}

	public String toString() {
		Subject subject = null;
		try {
			subject.setSubject(ReadSubjects.getSubj(subjectId));
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		return testId + testName + " " + subject.getSubject();
	}
}
