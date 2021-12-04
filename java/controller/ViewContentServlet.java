package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContentDAO;
import dao.UserDAO;

import model.Content;

/**
 * Servlet implementation class ViewContentServlet
 */
public class ViewContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContentDAO contentDAO = new ContentDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewContentServlet() {
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
		
		HttpSession session = request.getSession();

		ArrayList<Content> contents = new ArrayList<Content>();
		contents = contentDAO.selecContent();

		session.setAttribute("contents", contents);
		request.getRequestDispatcher("view_content.tiles").forward(request, response);

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
