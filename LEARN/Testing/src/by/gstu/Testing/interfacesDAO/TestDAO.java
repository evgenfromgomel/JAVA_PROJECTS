package by.gstu.Testing.interfacesDAO;

import java.util.List;

import by.gstu.Testing.entities.Test;


public interface TestDAO {
	public void insertTest(String nameTestVal, int subjectIdValue);

	public Test findTest(String nameTestVal);

	public List<Test> selectTestTO(int subjectIdVal);
	
	public String getTestNameById(int idTest); 
}
