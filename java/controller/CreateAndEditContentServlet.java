package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ContentDAO;
import dao.UserDAO;
import model.Content;

/**
 * Servlet implementation class CreateAndEditContentServlet
 */
public class CreateAndEditContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContentDAO contentDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAndEditContentServlet() {
        super();
        contentDAO = new ContentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		Content ct = new Content();
		
		int mode  = Integer.parseInt(request.getParameter("mode"));
		
		
		
		if (mode == 1) {
			String content_id = request.getParameter("content_id");
			System.out.println("CONTENT " + "UPDATE");
			
			session.setAttribute("mode", "Update");
			try {
				ct =  contentDAO.getContentByID(Integer.parseInt(content_id));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
        }  else {
        	session.setAttribute("mode", "Create");
        }
		
		session.setAttribute("content", ct);
		
	    request.getRequestDispatcher("form_content.tiles").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");
		
		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");
		int content_id = Integer.parseInt(request.getParameter("id"));
		
		
		HttpSession session = request.getSession();
		
		String email  = (String)session.getAttribute("email");
		UserDAO userDAO = new UserDAO();
		String user_id = "";
		
		System.out.println("POST CALL");
		
		
		
        try {
			user_id = userDAO.getID(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("USER: " + user_id);
        
        Content ct = new Content();
        
        if (mode=="Create") {
        	System.out.println("CREATE");
        	ct = new Content(title, brief, content , user_id);
        	try {
				contentDAO.insertContent(ct);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
        	System.out.println("UPDATE");
        	ct = new Content(content_id, title, brief, content , user_id);
        	try {
				contentDAO.updateContent(ct);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		
		
		
		doGet(request, response);
	}

}
