<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Order List</title>
    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
 
<body>
    <div class="generic-container">
        <div class="panel panel-default">
            <div class="panel-heading"><span class="lead">Order List</span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Receiver</th>
                        <th>CustName</th>
                        <th>CustMob</th>
                        <th>CustEmail</th>
                        <th>Date</th>
                        <th>Brand</th>
                        <th>Model</th>
                        <th>CustRec</th>
                        <th>ObsRec</th>
                        <th>ExpCost</th>
                        <th>DelDateTime</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:choose>
                	<c:when test="${empty orders}">
	                	<tr>
	                        <td colspan="12">No data.</td>
	                    </tr>
                    </c:when>
                	<c:otherwise>
                		<c:forEach items="${orders}" var="order">
		                    <tr>
		                        <td>${order.orderReceiver}</td>
		                        <td>${order.customerName}</td>
		                        <td>${order.customerMobile}</td>
		                        <td>${order.customerEmail}</td>
		                        <td>${order.serviceDate}</td>
		                        <td>${order.vehicleBrand}</td>
		                        <td>${order.vehicleModel}</td>
		                        <td>${order.customerRecomendation}</td>
		                        <td>${order.observerRecomendation}</td>
		                        <td>${order.expectedServiceCost}</td>
		                        <td>${order.deliveryDateTime}</td>
		                        <td>
		                        	<a href="<c:url value='/edit-order-${order.orderId}' />" class="btn btn-success custom-width">edit</a>
		                        	&nbsp;&nbsp;
		                        	<a href="<c:url value='/delete-order-${order.orderId}' />" class="btn btn-danger custom-width">delete</a>
		                        </td>
		                    </tr>
		                </c:forEach>
                	</c:otherwise>
                </c:choose>
                </tbody>
            </table>
        </div>
        <div class="well">
            <a href="<c:url value='/neworder' />">Add New Order</a>
        </div>
    </div>
</body>
</html>