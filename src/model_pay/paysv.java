package model_pay;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

/**
 * Servlet implementation class pavsv
 */
@WebServlet("/pavsv")
public class paysv extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public paysv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User)request.getAttribute("User");
		request.setCharacterEncoding("UTF-8");
		int paymoney = Integer.parseInt(request.getParameter("paymoney"));
		int getmoney = Integer.parseInt(request.getParameter("getmoney"));
		String itemname = request.getParameter("itemname");
		String day = request.getParameter("day");
		int id = user.getId();
		String btn = request.getParameter("btn");

		if("出費追加".equals(btn)){
			paymoney *= -1;
			Payed pay = new Payed(id, itemname, day,paymoney);
			SetPay  sp = new SetPay();
			boolean decision = sp.execute(pay);
		}
		if("収入追加".equals(btn)){
			Payed pay = new Payed(id, itemname, day, getmoney);
			SetPay  sp = new SetPay();
			boolean decision = sp.execute(pay);
		}

	}

}
