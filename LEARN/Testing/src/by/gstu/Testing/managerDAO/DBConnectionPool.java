package by.gstu.Testing.managerDAO;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp.cpdsadapter.DriverAdapterCPDS;
import org.apache.commons.dbcp.datasources.SharedPoolDataSource;
import org.apache.log4j.Logger;

import by.gstu.Testing.filters.SetCharFilter;
import by.gstu.Testing.resource.Resource;

public class DBConnectionPool {
	static Logger logger = Logger.getLogger(DBConnectionPool.class);
	private static final int MAX_ACTIVE = -1;
	private static final int MAX_WAIT = 100;
	private Connection connect = null;
	private static DataSource dataSource = null;

	public DBConnectionPool(DriverAdapterCPDS pcds) {
		if (dataSource == null) {
			SharedPoolDataSource tds = new SharedPoolDataSource();
			tds.setConnectionPoolDataSource(pcds);

			tds.setMaxActive(MAX_ACTIVE);

			tds.setMaxWait(MAX_WAIT);
			dataSource = tds;
		}
	}

	public Connection getConnection() throws SQLException {
		if (connect == null)
			connect = dataSource.getConnection();
		return connect;
	}

	public void close() {
		try {
			if (connect != null) {
				connect.close();
				connect = null;
			}
		} catch (SQLException e) {
			logger.error(e);
		}
	}
}