package by.ittc.project.navigation.command;

import static by.ittc.project.constants.Constants.MAIN_PAGE;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERROR;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERRORS;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_USERS;
import static by.ittc.project.constants.Constants.USERS_PAGE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.ittc.project.model.User;
import by.ittc.project.service.UserService;

public class GetUsersCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		CommandUtils commandUtils = new CommandUtils();
		if (!commandUtils.isAdminAuthorized(request)) {
			errors.put(PARAMETER_NAME_ERROR, "Access denied");
			request.setAttribute(PARAMETER_NAME_ERRORS, errors);
			return MAIN_PAGE;
		}

		UserService userService = new UserService();
		List<User> users = userService.getUsersList();
		request.setAttribute(PARAMETER_NAME_USERS, users);
		return USERS_PAGE;
	}

}
