package by.gstu.Testing.mysqlImplementsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


import by.gstu.Testing.entities.Question;
import by.gstu.Testing.interfacesDAO.QuestionDAO;
import by.gstu.Testing.managerDAO.DBConnectionPool;
import by.gstu.Testing.managerDAO.MysqlDAOFactory;
import by.gstu.Testing.resource.Resource;

public class MysqlQuestionDAO implements QuestionDAO {
	DBConnectionPool pool = null;
	static Logger logger = Logger.getLogger(MysqlQuestionDAO.class);

	public MysqlQuestionDAO() throws ClassNotFoundException {
		pool = new DBConnectionPool(MysqlDAOFactory.setDataSourceParams());
	}

	public void insertQuestion(int subjectIdVal, String textQuestionVal,
			String varAval, String varBval, String varCval, String varDval) {

		try {

			Connection cn = pool.getConnection();
			PreparedStatement ps = null;
			try {
				String sql = Resource.getDBProperties("query.question.insert");
				ps = cn.prepareStatement(sql);
				ps.setInt(1,subjectIdVal);
				ps.setString(2,textQuestionVal);
				ps.setString(3, varAval);
				ps.setString(4, varBval);
				ps.setString(5, varCval);
				ps.setString(6, varDval);
                ps.executeUpdate();

			} finally {
				if (ps != null)
					ps.close();
				else
					logger.error(Resource.getStrErr("error.notload.statement"));
			}
		} catch (SQLException e) {
			logger.error(e);
		}
		pool.close();
		logger.info("Question added!");
	}

	

	public Question findQuestion(int questionId) {
		String textQuestionValue = "", varAVal = "", varBVal = "", varCVal = "", varDVal = "";
		int subjectidValue = 0, idValue = 0, answerVal = 0;

		try {

			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.question.find"));
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						int tempQuestionId = rs.getInt(Resource
								.getDBProperties("questions.field.idquestion"));
						if (tempQuestionId == questionId) {

							idValue = tempQuestionId;

							varAVal = rs.getString(Resource
									.getDBProperties("questions.field.vara"));
							varBVal = rs.getString(Resource
									.getDBProperties("questions.field.varb"));
							varCVal = rs.getString(Resource
									.getDBProperties("questions.field.varc"));
							varDVal = rs.getString(Resource
									.getDBProperties("questions.field.vard"));
							subjectidValue = rs
									.getInt(Resource
											.getDBProperties("questions.field.subjectname"));
							textQuestionValue = rs
									.getString(Resource
											.getDBProperties("questions.field.textquestion"));
							answerVal = rs.getInt(Resource
									.getDBProperties("questions.field.answer"));
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
		logger.info(new Question(idValue, subjectidValue, textQuestionValue,
				varAVal, varBVal, varCVal, varDVal, answerVal) + "added");
		return new Question(idValue, subjectidValue, textQuestionValue,
				varAVal, varBVal, varCVal, varDVal, answerVal);
	}

	

	public List<Question> selectQuestionTO(int subjectIdVal) {

		String textQuestionValue = "", varAVal = "", varBVal = "", varCVal = "", varDVal = "";
		int subjectidValue = 0, idValue = 0, answerVal = 0;
		List<Question> outCollect = new ArrayList<Question>();
		try {
			Connection cn = pool.getConnection();
			PreparedStatement st = null;
			try {
				st = cn.prepareStatement(Resource
						.getDBProperties("query.question.find"));
				ResultSet rs = null;
				try {
					rs = st.executeQuery();

					while (rs.next()) {
						int tempSubjId = rs.getInt(Resource
								.getDBProperties("questions.field.subjectname"));
						if (tempSubjId == subjectIdVal) {

							idValue = rs
									.getInt(Resource
											.getDBProperties("questions.field.idquestion"));
							varAVal = rs.getString(Resource
									.getDBProperties("questions.field.vara"));
							varBVal = rs.getString(Resource
									.getDBProperties("questions.field.varb"));
							varCVal = rs.getString(Resource
									.getDBProperties("questions.field.varc"));
							varDVal = rs.getString(Resource
									.getDBProperties("questions.field.vard"));
							subjectidValue = subjectIdVal;
							textQuestionValue = rs
									.getString(Resource
											.getDBProperties("questions.field.textquestion"));
							answerVal = rs.getInt(Resource
									.getDBProperties("questions.field.answer"));
							outCollect.add(new Question(idValue,
									subjectidValue, textQuestionValue, varAVal,
									varBVal, varCVal, varDVal, answerVal));
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
		return outCollect;
	}

}
