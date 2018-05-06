<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

    
<html>
<head>
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<table>
<form method=post action="/180501_MVC_ex/MVC/commentWrite.do" name="comment" onsubmit="return writeSave()">
	<tr align="center">
	<td>답변 코멘트작성</td>
	</tr>
	<tralign="center">
		<td colspan=2><textarea name=commentt rows="5" cols="40"></textarea>
		</td>
		<td align=center>작성자<br>
		<input type=text name=commenter size=10><br>비밀번호<br>
		<input type=password name=passwd size=10><p>
		<input type=hidden name=num value='${param.ctn}'>
		<input type=hidden name=comment_num value='${param.cmn}'>
		<input type="hidden" name="com_re_set" value='${param.cset}'>
		<input type="hidden" name="com_re_step" value='${param.cstep}'>
		<input type="hidden" name="com_re_level" value='${param.clevel}'> 
		<input type="hidden" name="mnum" value='${param.cmn}'> 
		<input type=hidden name="pageNum" value="${param.p_num}">
		<input type=submit value="답변 코멘트달기">
		</td>
	</tr>
</form>
</table>
</body>
</html>