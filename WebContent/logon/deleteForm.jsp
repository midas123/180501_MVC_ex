<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../MVC/color.jspf"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ��Ż��</title>
<link href="style.css" rel="stylesheet" type="text/css">

   <script language="javascript">
     <!--
       function begin(){
         document.myform.passwd.focus();
       }

       function checkIt(){
		  if(!document.myform.passwd.value){
           alert("��й�ȣ�� �Է����� �����̽��ϴ�.");
           document.myform.passwd.focus();
           return false;
         }
	   }   
     -->
   </script>
</head>
<BODY onload="begin()" bgcolor="${bodyback_c}">
<form name="myform" action="./deletePro.do" method="post" onSubmit="return checkIt()">
<TABLE cellSpacing=1 cellPadding=1 width="260" border=1 align="center" >
  
  <TR height="30">
    <TD colspan="2" align="middle" bgcolor="${title_c}">
	  <font size="+1" ><b>ȸ�� Ż��</b></font></TD></TR>
     
  <TR height="30">
    <TD width="110" bgcolor="${value_c}" align=center>��й�ȣ</TD>
    <TD width="150" align=center>
      <INPUT type="password" name="passwd"  size="15" maxlength="12">
	  <input type="hidden" name="id" value="${sessionScope.memId}">
	  </TD></TR>
  <TR height="30">
    <TD colspan="2" align="middle" bgcolor="${value_c}" >
      <INPUT type=submit value="ȸ��Ż��"> 
      <input type="button" value="��  ��" onclick="document.location.href='./main.do'"></TD></TR>
</TABLE>
</form>
</BODY>
</HTML>