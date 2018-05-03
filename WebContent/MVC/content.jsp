<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="color.jspf" %>


<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
<style type="text/css">
<!--
a:link { color:black; text-decoration:none; }
a:visited {  }
a:active { text-decoration:underline; }
a:hover { text-decoration:underline; background-image:url('text_dottdeline.gif'); background-repeat:repeat-x; background-position:50% 100%; }
-->
</style>
<style>
<!--
@font-face {font-family:굴림; src:url();}
body,td,a,div,p,pre,input,textarea {font-family:굴림;font-size:9pt;}
-->
</style>
</head>
<body bgcolor="${bodybock_c }">
<center><b>글내용 보기</b>
<br>
<form>
<table width="500" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr height="30">
		<td align="center" width="125" bgcolor="${value_c }">글번호</td>
		<td align="center" width="125" align="center">${article.num }</td>
		<td align="center" width="125" bgcolor="${value_c }">조회수</td>
		<td align="center" width="125" align="center">${article.readcount }</td>
	</tr>
	<tr height="30">
		<td align="center" width="125" bgcolor="${value_c }">작성자</td>
		<td align="center" width="125" align="center">${article.writer }</td>
		<td align="center" width="125" bgcolor="${value_c }">작성일</td>
		<td align="center" width="125" align="center">${article.reg_date }</td>
	</tr>
	<tr height="30">
		<td align="center" width="125" bgcolor="${value_c }">글제목</td>
		<td align="center" width="375" align="center" colspan="3">${article.subject }</td>
	</tr>
	<tr>
		<td align="center" width="125" bgcolor="${value_c }">글내용</td>
		<td align="left" width="375" align="center" colspan="3">${article.subject }</td>
	</tr>
	<tr height="30">
		<td colspan="4" bgcolor="${value_c }" align="right">
		<input type="button" value="글수정" onclick="document.location.href='/180501_MVC_ex/MVC/updateForm.do?num=${article.num}&pageNum=${pageNum}'">&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="글삭제" onclick="document.location.href='/180501_MVC_ex/MVC/deleteForm.do?num=${article.num}&pageNum=${pageNum }'">&nbsp;&nbsp;&nbsp;&nbsp;	
		<input type="button" value="답글쓰기" onclick="document.location.href='/180501_MVC_ex/MVC/writeForm.do?num=${article.num}&ref=${article.ref }&re_step=${article.re_step }$re_level=${article.re_level }'">&nbsp;&nbsp;&nbsp;&nbsp;	
		<input type="button" value="글삭제" onclick="document.location.href='/180501_MVC_ex/MVC/list.do?pageNum=${pageNum }'">&nbsp;&nbsp;&nbsp;&nbsp;	
	</td>
	</tr>
	<form method=post action=contentPro.jsp name="comment" onsubmit="return writeSave()">
	<tr align="center">
		<td>코멘트 작성</td>
		<td colspan=2><textarea name=commentt rows="6" cols="40"></textarea>
		<input type=hidden name=content_num value="">
		<input type=hidden name=p_num value="">
		<%-- <input type=hidden name=comment_num value=<%=mainArticle %>> --%>
		<input type="hidden" name="com_re_set" value=""/>
		<input type="hidden" name="com_re_level" value=""/>
		<input type="hidden" name="com_re_step" value=""/>
		<input type="hidden" name="mnum" value=""/>
	</td>
	</tr>
	<tr>
	<c:if test="{count>0}"/>
	
	
	</c:if>
	</tr>
		
	
		
</table>
</form>
</body>
</html>