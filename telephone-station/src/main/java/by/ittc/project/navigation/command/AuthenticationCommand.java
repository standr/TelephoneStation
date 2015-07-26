package by.ittc.project.navigation.command;

import static by.ittc.project.constants.Constants.ACCOUNT_PAGE;
import static by.ittc.project.constants.Constants.MAIN_PAGE;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERROR;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERRORS;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_LOGIN;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_PASSWORD;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_SUBSCRIBER;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_USER;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_USERS;
import static by.ittc.project.constants.Constants.USERS_PAGE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.ittc.project.model.Role;
import by.ittc.project.model.Subscriber;
import by.ittc.project.model.User;
import by.ittc.project.service.SubscriberService;
import by.ittc.project.service.UserService;

public class AuthenticationCommand implements Command {

	private static final Logger log = Logger
			.getLogger(AuthenticationCommand.class.getName());

	@Override
	public String execute(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		String login = request.getParameter(PARAMETER_NAME_LOGIN);
		String password = request.getParameter(PARAMETER_NAME_PASSWORD);

		UserService userService = new UserService();
		User user = userService.getUserByLoginPassword(login, password);

		if (user.getId() != 0) {
			request.getSession().setAttribute(PARAMETER_NAME_USER, user);
			if (user.getRole() == Role.ADMIN) {
				List<User> users = userService.getUsersList();
				log.info("Admin is set into session now and sign in.");
				request.setAttribute(PARAMETER_NAME_USERS, users);
				return USERS_PAGE;
			} else {
				SubscriberService subscriberService = new SubscriberService();
				Subscriber subscriber = subscriberService
						.getSubscriberByUserId(user.getId());
				request.setAttribute(PARAMETER_NAME_SUBSCRIBER, subscriber);
				log.info("User is set into session now and sign in.");
				return ACCOUNT_PAGE;
			}
		} else {
			errors.put(PARAMETER_NAME_ERROR,
					"please input login and password correctly...");
			request.setAttribute(PARAMETER_NAME_ERRORS, errors);
			return MAIN_PAGE;
		}
	}
}
