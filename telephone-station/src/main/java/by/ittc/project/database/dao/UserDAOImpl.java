package by.ittc.project.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.ittc.project.database.utils.DBUtils;
import by.ittc.project.model.Role;
import by.ittc.project.model.User;

public class UserDAOImpl implements UserDAO {

	private static final Logger log = Logger.getLogger(UserDAOImpl.class
			.getName());
	private Connection connection;

	private final String ADD_USER = "INSERT INTO user (login, password, email, role_id) VALUES (?,?,?,?)";
	private final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
	private final String GET_USERS_LIST = "SELECT * FROM user";
	private final String UPDATE_USER = "UPDATE user SET login=?, password=?, email=?, role_id=? WHERE id=?";
	private final String DELETE_USER = "DELETE FROM user WHERE id=?";
	private final String GET_USER_BY_LOGIN_PASSWORD = "SELECT * FROM user WHERE login=? and password=?";
	private final String GET_USER_BY_LOGIN = "SELECT * FROM user WHERE login=?";

	@Override
	public void addUser(final User user) {

		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(ADD_USER);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, getRoleId(user.getRole()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			log.info(e.toString());
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
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
	public User getUserById(final int id) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			User user = new User();

			preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
			preparedStatement.setInt(1, id);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				buildUser(rs, user);
			}

			return user;
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

	@Override
	public List<User> getUsersList() {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			List<User> usersList = new ArrayList<User>();

			preparedStatement = connection.prepareStatement(GET_USERS_LIST);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				User user = new User();
				buildUser(rs, user);
				usersList.add(user);
			}

			return usersList;
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

	private void buildUser(ResultSet rs, User user) throws SQLException {
		user.setId(rs.getInt(1));
		user.setLogin(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setEmail(rs.getString(4));
		user.setRole(getRoleById(rs.getInt(5)));
	}

	@Override
	public void updateUser(final User user) {
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_USER);
			preparedStatement.setString(1, user.getLogin());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, getRoleId(user.getRole()));
			preparedStatement.setInt(5, user.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			log.info(e.toString());
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
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
	public void deleteUser(final User user) {
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(DELETE_USER);
			preparedStatement.setInt(1, user.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			log.info(e.toString());
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
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

	private int getRoleId(Role role) throws SQLException {
		RoleDAOImpl roleDAOImpl = new RoleDAOImpl();
		return roleDAOImpl.getRoleId(role);
	}

	private Role getRoleById(int id) throws SQLException {
		RoleDAOImpl roleDAOImpl = new RoleDAOImpl();
		return roleDAOImpl.getRoleById(id);
	}

	@Override
	public User getUserByLoginPassword(String login, String password) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			User user = new User();

			preparedStatement = connection
					.prepareStatement(GET_USER_BY_LOGIN_PASSWORD);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				buildUser(rs, user);
			}

			return user;
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

	@Override
	public User getUserByLogin(String login) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			User user = new User();

			preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN);
			preparedStatement.setString(1, login);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				buildUser(rs, user);
			}

			return user;
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
