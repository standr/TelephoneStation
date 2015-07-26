package by.ittc.project.navigation.command;

import static by.ittc.project.constants.Constants.MAIN_PAGE;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERROR;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERRORS;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ID;
import static by.ittc.project.constants.Constants.USERS_PAGE;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.ittc.project.model.Account;
import by.ittc.project.model.Subscriber;
import by.ittc.project.service.AccountService;
import by.ittc.project.service.SubscriberService;

public class ActivateStatusCommand implements Command {

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
		AccountService accountService = new AccountService();
		Subscriber subscriber = subscriberService.getSubscriberDAO()
				.getSubscriberByUserId(userId);
		Account account = accountService.getAccountDAO().getAccountById(
				subscriber.getAccountId());
		accountService.addAccount(account);
		return USERS_PAGE;
	}

}
