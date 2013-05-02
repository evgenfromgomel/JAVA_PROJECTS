package by.gstu.Testing.interfacesDAO;

import java.util.List;
import by.gstu.Testing.entities.Subject;


public interface SubjectDAO {
	public Subject findSubject(int idValue);

	public List<Subject> selectSubjectTO();
}
