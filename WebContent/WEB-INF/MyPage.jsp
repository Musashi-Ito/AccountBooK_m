<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList,
    		model.User,
    		model.GetStart,
    		model_fix.Fixity,
    		model_fix.GetFix,
    		model.UserMoney,
    		model_want.GetWantList,
    		model_want.Wantlist,
    		model_want.ShowWantList"
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link rel ="stylesheet" href="css/MyPage.css">
</head>
	<body>
<%
		User u = (User)request.getAttribute("User");
		System.out.println(u.getId());
		System.out.println(u.getAddress());
		System.out.println(u.getPwd());
		System.out.println(u.getName());

		GetStart gs = new GetStart();
		//Fixity fix = gs.execute(u.getId());
		UserMoney um = gs.execute(u.getId());

		GetFix gf = new GetFix();
		ArrayList<String> dat = gf.execute(u.getId());

		ShowWantList swl = new ShowWantList();
		ArrayList<String> dat2 = swl.execute(u.getId());

		if(u.getId() == -1){
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}

		/*
		if(fix == null){
			fix = (Fixity)request.getAttribute("Fixity");
		}
		*/

		if(um == null){
			um = (UserMoney)request.getAttribute("UserMoney");
		}

		session = request.getSession();
		session.setAttribute("User", u);
		//session.setAttribute("Fixity", fix);
		session.setAttribute("UserMoney", um);
		//request.setAttribute("User", u);
%>
		<div class="parent">
			<header>
				    <h1 class="logo"><%=u.getName()%>さんのユーザーページ</h1>
					<nav class="global-nav">
      				 	<ul>
      			 			<li class="nav-item active"><a href="/WEB-INF/MyPage.jsp">ホーム</a></li>
      			 			<li class="nav-item"><a href="Setting.jsp">設定ページ</a></li>
      		 				<li class="nav-item"><a href="PayMoney.jsp">買ったもの登録</a></li>
      		 				<li class="nav-item"><a href="WillPay.jsp">ほしいものリスト編集</a></li>
      		 			</ul>
      				</nav>
			</header>

<%
			int fixed_cost = 0;

			for(int i = 0; i < dat.size(); i++){
				if( i % 4 == 2) fixed_cost += Integer.parseInt(dat.get(i));
			}

			System.out.println(fixed_cost);

			/*
			ShowWantList swl = new ShowWantList();
			ArrayList<String> dat2 = swl.execute(u.getId());

			for(int i = 0; i < dat2.size(); i++){
				//if(i % 5 == 0)	//ID
				//if(i % 5 == 1)	//Category
				//if(i % 5 == 2)	//TradeName
				//if(i % 5 == 3)	//Amount
				//if(i % 5 == 4)	//Priority

				//System.out.println(dat2.get(i));
			}
			*/

			int sum = 0;

			for(int i = 0; i < dat2.size(); i++){
				//Amount
				if(i % 5 == 3)	sum += Integer.parseInt(dat2.get(i));
			}

			int balance = um.getBalance() - fixed_cost;
%>

			<div class="content">
				<p>所持金:￥<%= um.getBalance() %></p>
				<p>固定費:￥<%= fixed_cost %></p>
				<p>残金:￥<%= balance %></p>
				<p>目標金額:￥<%=um.getGoal() %></p>
				<p>ほしいものリストの合計金額:￥<%= sum %></p>
				<p>買った場合の予想残高:￥<%= balance - sum %></p>

				<h2 class = "logo">ほしいものリスト</h2>
				<form method="post" action="/AccountBook1/MyPage.jsp">
					<select name="Priority">
						<option selected disabled>優先順位</option>
						<option value="1">優先度1</option>
						<option value="2">優先度2</option>
						<option value="3">優先度3</option>
						<option value="4">優先度4</option>
						<option value="5">優先度5</option>
						<option value="all">all</option>
					</select>

					<select name="Category">
						<option selected disabled>カテゴリ選択</option>
						<option value="本・コミック・雑誌 ">本・コミック・雑誌 </option>
						<option value="DVD・ミュージック・ゲーム">DVD・ミュージック・ゲーム</option>
						<option value="家電・カメラ・AV機器">家電・カメラ・AV機器</option>
						<option value="パソコン・オフィス用品">パソコン・オフィス用品</option>
						<option value="ホーム＆キッチン・ペット・DIY">ホーム＆キッチン・ペット・DIY</option>
						<option value="食品・飲料・お酒">食品・飲料・お酒</option>
						<option value="服・シューズ・バッグ ・腕時計">服・シューズ・バッグ ・腕時計</option>
						<option value="ドラッグストア">ドラッグストア</option>
						<option value="ベビー・おもちゃ・ホビー">ベビー・おもちゃ・ホビー</option>
						<option value="車＆バイク・産業・研究開発">車＆バイク・産業・研究開発</option>
						<option value="その他">その他</option>
						<option value="all">all</option>
					</select>
					<%-- <input type="submit" value="決定"> --%>
					<button type='submit' name='btn' value='決定' class = "button" >決定</button>
				</form>

				<table align = "center">
					<tr>
						<th>カテゴリ</th>
						<th>商品名</th>
						<th>価格</th>
						<th>優先度</th>
					</tr>
<%
					for(int i = 0; i < dat2.size(); i+=5){
						String category = dat2.get(i+1);
						String tradename = dat2.get(i+2);
						int amount = Integer.parseInt(dat2.get(i+3));
						int priority = Integer.parseInt(dat2.get(i+4));
%>
						<tr>
							<td><%= category %></td>
							<td><%= tradename %></td>
							<td><%= amount %></td>
							<td><%= priority %></td>
						</tr>
<%
					}
%>
				</table>
			</div>
		</div>

		<footer class="logo">2017 © AccountBook</footer>
	</body>
</html>