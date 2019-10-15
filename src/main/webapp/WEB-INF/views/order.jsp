<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Order</title>
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
	</head>
	<body>
	    <div class="generic-container">
	    <div class="well lead">Order</div>
	    <form:form method="POST" modelAttribute="order" class="form-horizontal" autocomplete="off">
	        <form:input type="hidden" path="orderId" id="orderId"/>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="orderReceiver">Order Receiver</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="orderReceiver" id="orderReceiver" class="form-control input-sm"/>
	                    <div class="has-error">
	                        <form:errors path="orderReceiver" class="help-inline"/>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="customerName">Customer Name</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="customerName" id="customerName" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="customerMobile">Customer Mobile</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="customerMobile" id="customerMobile" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="customerEmail">Customer Email</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="customerEmail" id="customerEmail" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	         <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="vehicleBrand">Vehicle Brand</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="vehicleBrand" id="vehicleBrand" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="vehicleModel">Vehicle Model</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="vehicleModel" id="vehicleModel" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="customerRecomendation">Cutomer Recomendation</label>
	                <div class="col-md-7">
	                    <form:textarea path="customerRecomendation" id="customerRecomendation" class="form-control input-sm" rows = "3" cols = "30" />
	                </div>
	            </div>
	        </div>
	         <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="observerRecomendation">Observer Recomendation</label>
	                <div class="col-md-7">
	                    <form:textarea path="observerRecomendation" id="observerRecomendation" class="form-control input-sm" rows = "3" cols = "30" />
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="expectedServiceCost">Expected Service Cost</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="expectedServiceCost" id="expectedServiceCost" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	        
	         <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="deliveryDateTime">Delivery Date Time</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="deliveryDateTime" id="datepicker" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	       <div class="row">
	            <div class="form-group col-md-12">
	            	<c:choose>
                         <c:when test="${edit}">
                            	<label class="col-md-3 control-lable" for="status">Status</label>
		                		<div class="col-md-7">
				                    <form:input type="text" path="status" id="status" class="form-control input-sm" />
				                </div>
                         </c:when>
                         <c:otherwise>
                         </c:otherwise>
                     </c:choose>
	            </div>
	        </div>
	        
	        <div class="row" style="float: right;">
	            <div class="form-actions floatRight">
                    <input type="submit" value="Submit" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/orderlist' />">Cancel</a>
	            </div>
	        </div>
	    </form:form>
	    </div>
	</body>
</html>