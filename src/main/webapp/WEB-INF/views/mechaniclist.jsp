<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Order Assignment</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">Mechanics</span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>Mobile</th>
                        <th>Email</th>
                        <th>AssigPending</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:choose>
                	<c:when test="${empty mechanics}">
	                	<tr>
	                        <td colspan="5">No data.</td>
	                    </tr>
                    </c:when>
                	<c:otherwise>
                		<c:forEach items="${mechanics}" var="mechanic">
		                    <tr>
		                        <td>${mechanic.firstName}</td>
		                        <td>${mechanic.lastName}</td>
		                        <td>${mechanic.mobile}</td>
		                        <td>${mechanic.email}</td>
		                        <td>${mechanic.email}</td>
		                        <td><a href="<c:url value='/mechanic-${mechanic.userId}' />" class="btn btn-success custom-width">Select</a></td>
		                    </tr>
		                </c:forEach>
                	</c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div class="well">
            <a href="<c:url value='/' />"><< Back</a>
        </div>
    </div>
</body>
</html>