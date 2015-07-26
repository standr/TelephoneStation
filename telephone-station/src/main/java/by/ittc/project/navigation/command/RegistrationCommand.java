package by.ittc.project.navigation.command;

import static by.ittc.project.constants.Constants.ACCOUNT_PAGE;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_EMAIL;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERROR;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERRORS;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_LOGIN;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_PASSWORD;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_USER;
import static by.ittc.project.constants.Constants.REGISTRATION_PAGE;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.ittc.project.model.Role;
import by.ittc.project.model.User;
import by.ittc.project.service.UserService;

public class RegistrationCommand implements Command {

	private static final Logger log = Logger
			.getLogger(RegistrationCommand.class.getName());

	@Override
	public String execute(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		String login = request.getParameter(PARAMETER_NAME_LOGIN);
		String email = request.getParameter(PARAMETER_NAME_EMAIL);
		String password = request.getParameter(PARAMETER_NAME_PASSWORD);

		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setEmail(email);
		user.setRole(Role.USER);

		UserService userService = new UserService();

		if (!isUserLoginExist(login)) {
			request.getSession().setAttribute(PARAMETER_NAME_USER, user);
			userService.addUser(user);
			log.info("New user registered and setted in session: "
					+ user.getLogin());
			return ACCOUNT_PAGE;
		} else {
			errors.put(PARAMETER_NAME_ERROR, "This login is already exists");
			request.setAttribute(PARAMETER_NAME_ERRORS, errors);
			return REGISTRATION_PAGE;
		}
	}

	private boolean isUserLoginExist(String login) {
		UserService userService = new UserService();
		User user = userService.getUserByLogin(login);

		if (user.getId() == 0) {
			return false;
		} else {
			return true;
		}
	}
}
