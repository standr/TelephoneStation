package by.ittc.project.database.dao;

import java.util.List;

import by.ittc.project.model.Account;

public interface AccountDAO {
	void addAccount(Account account);

	Account getAccountById(int id);

	List<Account> getAccountList();

	List<Account> getUnconfirmedAccountList();

	List<Account> getBlockedAccountList();

	void banAccount(Account account);

	void confirmAccount(Account account);

	void activateAccount(Account account);

}
