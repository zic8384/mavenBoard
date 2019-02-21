<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<h1>게시글보기</h1>
<h3><a href="writeForm">글쓰기</a></h3>
<table border="1" width="700" cellpadding="0" cellspacing="0">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>	    
	</tr>
<c:forEach items="${userlist}" var="user">
<tr>
	<td align="center">${user.seq }</td>
	<td align="center"><a href="detail?seq=${user.seq }">${user.title }</a></td>
	<td align="center">${user.content }</td>
	<td align="center">${user.writer }</td>
	<td align="center">${user.regdate }</td>
	<td align="center">${user.hitcount }</td>	
</tr>
</c:forEach>
</table>
<form action="search">
<table>
<tr>
	<td>
	<select name="field">
	<option value="writer">작성자</option>
	<option value="content">내용</option>
	</select>
	<input type="text" name="word">
	<input type="submit" value="확인">
	</td>
</tr>
</table>
</form>
</div>
 
<div align="center">
${pageHtml}
</div>

</body>
</html>
