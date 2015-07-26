package by.ittc.project.controller;

import static by.ittc.project.constants.Constants.PARAMETER_PAGE;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.ittc.project.navigation.command.Command;
import by.ittc.project.navigation.factory.CommandFactory;

/**
 * Servlet implementation class BaseController
 */
public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BaseController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		performAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		performAction(request, response);
	}

	private void performAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String page = null;
		String paramPage = request.getParameter(PARAMETER_PAGE);

		if (paramPage != null && !paramPage.isEmpty()) {
			CommandFactory factory = new CommandFactory();
			Command command = factory.getCommand(paramPage);
			page = command.execute(request);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(page);
			requestDispatcher.forward(request, response);
		} else {
			throw new IllegalArgumentException("paramPage don't exist");
		}
	}

}
