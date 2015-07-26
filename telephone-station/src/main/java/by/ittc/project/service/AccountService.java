package by.ittc.project.service;

import java.util.List;

import by.ittc.project.database.dao.AccountDAO;
import by.ittc.project.database.dao.AccountDAOImpl;
import by.ittc.project.model.Account;

public class AccountService {

	private AccountDAO accountDAO = new AccountDAOImpl();

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public void addAccount(Account account) {
		accountDAO.addAccount(account);
	}

	public Account getAccountById(int id) {
		return accountDAO.getAccountById(id);
	}

	public List<Account> getAccountList() {
		return accountDAO.getAccountList();
	}

	public List<Account> getUnconfirmedAccountList() {
		return accountDAO.getUnconfirmedAccountList();
	}

	public List<Account> getBlockedAccountList() {
		return accountDAO.getBlockedAccountList();
	}

	public void banAccount(Account account) {
		accountDAO.banAccount(account);
	}

	public void confirmAccount(Account account) {
		accountDAO.confirmAccount(account);
	}
}
