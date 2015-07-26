package by.ittc.project.model;

public class Account {
	private int id;
	private AccountStatus accountStatus;
	private int balance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
