package by.ittc.project.database.dao;

import java.util.List;

import by.ittc.project.model.User;

public interface UserDAO {
	void addUser(User user);

	User getUserById(int id);
	
	User getUserByLogin(String login);

	User getUserByLoginPassword(String login, String password);

	List<User> getUsersList();

	void updateUser(User user);

	void deleteUser(User user);
}
