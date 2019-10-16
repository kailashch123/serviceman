<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Assignment</title>
	    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
     	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
            });
        </script>
        <style type="text/css">
        	.datePickerWidth {
       		    height: 17px;
   				margin-left: 15px;
        	}
        </style>
	</head>
	<body>
		<div class="generic-container">
	    	<div class="well lead">Vehicle Assignment</div>
	    	<hr/>
   		 	<div style="width:100%; text-align: center;">
   		 		<label class="col-md-3 control-lable" for="orderReceiver">
   		 			<span style="font-weight: bold;margin-left: -15px;">Mechanic: </span>
   		 			${mechanic.firstName}&nbsp;${mechanic.lastName}&nbsp;(${mechanic.loginName})
   		 		</label>
   		 	</div>
	    	<div class="panel-heading" style="font-weight:bold;">Vehicle Available</div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Brand</th>
                        <th>Model</th>
                        <th>MakeYear</th>
                        <th>RegNumber</th>
                        <th>Status</th>
                        <th>Owner(UserID)</th>
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
		                        <td>${vehicle.status}</td>
		                        <td>${vehicle.user.loginName}</td>
		                        <td>
		                        	<a href="<c:url value='/select-vehicle-${mechanic.userId}-${vehicle.vehicleId}' />" class="btn btn-success custom-width">Select</a>
		                        </td>
		                    </tr>
		                </c:forEach>
                	</c:otherwise>
                </c:choose>
                </tbody>
            </table>
	    </div>
	</body>
</html>