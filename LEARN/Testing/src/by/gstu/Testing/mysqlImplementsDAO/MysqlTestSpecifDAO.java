package by.gstu.Testing.mysqlImplementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.gstu.Testing.entities.TestSpecif;
import by.gstu.Testing.interfacesDAO.TestSpecifDAO;
import by.gstu.Testing.managerDAO.DBConnectionPool;
import by.gstu.Testing.managerDAO.MysqlDAOFactory;
import by.gstu.Testing.resource.Resource;

public class MysqlTestSpecifDAO implements TestSpecifDAO {
	DBConnectionPool pool = null;
	static Logger logger = Logger.getLogger(MysqlTestSpecifDAO.class);

	public MysqlTestSpecifDAO() throws ClassNotFoundException {
		pool = new DBConnectionPool(MysqlDAOFactory.setDataSourceParams());
	}

	public void insertTestSpecif(int testIdVal, int[] questionIdListVal) {

		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {

				for (int i = 0; i < questionIdListVal.length; i++) {
					st = cn.prepareStatement(Resource
							.getDBProperties("query.testspec.insert"));
					st.setInt(1, testIdVal);
					st.setInt(2, questionIdListVal[i]);
					st.executeUpdate();
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
	}

	

	public TestSpecif findTestSpecif(int testIdVal) {
		int tempTestIdVal = 0;
		List<Integer> idTestSpecValue = new ArrayList<Integer>();
		List<Integer> questionIdList = new ArrayList<Integer>();
		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.testspec.find"));
				st.setInt(1, testIdVal);
				ResultSet rs = null;
				try {
					rs = st.executeQuery();
					while (rs.next()) {
						tempTestIdVal = rs.getInt(Resource
								.getDBProperties("testsquestions.field.idtest"));
						idTestSpecValue
								.add(rs.getInt(Resource
										.getDBProperties("testsquestions.field.idtestquest")));
						questionIdList
								.add(rs.getInt(Resource
										.getDBProperties("testsquestions.field.idquestion")));
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
		return new TestSpecif(idTestSpecValue, tempTestIdVal, questionIdList);
	}

	public List<TestSpecif> selectTestTO() {
		int tempTestIdVal = 0;
		List<Integer> idTestSpecValue = new ArrayList<Integer>();
		List<Integer> questionIdList = new ArrayList<Integer>();
		List<TestSpecif> outCollect = new ArrayList<TestSpecif>();
		try {
			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.testspec.select"));
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {

						tempTestIdVal = rs.getInt(Resource
								.getDBProperties("testsquestions.field.idtest"));
						idTestSpecValue
								.add(rs.getInt(Resource
										.getDBProperties("testsquestions.field.idtestquest")));
						questionIdList
								.add(rs.getInt(Resource
										.getDBProperties("testsquestions.field.idquestion")));
						outCollect.add(new TestSpecif(idTestSpecValue,
								tempTestIdVal, questionIdList));
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
