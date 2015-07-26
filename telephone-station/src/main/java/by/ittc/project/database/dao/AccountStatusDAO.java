package by.ittc.project.database.dao;

import by.ittc.project.model.AccountStatus;

public interface AccountStatusDAO {

	public AccountStatus getAccountStatusById(int id);

	public int getAccountStatusId(final AccountStatus accountStatus);

}
