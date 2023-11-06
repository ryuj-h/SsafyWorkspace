<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	#result{
		display: none;
	}
</style>
<title>SSAFY</title>
</head>

<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<form id="registForm">
		<label for="ano" class="inputtitle">이슈 번호</label>
		<input type="text" name="" id="ano">
		<br>
		<label for="usernumber" class="inputtitle">학번</label>
		<input type="text" name="" id="usernumber">
		<br>
		<label for="name" class="inputtitle">교육생명</label>
		<input type="text" name="" id="name">
		<br>
		<label for="rclass" class="inputtitle">반</label>
		<input type="number" name="" id="rclass">
		<br>
		<label for="rname" class="inputtitle">지역</label>
		
		<input type="text" name="" id="rname">
		<br>
		<label for="issuedate" class="inputtitle">날짜</label>
		<input type="date" name="" id="issuedate">
		<br>
		<label for="issue" class="inputtitle">사유</label>
		<input type="text" name="" id="issue" >
		<br>
		<button type="submit">출결 이슈 등록</button>
		<button type="reset">초기화</button>
	</form>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</html>