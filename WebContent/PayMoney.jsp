<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel ="stylesheet" href="css/standard_setting.css">
</head>
<body>
	<div class = "parent">
	<div>
	<h2 class="title">出費入力 </h2>
		<form method="post" action="/Accountbook/model/">
			<P>購入日時:<input type="text" name="day"/></p>
			<p>出費項目：
				<select name="itemname">
					<option selected disabled>項目を選択してください</option>
					<option value="食費">食費</option>
					<option value="水道光熱費">水道光熱費</option>
					<option value="通信費">通信費</option>
					<option value="交通費">交通費</option>
					<option value="医療費">医療費</option>
					<option value="生活雑貨・日用品">生活雑貨・日用品</option>
					<option value="保険">保険</option>
					<option value="住宅費">住宅費</option>
					<option value="税金">税金</option>
					<option value="その他">その他</option>
				</select>
			</p>

			<p>金額：<input type="text" name="paymoney"/></p>
			<p><button type='submit' name='btn' value='出費追加' class = "button" >追加</button></p>
		</form>
	</div>
	<h2 class="title">収入入力</h2>
		<form method="post" action="/Accountbook/model/">
			<p>給料日:
			<p>収入項目：
				<select name="itemname">
					<option selected disabled>項目を選択してください</option>
					<option value="ボーナス">ボーナス</option>
					<option value="おこずかい">おこずかい</option>
					<option value="仕送り">仕送り</option>
					<option value="その他">その他</option>
				</select>
			</p>
			<p>金額：<input type="text" name="getmoney"/></p>
			<p><button type='submit' name='btn' value='収入追加' class = "button" >追加</button></p>
		</form>
	</div>
	<footer class="title">2017 © AccountBook</footer>
</body>
</html>