<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Vehicle</title>
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
	    <div class="well lead">Vehicle Details</div>
	    <form:form method="POST" modelAttribute="vehicle" class="form-horizontal">
	        <form:input type="hidden" path="hevicleId" id="hevicleId"/>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="brand">Brand</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="brand" id="brand" class="form-control input-sm"/>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="model">Model</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="model" id="model" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="regNumber">RegNumber</label>
	                <div class="col-md-7">
	                     <form:input type="text" path="regNumber" id="regNumber" class="form-control input-sm" />
	                     <div class="has-error">
	                         <form:errors path="regNumber" class="help-inline"/>
	                     </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="owner.firstName">Owner</label>
	                <div class="col-md-7">
	                     <form:input type="text" path="owner.firstName" id="owner.firstName" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	         <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="dob">MakeYear</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="dob" id="datepicker" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	        <div class="row" style="float: right;">
	            <div class="form-actions floatRight">
                	<input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/vehicles' />">Cancel</a>
	            </div>
	        </div>
	    </form:form>
	    </div>
	</body>
</html>