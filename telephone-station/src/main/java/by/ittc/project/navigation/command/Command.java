package by.ittc.project.navigation.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {

	public String execute(final HttpServletRequest request);

}
