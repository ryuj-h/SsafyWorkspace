<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>SSAFY</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}

a {
	margin: 10px;
}

.inputtitle {
	display: inline-block;
	width: 80px;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<h1>출결 관리</h1>
		<fieldset>
			<h1>로그인 해주세요.</h1>
			<form action="" method="">
				<label for="id" class="inputtitle">아이디</label>
				<input type="text">
				<br>
				<label for="pw" class="inputtitle">비밀번호</label>
				<input type="password">
				<br>
				<input type="submit" value="로그인">
			</form>
		</fieldset>
	<hr>
	<h4>
		<a href="">출결 이슈 등록</a>
	</h4>
	<h4>
		<a href="">출결 이슈 목록</a>
	</h4>

</body>
</html>