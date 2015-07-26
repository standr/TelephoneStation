package by.ittc.project.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.ittc.project.database.utils.DBUtils;
import by.ittc.project.model.Role;

public class RoleDAOImpl implements RoleDAO {

	private static final String GET_ROLE_BY_ID = "SELECT role_name FROM role WHERE id=?";
	private static final String GET_ROLE_ID = "SELECT id FROM role WHERE role_name=?";
	private static final Logger log = Logger.getLogger(RoleDAOImpl.class
			.getName());
	private Connection connection;

	@Override
	public int getRoleId(Role role) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			int roleId = 0;

			preparedStatement = connection.prepareStatement(GET_ROLE_ID);
			preparedStatement.setString(1, role.toString());

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
	public Role getRoleById(int id) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			String roleStr = null;

			preparedStatement = connection.prepareStatement(GET_ROLE_BY_ID);
			preparedStatement.setInt(1, id);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				roleStr = rs.getString(1);
			}

			return Role.valueOf(roleStr);
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
