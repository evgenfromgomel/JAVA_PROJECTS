package by.gstu.Testing.entities;

public class Result {
	private int idResult;
	private int idStudent;
	private int idTest;
	private double result;

	public Result(int idResult, int idStudent, int idTest, double result) {
		this.idResult = idResult;
		this.idStudent = idStudent;
		this.idTest = idTest;
		this.result = result;
	}

	public int getIdResult() {
		return idResult;
	}

	public void setIdResult(int idResult) {
		this.idResult = idResult;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

}
