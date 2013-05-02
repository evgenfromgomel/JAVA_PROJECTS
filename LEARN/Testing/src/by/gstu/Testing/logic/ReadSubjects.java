package by.gstu.Testing.logic;

import java.util.List;

import by.gstu.Testing.entities.Subject;
import by.gstu.Testing.interfacesDAO.SubjectDAO;
import by.gstu.Testing.managerDAO.DAOFactory;

public class ReadSubjects {
	static DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

	public static String[] getSubjArray() throws ClassNotFoundException {
		String[] a = new String[4];
		SubjectDAO subj = mysqlFactory.getSubjectDAO();
		List<Subject> subjArr = subj.selectSubjectTO();
		for (int i = 0; i < subjArr.size(); i++)
			a[i] = subjArr.get(i).getSubject();
		return a;
	}

	public static String getSubj(int id) throws ClassNotFoundException {

		SubjectDAO subj = mysqlFactory.getSubjectDAO();
		return subj.findSubject(id).getSubject();
	}

}
