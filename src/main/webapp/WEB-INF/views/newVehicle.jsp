<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Vehicle Registration</title>
	    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
     	<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        

		<link href="<c:url value='/static/css/jquery-ui.css' />" rel="stylesheet"></link>

		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

        <script>
            $(document).ready(function() {
            	$("#datepicker").datepicker();
            	$( "#userName" ).autocomplete({
            		source: '${pageContext. request. contextPath}/user/search'
            	});
        	});
            
        </script>
	</head>
	<body>
	    <div class="generic-container">
	    <div class="well lead">Vehicle Registration</div>
	    <form:form method="POST" modelAttribute="vehicle" class="form-horizontal">
	        <form:input type="hidden" path="vehicleId" id="vehicleId"/>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="brand">Brand</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="brand" id="brand" class="form-control input-sm"/>
	                    <div class="has-error">
	                        <form:errors path="brand" class="help-inline"/>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="model">Model</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="model" id="model" class="form-control input-sm" />
	                    <div class="has-error">
	                        <form:errors path="model" class="help-inline"/>
	                    </div>
	                </div>
	            </div>
	        </div>
	         <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="makeYear">MakeYear(MM/DD/YYYY)</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="makeYear" id="datepicker" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="ownerString">Owner(First name)</label>
	                <div class="col-md-7">
	                
	                     <form:input type="text" path="ownerString" id="userName" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	        <div class="row" style="float: right;">
	            <div class="form-actions floatRight">
                    <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/' />">Cancel</a>
	            </div>
	        </div>
	    </form:form>
	    </div>
	</body>
</html>