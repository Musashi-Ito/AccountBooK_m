package model_want;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
/**
 * Servlet implementation class Wantlistsv
 */
@WebServlet("/Wantlistsv")
public class Wantlistsv extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wantlistsv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getAttribute("User");
		request.setCharacterEncoding("UTF-8");
		int list_monay = Integer.parseInt(request.getParameter("listmoney"));
		String list_name = request.getParameter("listname");
		int list_priority = Integer.parseInt(request.getParameter("listpriority"));
		int id = user.getId();
		String btn = request.getParameter("btn");
		if("追加".equals(btn)){
			
		}
	}

}
