package by.ittc.project.navigation.command;

import static by.ittc.project.constants.Constants.MAIN_PAGE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return MAIN_PAGE;
	}

}
