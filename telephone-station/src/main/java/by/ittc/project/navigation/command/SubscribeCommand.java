package by.ittc.project.navigation.command;

import static by.ittc.project.constants.Constants.MAIN_PAGE;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERROR;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_ERRORS;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_FIRSTNAME;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_LASTNAME;
import static by.ittc.project.constants.Constants.PARAMETER_NAME_USER;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.ittc.project.model.Account;
import by.ittc.project.model.AccountStatus;
import by.ittc.project.model.Subscriber;
import by.ittc.project.model.User;
import by.ittc.project.service.AccountService;
import by.ittc.project.service.SubscriberService;

public class SubscribeCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		Map<String, String> errors = new HashMap<String, String>();

		CommandUtils commandUtils = new CommandUtils();
		if (!commandUtils.isUserAuthorized(request)) {
			errors.put(PARAMETER_NAME_ERROR, "Access denied");
			request.setAttribute(PARAMETER_NAME_ERRORS, errors);
			return MAIN_PAGE;
		}

		AccountService accountService = new AccountService();
		SubscriberService subscribeService = new SubscriberService();
		User user = (User) request.getSession().getAttribute(
				PARAMETER_NAME_USER);
		String firstname = request.getParameter(PARAMETER_NAME_FIRSTNAME);
		String lastname = request.getParameter(PARAMETER_NAME_LASTNAME);
		Account account = buildAccount();
		accountService.addAccount(account);
		Subscriber subscriber = buildSubscriber(user, firstname, lastname,
				account);
		subscribeService.addSubscriber(subscriber);
		return null;
	}

	private Subscriber buildSubscriber(User user, String firstname,
			String lastname, Account account) {
		Subscriber subscriber = new Subscriber();
		subscriber.setFirstname(firstname);
		subscriber.setLastname(lastname);
		subscriber.setId(user.getId());
		subscriber.setAccountId(account.getId());
		return subscriber;
	}

	private Account buildAccount() {
		Account account = new Account();
		account.setAccountStatus(AccountStatus.UNCONFIRMED);
		account.setBalance(0);
		return account;
	}

}
