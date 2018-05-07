<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${check==1}">
	<c:set var="memId" value="${id }" scope="session"/>
	<meta http-equiv="Refresh" content="0;url=<%=request.getContextPath()%>/logon/main.do"/>
</c:if>

<c:if test="${check ==0 }">
	<script>
		alert("비밀번호가 틀립니다.")
		history.go(-1);
	</script>
</c:if>

<c:if test="${check==-1 }">
	<script>
		alert("아이디가 틀립니다.");
		history.go(-1);
	</script>
</c:if>
