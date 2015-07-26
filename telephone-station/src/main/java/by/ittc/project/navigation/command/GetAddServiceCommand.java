package by.ittc.project.navigation.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import static by.ittc.project.constants.Constants.*;

public class GetAddServiceCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		CommandUtils commandUtils = new CommandUtils();
		if (!commandUtils.isAdminAuthorized(request)) {
			errors.put(PARAMETER_NAME_ERROR, "Access denied");
			request.setAttribute(PARAMETER_NAME_ERRORS, errors);
			return MAIN_PAGE;
		}

		return ADD_SERVICE_PAGE;
	}

}
