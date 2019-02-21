<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>회원가입</h1>
<h3><a href="list">전체회원보기</a></h3>

<form action="writeForm" method="post" name="form">

<table border="1" width="700" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center">제목</td>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td align="center">작성자</td>
		<td><input type="text" name="writer"></td>
	</tr>
	<tr>
		<td align="center">내 용</td>
		<td><textarea rows="4" cols="80" name="content"></textarea></td>
	</tr>
	<tr>
		<td align="center">비밀번호</td>
		<td><input type="password" name="password"></td>
	</tr>
</table>

<input type="submit" value="확인"><br>
</form>
</div>

</body>
</html>