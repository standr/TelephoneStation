package by.ittc.project.database.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import by.ittc.project.resource.Resource;

public class DBUtils {

	public static final String DATABASE_DRIVER_CLASSNAME = "db.driver.class";
	public static final String DATABASE_URL_PATH = "db.url.path";
	public static final String USERNAME = "db.admin.username";
	public static final String PASSWORD = "db.admin.password";

	private static DBUtils instance;

	private BasicDataSource dataSource;

	private DBUtils() {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(Resource
				.getStr(DATABASE_DRIVER_CLASSNAME));
		dataSource.setUrl(Resource.getStr(DATABASE_URL_PATH));
		dataSource.setUsername(Resource.getStr(USERNAME));
		dataSource.setPassword(Resource.getStr(PASSWORD));
	}

	public static DBUtils getInstance() {
		if (instance == null) {
			instance = new DBUtils();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}

	public BasicDataSource getDataSource() {
		return dataSource;
	}
}
