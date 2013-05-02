package by.gstu.Testing.mysqlImplementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.gstu.Testing.entities.Test;
import by.gstu.Testing.interfacesDAO.TestDAO;
import by.gstu.Testing.managerDAO.DBConnectionPool;
import by.gstu.Testing.managerDAO.MysqlDAOFactory;
import by.gstu.Testing.resource.Resource;

public class MysqlTestDAO implements TestDAO {
	DBConnectionPool pool = null;
	static Logger logger = Logger.getLogger(MysqlTestDAO.class);

	public MysqlTestDAO() throws ClassNotFoundException {
		pool = new DBConnectionPool(MysqlDAOFactory.setDataSourceParams());
	}

	public void insertTest(String testNameValue, int subjectIdValue) {
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource.getDBProperties("query.test.insert"));
                st.setString(1, testNameValue);
                st.setString(2, String.valueOf(subjectIdValue));
				st.executeUpdate();

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
	}

	
	public Test findTest(String testNameVal) {
		int tempSubjectIdValue = 0;
		String tempTestNameVal = "";
		int idValue = 0;
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.test.find"));
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						String tempTestName = rs.getString(Resource
								.getDBProperties("tests.field.nametest"));
						if (tempTestName.equals(testNameVal)) {
							idValue = rs.getInt(Resource
									.getDBProperties("tests.field.idtest"));
							tempTestNameVal = tempTestName;
							tempSubjectIdValue = Integer
									.valueOf(rs.getString(Resource
											.getDBProperties("tests.field.subject")));

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
		return new Test(idValue, tempTestNameVal, tempSubjectIdValue);
	}

	public String getTestNameById(int idTest) {
		String tempTestNameVal = "";
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.test.find"));
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						int tempSubjectIdValue = rs.getInt(Resource
								.getDBProperties("tests.field.idtest"));
						if (idTest == tempSubjectIdValue) {
							tempTestNameVal = rs.getString(Resource
									.getDBProperties("tests.field.nametest"));
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
		return tempTestNameVal;
	}

	

	public List<Test> selectTestTO(int subjectIdVal) {
		String testNameValue = "";
		int idValue = 0, subjectIdValue = 0;
		List<Test> outCollect = new ArrayList<Test>();
		try {
			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.test.select"));
				st.setInt(1, subjectIdVal);
				ResultSet rs = null;
				try {
					rs = st.executeQuery();
					while (rs.next()) {

						idValue = rs.getInt(Resource
								.getDBProperties("tests.field.idtest"));
						testNameValue = rs.getString(Resource
								.getDBProperties("tests.field.nametest"));
						subjectIdValue = subjectIdVal;
						outCollect.add(new Test(idValue, testNameValue,
								subjectIdValue));
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
