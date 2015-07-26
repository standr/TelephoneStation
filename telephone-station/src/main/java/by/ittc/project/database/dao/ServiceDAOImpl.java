package by.ittc.project.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.ittc.project.database.utils.DBUtils;
import by.ittc.project.model.Service;

public class ServiceDAOImpl implements ServiceDAO {

	private static final String DELETE_SERVICE = "DELETE FROM service WHERE id=?";
	private static final String UPDATE_SERVICE = "UPDATE service SET service_name=?, price=?, duration=? WHERE id=?";
	private static final String GET_SERVICES_LIST = "SELECT * FROM service";
	private static final String GET_SERVICE_BY_ID = "SELECT * FROM service WHERE id=?";
	private static final String GET_SERVICE_BY_ACCOUNT_ID = " SELECT id, service_name, price, duration  FROM service INNER JOIN service_account as s_a ON service.id = s_a.service_id WHERE s_a.account_id = ?";
	private static final String ADD_SERVICE = "INSERT INTO service (service_name, price, duration) VALUES (?,?,?)";

	private static final Logger log = Logger.getLogger(ServiceDAOImpl.class
			.getName());
	private Connection connection;

	@Override
	public void addService(Service service) {

		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(ADD_SERVICE);
			preparedStatement.setString(1, service.getServiceName());
			preparedStatement.setInt(2, service.getPrice());
			preparedStatement.setInt(3, service.getDuration());
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
	public Service getServiceById(int id) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			Service service = new Service();

			preparedStatement = connection.prepareStatement(GET_SERVICE_BY_ID);
			preparedStatement.setInt(1, id);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				buildService(rs, service);
			}

			return service;

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

	private void buildService(ResultSet rs, Service service)
			throws SQLException {
		service.setId(rs.getInt(1));
		service.setServiceName(rs.getString(2));
		service.setPrice(rs.getInt(3));
		service.setDuration(rs.getInt(4));
	}

	@Override
	public List<Service> getServicesList() {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			List<Service> servicesList = new ArrayList<Service>();

			preparedStatement = connection.prepareStatement(GET_SERVICES_LIST);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Service service = new Service();
				buildService(rs, service);
				servicesList.add(service);
			}

			return servicesList;
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
	public void updateService(Service service) {

		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(UPDATE_SERVICE);
			preparedStatement.setString(1, service.getServiceName());
			preparedStatement.setInt(2, service.getPrice());
			preparedStatement.setInt(3, service.getDuration());
			preparedStatement.setInt(4, service.getId());

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
	public void deleteService(Service service) {

		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(DELETE_SERVICE);
			preparedStatement.setInt(1, service.getId());

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
	public List<Service> getServicesByAccountId(int accountId) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			List<Service> servicesList = new ArrayList<Service>();

			preparedStatement = connection
					.prepareStatement(GET_SERVICE_BY_ACCOUNT_ID);
			preparedStatement.setInt(1, accountId);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Service service = new Service();
				buildService(rs, service);
				servicesList.add(service);
			}

			return servicesList;
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
