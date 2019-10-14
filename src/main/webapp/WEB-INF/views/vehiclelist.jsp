<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Vehicle List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">List of Users </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Brand</th>
                        <th>Model</th>
                        <th>MakeYear</th>
                        <th>RegNumber</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <c:choose>
                	<c:when test="${empty vehicles}">
	                	<tr>
	                        <td colspan="5">No data.</td>
	                    </tr>
                    </c:when>
                	<c:otherwise>
                		<c:forEach items="${vehicles}" var="vehicle">
		                    <tr>
		                        <td>${vehicle.brand}</td>
		                        <td>${vehicle.model}</td>
		                        <td>${vehicle.makeYear}</td>
		                        <td>${vehicle.regNumber}</td>
		                        <td>
		                        	<a href="<c:url value='/edit-vehicle/${vehicle.vehicleId}' />" class="btn btn-success custom-width">edit</a>
		                        	&nbsp;&nbsp;&nbsp;
		                        	<a href="<c:url value='/delete-vehicle/${vehicle.vehicleId}' />" class="btn btn-danger custom-width">delete</a>
		                        </td>
		                    </tr>
		                </c:forEach>
                	</c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div class="well">
            <a href="<c:url value='/newvehicle' />">Add New Vehicle</a>
        </div>
    </div>
</body>
</html>