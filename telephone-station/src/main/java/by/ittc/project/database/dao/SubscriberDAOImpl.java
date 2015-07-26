package by.ittc.project.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.ittc.project.database.utils.DBUtils;
import by.ittc.project.model.Subscriber;

public class SubscriberDAOImpl implements SubscriberDAO {
	private final String ADD_SUBSCRIBER = "INSERT INTO subscriber (firstname, lastname, user_id, account_id) VALUES (?,?,?,?)";
	private final String UPDATE_SUBSCRIBER = "UPDATE subscriber SET firstname=?, lastname=?, user_id=?, account_id=? WHERE id=?";
	private final String GET_SUBSCRIBER_BY_ID = "SELECT * FROM subscriber WHERE id=?";
	private final String GET_SUBSCRIBER_BY_USER_ID = "SELECT * FROM subscriber WHERE user_id=?";
	private final String GET_SUBSCRIBERS_LIST = "SELECT * FROM subscriber";

	private static final Logger log = Logger.getLogger(SubscriberDAOImpl.class
			.getName());
	private Connection connection;

	@Override
	public void addSubscriber(Subscriber subscriber) {
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(ADD_SUBSCRIBER);
			preparedStatement.setString(1, subscriber.getFirstname());
			preparedStatement.setString(2, subscriber.getLastname());
			preparedStatement.setInt(3, subscriber.getUserId());
			preparedStatement.setInt(4, subscriber.getAccountId());
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
	public void updateSubscriber(Subscriber subscriber) {
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SUBSCRIBER);
			preparedStatement.setString(1, subscriber.getFirstname());
			preparedStatement.setString(2, subscriber.getLastname());
			preparedStatement.setInt(3, subscriber.getUserId());
			preparedStatement.setInt(4, subscriber.getAccountId());
			preparedStatement.setInt(5, subscriber.getId());

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
	public Subscriber getSubscriberById(int id) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			Subscriber subscriber = new Subscriber();

			preparedStatement = connection
					.prepareStatement(GET_SUBSCRIBER_BY_ID);
			preparedStatement.setInt(1, id);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				buildSubscriber(rs, subscriber);
			}

			return subscriber;
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
	public List<Subscriber> getSubscribersList() {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			List<Subscriber> subscribersList = new ArrayList<Subscriber>();

			preparedStatement = connection
					.prepareStatement(GET_SUBSCRIBERS_LIST);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Subscriber subscriber = new Subscriber();
				buildSubscriber(rs, subscriber);
				subscribersList.add(subscriber);
			}

			return subscribersList;
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

	private void buildSubscriber(ResultSet rs, Subscriber subscriber)
			throws SQLException {
		subscriber.setId(rs.getInt(1));
		subscriber.setFirstname(rs.getString(2));
		subscriber.setLastname(rs.getString(3));
		subscriber.setUserId(rs.getInt(4));
		subscriber.setAccountId(rs.getInt(5));
	}

	@Override
	public Subscriber getSubscriberByUserId(int userId) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			Subscriber subscriber = new Subscriber();

			preparedStatement = connection
					.prepareStatement(GET_SUBSCRIBER_BY_USER_ID);
			preparedStatement.setInt(1, userId);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				buildSubscriber(rs, subscriber);
			}

			return subscriber;
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