<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="color.jspf" %>

<html>
<head>
<title>�Խ���</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script.js"></script>
</head>
<body bgcolor="${bodybock_c }">
<center><b>�ۼ���</b>
<br>
<form method="post" name="writeform" action="/MVC/updatePro.do?pageNum=${pageNum }" onsubmit="return writeSave()">
<table widht="400" border="1" cellspacing="0" cellpadding="0" align="center">
	<tr>
		<td widht="700" bgcolor="${value_c }" align="center">�̸�</td>
		<td align="left" widht="330">
			<input type="text" size="10" maxlength="10" name="writer" value="${article.writer }">
			<input type="hidden" name="num" value="${article.num }"></td>
	</tr>
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">����</td>
		<td align="left" widht="330">
			<input type="text" size="40" maxlength="50" name="subject" value= "${article.subject }"></td>
	</tr>				
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">Email</td>
		<td align="left" width="330">
		<input type="text" size="40" maxlength="30" name="email" value="${article.email }"></td>
	</tr>	
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">����</td>
		<td align="left" width="330">
		<textarea name="content" rows="13" cols="40"> ${article.content }</textarea></td>
	</tr>
	<tr>
		<td width="70" bgcolor="${value_c }" align="center">��й�ȣ</td>
		<td align="left" width="330">
		<input type="password" size="8" maxlength="12" name="passwd">
	</td>
	</tr>	
</table>
</body>
</html>