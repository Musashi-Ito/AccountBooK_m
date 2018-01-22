package model_want;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		request.setCharacterEncoding("UTF-8");
		System.out.println("page forwarding Wantlistsv");
		String btn = request.getParameter("btn");
		//User user = (User)request.getAttribute("User");
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("User");

		System.out.println(u.getId());
		System.out.println(u.getAddress());
		System.out.println(u.getPwd());
		System.out.println(u.getName());

		int id = u.getId();

		int Amount;
		String Category;
		String TradeName;
		String Priority;

		if("追加".equals(btn)){
			//System.out.println("fuck you");

			///*
			Amount = Integer.parseInt(request.getParameter("Amount"));
			Category = request.getParameter("Category");
			TradeName = request.getParameter("TradeName");
			Priority = request.getParameter("Priority");

			Wantlist wl = new Wantlist(id, Category, Priority, TradeName, Amount);
			System.out.println(wl.getId());
			System.out.println(wl.getCategory());
			System.out.println(wl.getPriority());
			System.out.println(wl.getTradename());
			System.out.println(wl.getAmount());

			SetWantList swl = new SetWantList();
			boolean decision = swl.execute(wl);
			//*/

			if(decision){
				session = request.getSession();
			}

			request.setAttribute("User", u);
			request.setAttribute("Wantlist", wl);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/MyPage.jsp");
			dispatcher.forward(request, response);
		}

	}

}
