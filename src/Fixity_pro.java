



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SetStart;
import model.User;
import model.UserMoney;
import model_fix.Fixity;
import model_fix.SetFix;

/**
 * Servlet implementation class Fixity_pro
 */
@WebServlet("/Fixity_pro")
public class Fixity_pro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fixity_pro() {
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
		//System.out.print("aaa");
		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("btn");
		//User user = (User)request.getAttribute("User");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("User");

		int id = user.getId();

		//System.out.println(user.getId());
		System.out.println(id);

		int Balance;
		int Goal;

		String type;
		int amount;
		int day;

		if("設定登録".equals(btn)){
			//System.out.print("chcke");

			/*
			Balance =  Integer.parseInt(request.getParameter("Balance"));
			Goal =  Integer.parseInt(request.getParameter("Goal"));

			Fixity fixs = new Fixity(Balance, Goal);
			fixs.setId(user.getId());
			SetStart ss = new SetStart();
			boolean fix = ss.execute(fixs);

			if(fix){
				session = request.getSession();

			}

			request.setAttribute("User", user);
			request.setAttribute("Fixity", fixs);
			*/

			Balance =  Integer.parseInt(request.getParameter("Balance"));
			Goal =  Integer.parseInt(request.getParameter("Goal"));

			UserMoney um = new UserMoney(user.getId(),Balance,Goal);
			SetStart ss = new SetStart();
			boolean decision = ss.execute(um);

			///*
			if(decision){
				session = request.getSession();

			}
			//*/

			request.setAttribute("User", user);
			//request.setAttribute("Fixity", fix);
			request.setAttribute("UserMoney", um);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/MyPage.jsp");
			dispatcher.forward(request, response);
		}


		if("設定更新".equals(btn)){
			//System.out.println("runnning");
		}

		if("収支登録".equals(btn)){
			type = request.getParameter("Type");
			amount = Integer.parseInt(request.getParameter("Amount"));
			day = Integer.parseInt(request.getParameter("Day"));

			Fixity fix = new Fixity(user.getId(),type,amount,day);
			System.out.println(fix.getId());
			System.out.println(fix.getType());
			System.out.println(fix.getMoney());
			System.out.println(fix.getDay());

			SetFix sf = new SetFix();
			boolean decision  = sf.execute(fix);

			if(decision){
				session = request.getSession();
			}

			request.setAttribute("User", user);
			request.setAttribute("Fixity", fix);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/MyPage.jsp");
			dispatcher.forward(request, response);
		}
	}
}
