<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
function update() {
   if(frm.passwd.value==""){
      alert("비밀번호를 입력하세요")
      frm.passwd.focus();
      return;
   }
   if(frm.passwd.value!="${user.password}") {
      alert("비밀번호가 다릅니다.")
      frm.passwd.focus();
      return;
   }
   frm.mathod="post"
   frm.action="update"
   frm.submit();
}

function del() {
   if(frm.passwd.value==""){
      alert("비밀번호를 입력하세요")
      frm.passwd.focus();
      return;
   }
   
   if(frm.passwd.value!="${user.password}") {
      alert("비밀번호가 다릅니다.")
      frm.passwd.focus();
      return;
   }
   frm.mathod="post"
   frm.action="delete?seq=${user.seq}"
   frm.submit();
}


</script>

</head>
<body>
<div align="center">
<form name="frm" action="update" method="post">
<h1>상세보기</h1>
<table border="1" width="700" cellpadding="0" cellspacing="0">
   <tr>
      <input type="hidden" value="${user.seq}" name="seq">
      <td colspan="2">번호 : ${user.seq}</td>
      </tr>
      <tr>
      <td>제목: </td><td><input type="text" value="${user.title}" name="title"></td>
      </tr>
      <tr>
      <td>내용: </td><td><textarea name="content" rows="10" cols="90">${user.content }</textarea></td>
      </tr>
      <tr>
      <td>작성자: </td><td><input type="text" value="${user.writer}" name="writer"></td>
      </tr>
      <tr>
      <td>작성일: </td><td>${user.regdate }</td>
      </tr>
      <tr>
      <td>password </td><td><input type="text" name="passwd"></td>
      </tr>
      <tr>
      <th colspan="2">조회수 : ${user.hitcount}</th>
      </tr>   
</table> 
<input type="button" value="수정하기" onclick="update()"> 
<input type="button" value="삭제하기" onclick="del()"> 
<input type="button" value="리스트" onclick="location.href='list'">
</form>
</div>
<br>
<!-- 코멘트삽입  -->
  <div align="center">  
  <form name="frm2" action="cinsert" method="post">
  	<textarea rows="5" cols="100" id="msg"></textarea><br>
  	<input type="submit" value="댓글쓰기" >
  	<br><br>
</form> 	
 <table border="1" width="700" cellpadding="0" cellspacing="0">
<c:forEach items="${clist}" var="clist">
   <tr>
      <input type="hidden" value="${clist.cnum}" name="cnum">
      <td>번호 : ${clist.cnum}</td>
      </tr>      
      <tr>
      <td>내용 : ${clist.msg }</td>
      </tr>
      <tr>
      <td>작성일 : ${clist.rdate}</td>
      </tr>  
</c:forEach>     
</table>   
  </div>  
  
</body>
</html>

