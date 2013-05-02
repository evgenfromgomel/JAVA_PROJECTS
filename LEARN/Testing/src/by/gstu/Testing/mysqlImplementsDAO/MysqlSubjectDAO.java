package by.gstu.Testing.mysqlImplementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import by.gstu.Testing.entities.Subject;
import by.gstu.Testing.interfacesDAO.SubjectDAO;
import by.gstu.Testing.managerDAO.DBConnectionPool;
import by.gstu.Testing.managerDAO.MysqlDAOFactory;
import by.gstu.Testing.resource.Resource;

public class MysqlSubjectDAO implements SubjectDAO {
	DBConnectionPool pool = null;
	static Logger logger = Logger.getLogger(MysqlSubjectDAO.class);

	public MysqlSubjectDAO() throws ClassNotFoundException {
		pool = new DBConnectionPool(MysqlDAOFactory.setDataSourceParams());
	}

	

	public Subject findSubject(int idValue) {
		String tempSubjectValue = "";
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.subject.find"));
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						int tempId = Integer.valueOf(rs.getString(Resource
								.getDBProperties("subject.field.idsubject")));
						if (tempId == idValue) {
							tempSubjectValue = rs.getString(Resource
									.getDBProperties("subject.field.subject"));
							break;
						}
					}
				} finally {
					if (rs != null)
						rs.close();
					else
						logger.error(Resource.getStrErr("error.notload.result"));
				}
			} finally {
				if (st != null)
					st.close();
				else
					logger.error(Resource.getStrErr("error.notload.statement"));
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		pool.close();
		return new Subject(idValue, tempSubjectValue);
	}

	public List<Subject> selectSubjectTO() {
		String subjectValue = "";
		int idValue = 0;
		List<Subject> outCollect = new ArrayList<Subject>();
		try {
			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.subject.find"));
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						idValue = rs.getInt(Resource
								.getDBProperties("subject.field.idsubject"));
						subjectValue = rs.getString(Resource
								.getDBProperties("subject.field.subject"));
						outCollect.add(new Subject(idValue, subjectValue));

					}
				} finally {
					if (rs != null)
						rs.close();
					else
						logger.error(Resource.getStrErr("error.notload.result"));
				}
			} finally {
				if (st != null)
					st.close();
				else
					logger.error(Resource.getStrErr("error.notload.statement"));
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		pool.close();
		return outCollect;
	}

}
