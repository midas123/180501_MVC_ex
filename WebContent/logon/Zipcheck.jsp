<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, logon.*" %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�����ȣ�˻�</title>
<link href="../MVC/style.css" rel="stylesheet" type="text/css">

<script language="javascript" src="script.js"></script>
<script>
function dongCheck(){
	if(document.zipForm.area3.value==""){
		alert("���̸��� �Է��ϼ���");
		document.zipForm.area3.focus();
		return;
	}
	document.zipForm.submit();
}

function sendAddress(zipcode, area1, area2, area3, area4){
	var address = area1+ " " +area2+ " " +area3+ " " +area4;
	opener.document.userinput.zipcode.value=zipcode;
	opener.document.userinput.address.value=address;
	self.close();
}
</script>
</head>
<body bgcolor="#FFFFCC">
<center>
<b>�����ȣ ã��</b>
<table>
<form name="zipForm" method="post" action="./zipCheckPro.do">
	<tr>
		<td><br>
		���̸� �Է�: <input name="area3" type="text">
		<input type="button" value="�˻�" onclick="dongCheck();">
		</td>
	</tr>
	<input type="hidden" name="check" value="n">
</form>
<c:choose>
<c:when test="${check eq 'n' && empty zipcodeList}">
	<tr>
		<td align="center"><br>�˻��� ����� �����ϴ�.
		</td>
	</tr>
</c:when>	
<c:when	test="${check eq 'n' && !empty zipcodeList}">
	<tr>
		<td align="center"><br>
		�ؾƷ� �����ȣ�� Ŭ���ϸ� �ڵ����� �Էµ˴ϴ�.</td>
	</tr>
<c:forEach var="zipbean" items="${zipcodeList}">
<c:set var="tempZipcode" value="${zipbean.zipcode}"/>
<c:set var="tempArea1" value="${zipbean.area1}"/>
<c:set var="tempArea2" value="${zipbean.area2}"/>
<c:set var="tempArea3" value="${zipbean.area3}"/>
<c:set var="tempArea4" value="${zipbean.area4}"/>


	<tr>
		<td><a href = "javascript:sendAddress('${tempZipcode}','${tempArea1}','${tempArea2}', '${tempArea3}','${tempArea4}')">${tempZipcode}&nbsp;${tempArea1}&nbsp;${tempArea2}&nbsp;${tempArea3}&nbsp;${tempArea4}</a><br>
		</td>
	</tr>
</c:forEach>	
</c:when>
</c:choose>
	<tr>
		<td align="center"><br><a href="javascript:this.close();">�ݱ�</a>
	</tr></td>
</table>
</center>
</body>
</html>