

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;
import model.UserMoney;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String address = request.getParameter("address");
		String pwd = request.getParameter("pwd");
		String btn = request.getParameter("btn");

		User u = new User(address, pwd);
		//Fixity fix = new Fixity();
		UserMoney um = new UserMoney();
		//System.out.println(address);
		//System.out.println(pwd);

		if("新規登録".equals(btn)){
			//request.setAttribute("address",address);
			//request.setAttribute("pwd",pwd);

			//HttpSession session = request.getSession();
			//session.setAttribute("address", address);
			//session.setAttribute("pwd",pwd);
			RequestDispatcher dispatcher = request.getRequestDispatcher("new.jsp");
			dispatcher.forward(request, response);

			//new.jspに移動------------------------------------
			//String name = request.getParameter("pwd");
			//User u = new User(address, pwd);
			//RegisterLogic rl = new RegisterLogic();
			//rl.execute(u);
			//request.setAttribute("User",u);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registerResult.jsp");
			//dispatcher.forward(request, response);
			//------------------------------------------------
		}

		if("ログイン".equals(btn)){
			//User u = new User(address, pwd);
			LoginLogic ll = new LoginLogic();

			boolean isLogin = ll.execute(u);

			//System.out.println(isLogin);

			if(isLogin){
				HttpSession session = request.getSession();
				session.setAttribute("address", address);

				//correct senntence
				//session.setAttribute("id", id);
				//session.setAttribute("id", id); //ex)session.setAttribute("name", name);
			}

			request.setAttribute("User",u);
			//request.setAttribute("Fixity", fix);
			request.setAttribute("UserMoney",um);
			//System.out.println(u.getName());
			//System.out.println(u.getAddress());
			//System.out.println(u.getPwd());
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginResult.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/MyPage.jsp");
			dispatcher.forward(request, response);
		}
	}

}
