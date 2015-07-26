package by.ittc.project.navigation.command;

import static by.ittc.project.constants.Constants.ADMIN_SERVICE_PAGE;
import static by.ittc.project.constants.Constants.MAIN_PAGE;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERROR;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERRORS;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_SERVICES;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.ittc.project.model.Service;
import by.ittc.project.service.ServiceService;

public class GetServicesCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		CommandUtils commandUtils = new CommandUtils();
		if (!commandUtils.isAdminAuthorized(request)) {
			errors.put(PARAMETER_NAME_ERROR, "Access denied");
			request.setAttribute(PARAMETER_NAME_ERRORS, errors);
			return MAIN_PAGE;
		}

		ServiceService serviceService = new ServiceService();
		List<Service> services = serviceService.getServicesList();
		request.setAttribute(PARAMETER_NAME_SERVICES, services);
		return ADMIN_SERVICE_PAGE;
	}

}
