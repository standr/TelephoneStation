package by.ittc.project.navigation.command;

import static by.ittc.project.constants.Constants.MAIN_PAGE;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERROR;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERRORS;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ID;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_SERVICES;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_SUBSCRIBER;
import static by.ittc.project.constants.Constants.USER_INFO_PAGE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.ittc.project.model.Service;
import by.ittc.project.model.Subscriber;
import by.ittc.project.service.ServiceService;
import by.ittc.project.service.SubscriberService;

public class GetUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		CommandUtils commandUtils = new CommandUtils();
		if (!commandUtils.isAdminAuthorized(request)) {
			errors.put(PARAMETER_NAME_ERROR, "Access denied");
			request.setAttribute(PARAMETER_NAME_ERRORS, errors);
			return MAIN_PAGE;
		}

		int userId = commandUtils.strToInt(request
				.getParameter(PARAMETER_NAME_ID));
		SubscriberService subscriberService = new SubscriberService();
		ServiceService serviceService = new ServiceService();
		Subscriber subscriber = subscriberService.getSubscriberByUserId(userId);
		List<Service> services = serviceService.getServicesByAccountId(subscriber.getAccountId());
		request.setAttribute(PARAMETER_NAME_SUBSCRIBER, subscriber);
		request.setAttribute(PARAMETER_NAME_SERVICES, services);
		return USER_INFO_PAGE;
	}

}
