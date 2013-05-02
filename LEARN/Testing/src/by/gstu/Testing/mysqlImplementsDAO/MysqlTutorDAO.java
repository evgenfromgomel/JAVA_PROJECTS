package by.gstu.Testing.mysqlImplementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import by.gstu.Testing.entities.Tutor;
import by.gstu.Testing.interfacesDAO.TutorDAO;
import by.gstu.Testing.managerDAO.DBConnectionPool;
import by.gstu.Testing.managerDAO.MysqlDAOFactory;
import by.gstu.Testing.resource.Resource;

public class MysqlTutorDAO implements TutorDAO {
	DBConnectionPool pool = null;
	static Logger logger = Logger.getLogger(MysqlTutorDAO.class);

	public MysqlTutorDAO() throws ClassNotFoundException {
		pool = new DBConnectionPool(MysqlDAOFactory.setDataSourceParams());
	}

	public Tutor getTutorByAuthInfo(String login, String password) {
		String lastNameValue = "", firstNameValue = "", groupVal = "", loginVal = "", passwordVal = "";
		int idValue = 0;
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.tutor.logpass"));
				st.setString(1, login);
				st.setString(2, password);
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						String tempLastName = rs.getString(Resource
								.getDBProperties("tutor.field.lastname"));

						idValue = rs.getInt(Resource
								.getDBProperties("tutor.field.idtutor"));
						lastNameValue = tempLastName;
						firstNameValue = rs.getString(Resource
								.getDBProperties("tutor.field.firstname"));
						groupVal = rs.getString(Resource
								.getDBProperties("tutor.field.post"));
						loginVal = rs.getString(Resource
								.getDBProperties("tutor.field.login"));
						passwordVal = rs.getString(Resource
								.getDBProperties("tutor.field.password"));
						break;
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
		return new Tutor(idValue, lastNameValue, firstNameValue, groupVal,
				loginVal, passwordVal);
	}

	public boolean insertTutor(String lastNameValue, String firstNameValue,
			String postVal, String login, String password) {
		boolean resultInsert = true;
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource.getDBProperties("query.tutor.insert"));
				st.setString(1, lastNameValue);
				st.setString(2, firstNameValue);
				st.setString(3, postVal);
				st.setString(4, login);
				st.setString(5, password);
				st.executeUpdate();

			} finally {
				if (st != null)
					st.close();
				else
					resultInsert = false;
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		pool.close();
		return resultInsert;
	}

	

	public Tutor findTutor(String lastNameVal) {
		String lastNameValue = "", firstNameValue = "", postVal = "", loginVal = "", passwordVal = "";
		int idValue = 0;
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.tutor.find"));
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						String tempLastName = rs.getString(Resource
								.getDBProperties("tutor.field.lastname"));
						if (tempLastName.equals(lastNameVal)) {
							idValue = rs.getInt(Resource
									.getDBProperties("tutor.field.idtutor"));
							lastNameValue = tempLastName;
							firstNameValue = rs.getString(Resource
									.getDBProperties("tutor.field.firstname"));
							postVal = rs.getString(Resource
									.getDBProperties("tutor.field.post"));
							loginVal = rs.getString(Resource
									.getDBProperties("tutor.field.login"));
							passwordVal = rs.getString(Resource
									.getDBProperties("tutor.field.password"));
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
		return new Tutor(idValue, lastNameValue, firstNameValue, postVal,
				loginVal, passwordVal);
	}

	

	

}
