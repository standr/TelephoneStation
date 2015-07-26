package by.ittc.project.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.ittc.project.database.utils.DBUtils;
import by.ittc.project.model.AccountStatus;

public class AccountStatusDAOImpl implements AccountStatusDAO {

	private static final String GET_STATUS_ID = "SELECT id FROM account_status WHERE status=?";
	private static final String GET_STATUS_BY_ID = "SELECT status FROM account_status WHERE id=?";

	private static final Logger log = Logger.getLogger(AccountDAOImpl.class
			.getName());
	private Connection connection;

	@Override
	public int getAccountStatusId(AccountStatus accountStatus) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			int roleId = 0;

			preparedStatement = connection.prepareStatement(GET_STATUS_ID);
			preparedStatement.setString(1, accountStatus.toString());

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				roleId = rs.getInt(1);
			}

			return roleId;
		} catch (SQLException e) {
			e.printStackTrace();
			log.info(e.toString());
			return 0;
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
					log.info(e.toString());
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					log.info(e.toString());
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					log.info(e.toString());
				}
			}
		}
	}

	@Override
	public AccountStatus getAccountStatusById(int id) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			String statusStr = null;

			preparedStatement = connection.prepareStatement(GET_STATUS_BY_ID);
			preparedStatement.setInt(1, id);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				statusStr = rs.getString(1);
			}

			return AccountStatus.valueOf(statusStr);
		} catch (SQLException e) {
			e.printStackTrace();
			log.info(e.toString());
			return null;
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
					log.info(e.toString());
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
					log.info(e.toString());
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
					log.info(e.toString());
				}
			}
		}
	}

}
