package by.gstu.Testing.interfacesDAO;

import java.util.List;

import by.gstu.Testing.entities.Result;

public interface ResultDAO {
	public void insertResult(int idStudent, int idTest, double result);

	public List<Result> selectAll();
	
	public List<Result> selectByStudent(int idStudent);
}
