<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>
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
                        <th>FirstName</th>
                        <th>LastName</th>
                        <th>LoginName</th>
                        <th>Role</th>
                        <th>Email</th>
                        <th>Mobile</th>
                        <th>DoB</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.loginName}</td>
                        <td>${user.role}</td>
                        <td>${user.email}</td>
                        <td>${user.mobile}</td>
                        <td>${user.dob}</td>
                        <td>
                        	<a href="<c:url value='/editUser-${user.userId}' />" class="btn btn-success custom-width">edit</a>
                        	&nbsp;&nbsp;&nbsp;&nbsp;
                        	<a href="<c:url value='/deleteUser-${user.userId}' />" class="btn btn-danger custom-width">delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="well">
            <a href="<c:url value='/newuser' />">Add New User</a>
        </div>
    </div>
</body>
</html>