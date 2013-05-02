package by.gstu.Testing.interfacesDAO;

import java.util.List;
import by.gstu.Testing.entities.Tutor;


public interface TutorDAO {
	public boolean insertTutor(String lastNameVal, String firstNameVal,
			String postVAl, String login, String password);

	public Tutor findTutor(String lastNameVal);
	
	public Tutor getTutorByAuthInfo(String login, String password);

}
