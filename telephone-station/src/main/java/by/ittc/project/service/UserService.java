package by.ittc.project.service;

import java.util.List;

import by.ittc.project.database.dao.UserDAO;
import by.ittc.project.database.dao.UserDAOImpl;
import by.ittc.project.model.User;

public class UserService {

	private UserDAO userDAO = new UserDAOImpl();

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void addUser(final User user) {
		userDAO.addUser(user);
	}

	public User getUserById(final int id) {
		return userDAO.getUserById(id);
	}

	public User getUserByLogin(String login) {
		return userDAO.getUserByLogin(login);
	}

	public User getUserByLoginPassword(final String login, final String password) {
		return userDAO.getUserByLoginPassword(login, password);
	}

	public List<User> getUsersList() {
		return userDAO.getUsersList();
	}

	public void updateUser(final User user) {
		userDAO.updateUser(user);
	}

	public void deleteUser(final User user) {
		userDAO.deleteUser(user);
	}
}
