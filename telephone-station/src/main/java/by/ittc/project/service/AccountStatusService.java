package by.ittc.project.service;

import by.ittc.project.database.dao.AccountStatusDAO;
import by.ittc.project.database.dao.AccountStatusDAOImpl;
import by.ittc.project.model.AccountStatus;

public class AccountStatusService {

	private AccountStatusDAO accountStatusDAO = new AccountStatusDAOImpl();

	public AccountStatusDAO getAccountDAO() {
		return accountStatusDAO;
	}

	public void setAccountStatusDAO(AccountStatusDAO accountStatusDAO) {
		this.accountStatusDAO = accountStatusDAO;
	}

	public int getAccountStatusId(AccountStatus accountStatus) {
		return accountStatusDAO.getAccountStatusId(accountStatus);
	}

}
