package by.gstu.Testing.interfacesDAO;

import java.util.List;

import by.gstu.Testing.entities.TestSpecif;

public interface TestSpecifDAO {
	public void insertTestSpecif(int testIdVal, int[] questionIdListVal);

	public TestSpecif findTestSpecif(int testIdVal);

	public List<TestSpecif> selectTestTO();
}
