package by.gstu.Testing.entities;


public class Question {
	private int questionId;
	private int subjectId;
	private String questionText;
	private String variantA;
	private String varB;
	private String varC;
	private String varD;
	private int rightAnswer;


	public Question(int idValue, int subjectIdValue, String questionTextValue,
			String varAValue, String varBValue, String varCValue,
			String varDValue, int rightAnswer) {
		questionId = idValue;
		subjectId = subjectIdValue;
		questionText = questionTextValue;
		variantA = varAValue;
		varB = varBValue;
		varC = varCValue;
		varD = varDValue;
		this.rightAnswer = rightAnswer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int idValue) {
		questionId = idValue;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int idValue) {
		subjectId = idValue;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionTextValue) {
		questionText = questionTextValue;
	}

	public String getVarA() {
		return variantA;
	}

	public void setVariantA(String varAValue) {
		variantA = varAValue;
	}

	public String getVarB() {
		return varB;
	}

	public void setVarB(String varBValue) {
		varB = varBValue;
	}

	public String getVarC() {
		return varC;
	}

	public void setVarC(String varCValue) {
		varC = varCValue;
	}

	public String getVarD() {
		return varD;
	}

	public void setVarD(String varDValue) {
		varD = varDValue;
	}
	public int getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(int rightAnswer) {
		this.rightAnswer = rightAnswer;
	}


	public String toString() {

		return questionId + " " + questionText + " " +  subjectId + " " + " " + variantA + " " + varB + " " + varC + " "
				+ varD;
	}
}
