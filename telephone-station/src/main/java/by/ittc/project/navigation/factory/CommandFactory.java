package by.ittc.project.navigation.factory;

import by.ittc.project.navigation.command.*;

public class CommandFactory {

	public Command getCommand(String paramPage) {
		Commands command = Commands.valueOf(paramPage.toUpperCase());
		switch (command) {
		case GET_REGISTRATION:
			return new GetRegistrationCommand();
		case REGISTRATION:
			return new RegistrationCommand();
		case AUTHENTICATION:
			return new AuthenticationCommand();
		case SIGN_OUT:
			return new SignOutCommand();
		case GET_USER:
			return new GetUserCommand();
		case GET_USERS:
			return new GetUsersCommand();
		case GET_ADD_SERVICE:
			return new GetAddServiceCommand();
		case ADD_SERVICE:
			return new AddServiceCommand();
		case GET_SERVICE:
			return new GetServiceCommand();
		case GET_SERVICES:
			return new GetServicesCommand();
		case UPDATE_SERVICE:
			return new UpdateServiceCommand();
		case DELETE_SERVICE:
			return new DeleteServiceCommand();
		case SUBSCRIBE_COMMAND:
			return new SubscribeCommand();
		case CONFIRM_STATUS:
			return new ConfirmStatusCommand();
		case ACTIVATE_STATUS:
			return new ActivateStatusCommand();
		case BLOCK_STATUS:
			return new BlockStatusCommand();
		default:
			throw new IllegalArgumentException("command factory error");
		}
	}

}
