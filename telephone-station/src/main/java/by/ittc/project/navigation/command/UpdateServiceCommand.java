package by.ittc.project.navigation.command;

import static by.ittc.project.constants.Constants.ADMIN_SERVICE_PAGE;
import static by.ittc.project.constants.Constants.MAIN_PAGE;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_DURATION;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERROR;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERRORS;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_PRICE;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_SERVICES;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_SERVICE_ID;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_SERVICE_NAME;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.ittc.project.model.Service;
import by.ittc.project.service.ServiceService;

public class UpdateServiceCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		CommandUtils commandUtils = new CommandUtils();
		if (!commandUtils.isAdminAuthorized(request)) {
			errors.put(PARAMETER_NAME_ERROR, "Access denied");
			request.setAttribute(PARAMETER_NAME_ERRORS, errors);
			return MAIN_PAGE;
		}

		int serviceId = commandUtils.strToInt(request
				.getParameter(PARAMETER_NAME_SERVICE_ID));
		String serviceName = request.getParameter(PARAMETER_NAME_SERVICE_NAME);
		int price = commandUtils.strToInt(request
				.getParameter(PARAMETER_NAME_PRICE));
		int duration = commandUtils.strToInt(request
				.getParameter(PARAMETER_NAME_DURATION));

		ServiceService serviceService = new ServiceService();
		Service service = buildService(serviceId, serviceName, price, duration);
		if (service != null) {
			serviceService.updateService(service);
			List<Service> services = serviceService.getServicesList();
			request.setAttribute(PARAMETER_NAME_SERVICES, services);
			return ADMIN_SERVICE_PAGE;
		} else {
			errors.put(PARAMETER_NAME_ERROR,
					"something is going wrong, try again");
			request.setAttribute(PARAMETER_NAME_ERRORS, errors);
			List<Service> services = serviceService.getServicesList();
			request.setAttribute(PARAMETER_NAME_SERVICES, services);
			return ADMIN_SERVICE_PAGE;
		}

	}

	private Service buildService(int id, String serviceName, int price,
			int duration) {
		Service service = new Service();
		service.setId(id);
		service.setServiceName(serviceName);
		service.setPrice(price);
		service.setDuration(duration);
		return service;
	}

}
