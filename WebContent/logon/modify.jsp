<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../MVC/color.jspf" %>

<html>
<head>
<title>ȸ������ ����</title>
<link href="../MVC/style.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="${bodyback_c}">
 <table width=500 cellpadding="0" cellspacing="0"  align="center" >
   <tr>
     <td>
      <form name="myform" action="./modifyForm.do" method="post">
        <INPUT type="hidden" name="id" value="${sessionScope.memId}">
	    <INPUT type="submit" value="ȸ������ ����">
      </form>
	 </td>
	 <td>
      <form name="myform" action="./deleteForm.do" method="post">
        <INPUT type="hidden" name="id" value="${sessionScope.memId}">
        <INPUT type="submit" value="ȸ�� Ż��">
      </form>
	 </td>
	 <td>
      <form name="myform" action="./main.do" method="post">
        <INPUT type="submit" value="��������">
      </form>
	 </td>
	</tr>
   </table>
</body>
</html>