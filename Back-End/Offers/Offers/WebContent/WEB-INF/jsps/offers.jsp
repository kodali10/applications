<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Offers</title>
</head>
<body>
<table cellpadding="3" border="1" style="background-color: #ffffcc;">
<tr>
        <th>Name</th>
        <th>email</th>
        <th>text</th>
    </tr>
	<c:forEach var="offer" items="${offers}">
		
			<tr>
				<td>${offer.name}</td>
				<td>${offer.email}</td>
				<td>${offer.text}</td>
			</tr>
		
	</c:forEach>
</table>
</body>
</html>