package by.gstu.Testing.entities;

public class Subject {
	private int subjectId;
	private String subject;

	public Subject(int idValue, String subjectVal) {
		subjectId = idValue;
		subject = subjectVal;

	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int idValue) {
		subjectId = idValue;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subjectVal) {
		subject = subjectVal;
	}

	public String toString() {
		return subjectId + " " + subject;
	}
}
