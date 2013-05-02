package by.gstu.Testing.mysqlImplementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import by.gstu.Testing.entities.Result;
import by.gstu.Testing.interfacesDAO.ResultDAO;
import by.gstu.Testing.managerDAO.DBConnectionPool;
import by.gstu.Testing.managerDAO.MysqlDAOFactory;
import by.gstu.Testing.resource.Resource;

public class MysqlResultDAO implements ResultDAO {
	DBConnectionPool pool = null;
	static Logger logger = Logger.getLogger(MysqlResultDAO.class);

	public MysqlResultDAO() throws ClassNotFoundException {
		pool = new DBConnectionPool(MysqlDAOFactory.setDataSourceParams());
	}

	public void insertResult(int idStudent, int idTest, double result) {

		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource.getDBProperties("query.result.insert"));
				st.setInt(1, idStudent);
				st.setInt(2, idTest);
				st.setDouble(3, result);
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
		logger.info("Result added!");
	}

	public List<Result> selectByStudent(int studtentId) {
		int testIdValue = 0, resultIdValue = 0;
		double resultVal = 0;
		List<Result> outResultsList = new ArrayList<Result>();

		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.result.select"));
				st.setInt(1, studtentId);
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {

						testIdValue = rs.getInt(Resource
								.getDBProperties("result.field.idtest"));
						resultIdValue = rs.getInt(Resource
								.getDBProperties("result.field.idresult"));
						resultVal = rs.getDouble(Resource
								.getDBProperties("result.field.result"));
						outResultsList.add(new Result(resultIdValue,
								studtentId, testIdValue, resultVal));
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
		return outResultsList;
	}

	public List<Result> selectAll() {

		int testIdValue = 0, resultIdValue = 0, studentIdValue = 0;
		double resultVal = 0;
		List<Result> outResultsList = new ArrayList<Result>();
		try {
			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.result.select.all"));
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						studentIdValue = rs.getInt(Resource
								.getDBProperties("result.field.idsudent"));
						testIdValue = rs.getInt(Resource
								.getDBProperties("result.field.idtest"));
						resultIdValue = rs.getInt(Resource
								.getDBProperties("result.field.idresult"));
						resultVal = rs.getDouble(Resource
								.getDBProperties("result.field.result"));
						outResultsList.add(new Result(resultIdValue,
								studentIdValue, testIdValue, resultVal));

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
		return outResultsList;
	}

}
