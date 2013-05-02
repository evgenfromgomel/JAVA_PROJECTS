package by.gstu.Testing.managerDAO;

import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;

import by.gstu.Testing.interfacesDAO.QuestionDAO;
import by.gstu.Testing.interfacesDAO.ResultDAO;
import by.gstu.Testing.interfacesDAO.StudentDAO;
import by.gstu.Testing.interfacesDAO.SubjectDAO;
import by.gstu.Testing.interfacesDAO.TestDAO;
import by.gstu.Testing.interfacesDAO.TestSpecifDAO;
import by.gstu.Testing.interfacesDAO.TutorDAO;
import by.gstu.Testing.mysqlImplementsDAO.MysqlQuestionDAO;
import by.gstu.Testing.mysqlImplementsDAO.MysqlResultDAO;
import by.gstu.Testing.mysqlImplementsDAO.MysqlStudentDAO;
import by.gstu.Testing.mysqlImplementsDAO.MysqlSubjectDAO;
import by.gstu.Testing.mysqlImplementsDAO.MysqlTestDAO;
import by.gstu.Testing.mysqlImplementsDAO.MysqlTestSpecifDAO;
import by.gstu.Testing.mysqlImplementsDAO.MysqlTutorDAO;
import by.gstu.Testing.resource.Resource;

public class MysqlDAOFactory extends DAOFactory {

	public TutorDAO getTutorDAO() throws ClassNotFoundException {

		return new MysqlTutorDAO();
	}

	public StudentDAO getStudentDAO() throws ClassNotFoundException {

		return new MysqlStudentDAO();
	}

	public SubjectDAO getSubjectDAO() throws ClassNotFoundException {

		return new MysqlSubjectDAO();
	}

	public TestDAO getTestDAO() throws ClassNotFoundException {

		return new MysqlTestDAO();
	}

	public QuestionDAO getQuestionDAO() throws ClassNotFoundException {

		return new MysqlQuestionDAO();
	}

	public TestSpecifDAO getTestSpecifDAO() throws ClassNotFoundException {

		return new MysqlTestSpecifDAO();
	}

	public ResultDAO getResultDAO() throws ClassNotFoundException {

		return new MysqlResultDAO();
	}
	
	public static DriverAdapterCPDS setDataSourceParams() throws ClassNotFoundException{
		DriverAdapterCPDS pcds = new DriverAdapterCPDS();
		pcds.setDriver(Resource.getDBProperties("driver.link"));
		pcds.setUrl(Resource.getDBProperties("connection.path"));
		pcds.setUser(Resource.getDBProperties("admin.login"));
		pcds.setPassword(Resource.getDBProperties("admin.password"));
		return pcds;
	}
}