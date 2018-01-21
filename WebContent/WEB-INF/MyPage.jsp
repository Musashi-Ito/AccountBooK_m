<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.User, model_fix.Fixity, model.GetStart,model.UserMoney"%>
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
	<div class="content">
		<%--
			<p>残金:￥<%=fix.getBalance() %> 目標金額:￥<%=fix.getGoal() %></p>
		 --%>
		<p>残金:￥<%=um.getBalance() %> 目標金額:￥<%=um.getGoal() %></p>

		ほしいものリスト<br>
		<form method="post" action="/AccountBook1/MyPage.jsp">
			<select name="優先順位">
				<option selected disabled>優先順位</option>
				<option value="1">優先度1</option>
				<option value="2">優先度2</option>
				<option value="3">優先度3</option>
				<option value="4">優先度4</option>
				<option value="5">優先度5</option>
				<option value="all">all</option>
			</select>

			<select name="カテゴリ">
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

		list表示↓<br>
		??????????????????<br>
		//////////////////<br>
		??????????????????<br>
		//////////////////<br>

		合計費用 ￥__________<br>
		予想残高 ￥__________<br>
	</div>
	</div>
	<footer class="logo">2017 © AccountBook</footer>
</body>
</html>