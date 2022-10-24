<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>publish Job</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color:#DDDDDD;">
<c:if test="${userobj.role ne 'admin'}">
  <c:redirect url="login.jsp"></c:redirect>
</c:if>
	<%@include file="all_component/navbar.jsp"%>
	
	<div class="container p-2">
		<div classs="col-md-10 offset-md-1">
			<div class="card">
				<div class="card-body">
					<div class="text-center text-sucess">
						<i class="fas fa-user-friends fa-3a"></i>
						<c:if test="${not empty succMsg}" >
							<div class="alert alert-success" role="alert">${succMsg }</div>
							<c:remove var="succMsg" />
						</c:if>
						
						<h4>Add Jobs</h4>
					</div>
					<form action="addjob" method="post">
						<div class="form-group">
						<lable>Enter Title</lable><input type="text" name="title" required class="form-control">
						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<lable>Location</lable><select name="location" class="custom-select" id="inlineFormCustomSelectPref">
									<option selected>Choose...</option>
									<option value="Maharashtra">Maharashtra</option>
									<option value="Delhi">Delhi</option>
									<option value="Gujurat">Gujurat</option>
									<option value="Hydrabad">Hydrabad</option>
									<option value="Banglore">Banglore</option>
								</select>
							</div>
							<div class="form-group col-md-4">
								<lable>Category</lable><select class="custom-select" id="inlineFormCustomSelectPref" name="category">
								<option selected>choose...</option>
								<option value="IT">IT</option>
								<option value="Banking">Banking</option>
								<option value="Engineer">Engineer</option>
								<option value="Teacher">Teacher</option>
								<option value="DevOps">DevOps</option>
								</select>
							</div>
							<div class="form-group col-md-4">
								<lable>Status</lable> <select class="form-control" name="status">
									<option class="Active" value="Active">Active</option>
									<option class="Inactive" value="Inactive">Inactive</option>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<lable>Enter Description</lable>
							<textarea required rows="6" cols="" name="desc" class="form-control"></textarea>
						</div>
						<button class="btn btn-sucess">Publish Job</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>