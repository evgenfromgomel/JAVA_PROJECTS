package by.gstu.Testing.mysqlImplementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import by.gstu.Testing.entities.Student;
import by.gstu.Testing.interfacesDAO.StudentDAO;
import by.gstu.Testing.managerDAO.DBConnectionPool;
import by.gstu.Testing.managerDAO.MysqlDAOFactory;
import by.gstu.Testing.resource.Resource;

public class MysqlStudentDAO implements StudentDAO {
	DBConnectionPool pool = null;
	static Logger logger = Logger.getLogger(MysqlStudentDAO.class);

	public MysqlStudentDAO() throws ClassNotFoundException {
		pool = new DBConnectionPool(MysqlDAOFactory.setDataSourceParams());
	}

	public Student getStudentByAuthInfo(String login, String password) {
		String lastNameValue = "", firstNameValue = "", groupVal = "", loginVal = "", passwordVal = "";
		int idValue = 0;
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				
				String sql = Resource.getDBProperties("query.student.logpass");
				st = cn.prepareStatement(sql);
				st.setString(1, login);
				st.setString(2, password);
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						String tempLastName = rs.getString(Resource
								.getDBProperties("student.field.lastname"));

						idValue = rs.getInt(Resource
								.getDBProperties("student.field.idstudent"));
						lastNameValue = tempLastName;
						firstNameValue = rs.getString(Resource
								.getDBProperties("student.field.firstname"));
						groupVal = rs.getString(Resource
								.getDBProperties("student.field.group"));
						loginVal = rs.getString(Resource
								.getDBProperties("student.field.login"));
						passwordVal = rs.getString(Resource
								.getDBProperties("student.field.password"));
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
		return new Student(idValue, lastNameValue, firstNameValue, groupVal,
				loginVal, passwordVal);
	}

	public Student getStudentById(int studentId) {
		String lastNameValue = "", firstNameValue = "", groupVal = "", loginVal = "", passwordVal = "";
		int idValue = 0;
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				String sql = Resource
				.getDBProperties("query.student.id");
				st = cn.prepareStatement(sql);
				st.setInt(1, studentId);
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						String tempLastName = rs.getString(Resource
								.getDBProperties("student.field.lastname"));

						idValue = rs.getInt(Resource
								.getDBProperties("student.field.idstudent"));
						lastNameValue = tempLastName;
						firstNameValue = rs.getString(Resource
								.getDBProperties("student.field.firstname"));
						groupVal = rs.getString(Resource
								.getDBProperties("student.field.group"));
						loginVal = rs.getString(Resource
								.getDBProperties("student.field.login"));
						passwordVal = rs.getString(Resource
								.getDBProperties("student.field.password"));
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
		return new Student(idValue, lastNameValue, firstNameValue, groupVal,
				loginVal, passwordVal);
	}

	public boolean insertStudent(String lastNameValue, String firstNameValue,
			String groupVal, String login, String password) {
		boolean resultInsert = true;
		try {
			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				String sql = Resource.getDBProperties("query.student.insert");
				st = cn.prepareStatement(sql);
				st.setString(1, lastNameValue);
				st.setString(2, firstNameValue);
				st.setString(3, groupVal);
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

		}
		pool.close();
		return resultInsert;
	}

	public boolean deleteStudent(String lastNameVal) {
		boolean deleteDone = false;
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				String sql = Resource.getDBProperties("query.student.delete");
				st = cn.prepareStatement(sql);
				st.setString(1, lastNameVal);
				st.executeUpdate();
				deleteDone = true;
			} finally {
				if (st != null)
					st.close();
				else
					deleteDone = false;
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		pool.close();
		return deleteDone;
	}

	public Student findStudent(String lastNameVal) {
		String lastNameValue = "", firstNameValue = "", groupVal = "", loginVal = "", passwordVal = "";
		int idValue = 0;
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.student.find"));
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						String tempLastName = rs.getString(Resource
								.getDBProperties("student.field.lastname"));
						if (tempLastName.equals(lastNameVal)) {
							idValue = rs.getInt(Resource
									.getDBProperties("student.field.idstudent"));
							lastNameValue = tempLastName;
							firstNameValue = rs.getString(Resource
									.getDBProperties("student.field.firstname"));
							groupVal = rs.getString(Resource
									.getDBProperties("student.field.group"));
							loginVal = rs.getString(Resource
									.getDBProperties("student.field.login"));
							passwordVal = rs.getString(Resource
									.getDBProperties("student.field.password"));
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
		}
		pool.close();
		return new Student(idValue, lastNameValue, firstNameValue, groupVal,
				loginVal, passwordVal);
	}

	

	public List<Student> selectStudentTO(String groupVal) {
		String lastNameValue = "", firstNameValue = "", loginVal = "", passwordVal = "";
		int idValue = 0;
		List<Student> outCollect = new ArrayList<Student>();
		try {
			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.student.select"));
				st.setString(1, groupVal);
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						idValue = rs.getInt(Resource
								.getDBProperties("student.field.idstudent"));
						lastNameValue = rs.getString(Resource
								.getDBProperties("student.field.lastname"));
						firstNameValue = rs.getString(Resource
								.getDBProperties("student.field.firstname"));
						groupVal = rs.getString(Resource
								.getDBProperties("student.field.group"));
						loginVal = rs.getString(Resource
								.getDBProperties("student.field.login"));
						passwordVal = rs.getString(Resource
								.getDBProperties("student.field.password"));
						outCollect
								.add(new Student(idValue, lastNameValue,
										firstNameValue, groupVal, loginVal,
										passwordVal));
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
		}
		pool.close();
		return outCollect;
	}

}
