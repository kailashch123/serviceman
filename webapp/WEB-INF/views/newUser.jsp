<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>User Registration</title>
	    <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	</head>
	<body>
	    <div class="generic-container">
	    <div class="well lead">User Registration</div>
	    <form:form method="POST" modelAttribute="user" class="form-horizontal">
	        <form:input type="hidden" path="userId" id="userId"/>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="firstName">First Name</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
	                    <div class="has-error">
	                        <form:errors path="firstName" class="help-inline"/>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="lastName">Last Name</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
	                    <div class="has-error">
	                        <form:errors path="lastName" class="help-inline"/>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="loginName">Login Name</label>
	                <div class="col-md-7">
	                     <form:input type="text" path="loginName" id="loginName" class="form-control input-sm" />
	                     <div class="has-error">
	                         <form:errors path="loginName" class="help-inline"/>
	                     </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="password">Password</label>
	                <div class="col-md-7">
	                    <form:input type="password" path="password" id="password" class="form-control input-sm" />
	                    <div class="has-error">
	                        <form:errors path="password" class="help-inline"/>
	                    </div>
	                </div>
	            </div>
	        </div>
	 		<div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="role">Roles</label>
	                <div class="col-md-7">
	                    <form:select path="role">
						   <form:option value="NONE" label="--Select--"/>
						   <form:option value="USER">User</form:option>
						   <form:option value="ADMIN">Admin</form:option>
						   <form:option value="DBA">Dba</form:option>
						</form:select>
	                    <div class="has-error">
	                        <form:errors path="role" class="help-inline"/>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="email">Email</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="email" id="email" class="form-control input-sm" />
	                    <div class="has-error">
	                        <form:errors path="email" class="help-inline"/>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="mobile">Mobile</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="mobile" id="mobile" class="form-control input-sm" />
	                    <div class="has-error">
	                        <form:errors path="mobile" class="help-inline"/>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-group col-md-12">
	                <label class="col-md-3 control-lable" for="address">Address</label>
	                <div class="col-md-7">
	                    <form:input type="text" path="address" id="address" class="form-control input-sm" />
	                </div>
	            </div>
	        </div>
	        <div class="row">
	            <div class="form-actions floatRight">
                    <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
	            </div>
	        </div>
	    </form:form>
	    </div>
	</body>
</html>