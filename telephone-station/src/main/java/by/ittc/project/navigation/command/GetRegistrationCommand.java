package by.ittc.project.navigation.command;

import javax.servlet.http.HttpServletRequest;
import static by.ittc.project.constants.Constants.*;

public class GetRegistrationCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		return REGISTRATION_PAGE;
	}

}
