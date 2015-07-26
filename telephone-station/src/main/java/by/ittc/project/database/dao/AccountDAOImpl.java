package by.ittc.project.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.ittc.project.database.utils.DBUtils;
import by.ittc.project.model.Account;
import by.ittc.project.model.AccountStatus;

public class AccountDAOImpl implements AccountDAO {

	private static final Logger log = Logger.getLogger(AccountDAOImpl.class
			.getName());
	private Connection connection;

	private final String ADD_ACCOUNT = "INSERT INTO account (account_status_id, balance) VALUES (?,?)";
	private final String GET_ACCOUNT_BY_ID = "SELECT * FROM account WHERE id=?";
	private final String GET_ACCOUNT_LIST = "SELECT * FROM account";
	private final String GET_UNCONFIRMED_ACCOUNT_LIST = "SELECT * FROM account WHERE account_status_id=3";
	private final String GET_BLOCKED_ACCOUT_LIST = "SELECT * FROM account WHERE account_status_id=3";
	private final String BAN_ACCOUNT = "UPDATE account SET account_status_id=2 WHERE id=?";
	private final String CONFIRM_ACCOUNT = "UPDATE account SET account_status_id=3 WHERE id=?";
	private final String ACTIVATE_ACCOUNT = "UPDATE account SET account_status_id=1 WHERE id=?";

	@Override
	public void addAccount(Account account) {
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(ADD_ACCOUNT);
			preparedStatement.setInt(1,
					getAccountStatusId(account.getAccountStatus()));
			preparedStatement.setInt(2, account.getBalance());
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
	public Account getAccountById(int id) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			Account account = new Account();

			preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_ID);
			preparedStatement.setInt(1, id);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				buildAccount(rs, account);
			}

			return account;
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
	public List<Account> getAccountList() {
		return getListByParameter(GET_ACCOUNT_LIST);
	}

	@Override
	public List<Account> getUnconfirmedAccountList() {
		return getListByParameter(GET_UNCONFIRMED_ACCOUNT_LIST);
	}

	@Override
	public List<Account> getBlockedAccountList() {
		return getListByParameter(GET_BLOCKED_ACCOUT_LIST);
	}

	private List<Account> getListByParameter(String parameter) {
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtils.getInstance().getConnection();
			List<Account> accountsList = new ArrayList<Account>();

			preparedStatement = connection.prepareStatement(parameter);

			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				buildAccount(rs, account);
				accountsList.add(account);
			}

			return accountsList;
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

	@Override
	public void banAccount(Account account) {
		changeAccountStatus(account, BAN_ACCOUNT);
	}

	@Override
	public void confirmAccount(Account account) {
		changeAccountStatus(account, CONFIRM_ACCOUNT);
	}

	@Override
	public void activateAccount(Account account) {
		changeAccountStatus(account, ACTIVATE_ACCOUNT);
	}

	private void changeAccountStatus(Account account, String parameter) {
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(parameter);
			preparedStatement.setInt(1, account.getId());

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

	private void buildAccount(ResultSet rs, Account account)
			throws SQLException {
		account.setId(rs.getInt(1));
		account.setAccountStatus(getAccountStatusById(rs.getInt(2)));
		account.setBalance(rs.getInt(3));
	}

	private AccountStatus getAccountStatusById(int id) {
		AccountStatusDAOImpl accountStatusDAOImpl = new AccountStatusDAOImpl();
		return accountStatusDAOImpl.getAccountStatusById(id);
	}

	private int getAccountStatusId(AccountStatus accountStatus) {
		AccountStatusDAOImpl accountStatusDAOImpl = new AccountStatusDAOImpl();
		return accountStatusDAOImpl.getAccountStatusId(accountStatus);
	}

}
