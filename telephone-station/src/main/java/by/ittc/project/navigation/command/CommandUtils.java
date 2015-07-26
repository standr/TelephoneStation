package by.ittc.project.navigation.command;

import static by.ittc.project.constants.Constants.PARAMETER_NAME_USER;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.ittc.project.model.Role;
import by.ittc.project.model.User;

public class CommandUtils {
	private static final Logger log = Logger.getLogger(CommandUtils.class
			.getName());

	public boolean isUserAuthorized(HttpServletRequest request) {
		User user = null;
		try {
			user = (User) request.getSession()
					.getAttribute(PARAMETER_NAME_USER);
			if ((user.getLogin() == null) || (user.getRole() != Role.USER)) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isAdminAuthorized(HttpServletRequest request) {
		User user = null;
		try {
			user = (User) request.getSession()
					.getAttribute(PARAMETER_NAME_USER);
			if ((user.getLogin() == null) || (user.getRole() != Role.ADMIN)) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public int strToInt(String str) {
		int result = 0;
		try {
			result = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			log.info(e.toString());
		}
		return result;
	}
}
