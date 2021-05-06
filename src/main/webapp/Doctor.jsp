<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Doctor</title>

<script src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<form class="form-horizontal" action="doctorController"
							method="POST">
							<fieldset>

								<!-- Form Name -->
								<legend>Doctor Add</legend>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="name">Name</label>
									<div class="col-md-4">
										<input id="name" name="name" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="speciality">Speciality</label>
									<div class="col-md-4">
										<input id="speciality" name="speciality" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="fee">Fee</label>
									<div class="col-md-4">
										<input id="fee" name="fee" type="number" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<!-- Button -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="add"></label>
									<div class="col-md-4">
										<input type="submit" class="btn btn-info"
											value="Add Doctor">
									</div>
								</div>

							</fieldset>
						</form>
					</div>
					<div class="col-md-6"></div>
				</div>

				<div class="row">
					<div class="col-md-6">
					<legend>Doctor List</legend>
						<div class="table-responsive">
							<table id="example" class="table table-striped table-bordered">							
							<thead>
								<tr>
									<th>Name</th>
									<th>Speciality</th>
									<th>Fee</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${allDoctors}" var="Doctor">
									<tr>
										<td><c:out value="${Doctor.name}" /></td>
										<td><c:out value="${Doctor.speciality}" /></td>
										<td><c:out value="${Doctor.fee}" /></td>
										<td><a href="doctorController?doctorId=${Doctor.id}"
											class="btn btn-danger" type="button">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
					</div>
					<div class="col-md-6"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
