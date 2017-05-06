<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%> --%>

<%-- <sql:query var="rs" dataSource="jdbc/spring">
	select * from offers
</sql:query> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Offers List</title>
</head>
<body>
	<p>
		<%-- Hi there!<br> Session :
		<%=session.getAttribute("name")%><br> Session :
		<%=request.getAttribute("name")%><br> Session (using EL) :
		${name}<br> Session (using prefix c atau JSTL) : 
		<c:out value="${name}"></c:out>
		<br>
		<br>--%>
		<c:forEach var="row" items="${lstOffer}">
		    ID ${row.id}<br />
		    Name ${row.name}<br />
		    Email ${row.email}<br />
		    Text ${row.text}<br /><br>
		</c:forEach>
	</p>
	<p>
		<c:forEach var="offer" items="${lstOffer}">
		    <p>
		    	<c:out value="${offer}"></c:out>
		    </p>		
		</c:forEach>
	</p>
</body>
</html>