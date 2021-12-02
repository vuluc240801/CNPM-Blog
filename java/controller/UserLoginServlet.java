package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class UserLoginServlet
 */
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;

	public void init() {
		userDAO = new UserDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String isremember = request.getParameter("remember");

		User ineed = new User("", email, password);
		String dest = "";
		boolean root = userDAO.selectUser(ineed);

		RequestDispatcher re = null;
		if (root) {
			dest = "home-page.jsp";
			
			User info = new User();
			
			try {
				info = userDAO.getUserInfo(email);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (info.getFirstname() == null || info.getLastname() == null) {
				dest = "Profile";
			} else {
				dest = "ViewContentServlet";
			}

			// Create session for first access
			HttpSession session = request.getSession();
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			
			System.out.println("Set session");

			if (isremember != null) {

				// Create cookies for email and password.
				// Don't use white spaces in the content of the cookie.
				// It is mentioning whitespace as the invalid character
				Cookie user_cookie = new Cookie("email", email);
				Cookie pass_cookie = new Cookie("password", password);

				// Set expired date after 24 Hrs for both the cookies.
				user_cookie.setMaxAge(60 * 60 * 24);
				pass_cookie.setMaxAge(60 * 60 * 24);

				// Add both the cookies in the response header.
				response.addCookie(user_cookie);
				response.addCookie(pass_cookie);
			}

		} else {
			request.setAttribute("message", "true");
			dest = "login.jsp";

		}
		re = request.getRequestDispatcher(dest);
		re.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
