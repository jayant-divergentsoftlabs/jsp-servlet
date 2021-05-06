<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Patient</title>

<script src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<form class="form-horizontal" action="patientController"
							method="POST">
							<fieldset>

								<!-- Form Name -->
								<legend>Patient Add</legend>


								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="name">Name</label>
									<div class="col-md-4">
										<input id="name" name="name" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="age">Age</label>
									<div class="col-md-4">
										<input id="age" name="age" type="number" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="weight">Weight</label>
									<div class="col-md-4">
										<input id="weight" name="weight" type="number" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="gender">Gender</label>
									<div class="col-md-4">
										<input id="gender" name="gender" type="text" placeholder=""
											class="form-control input-md">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="contactno">Contact
										No</label>
									<div class="col-md-4">
										<input id="contactno" name="contactno" type="number"
											placeholder="" class="form-control input-md">

									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label" for="address">Address</label>
									<div class="col-md-4">
										<input id="address" name="address" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<!-- Button -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="add"></label>
									<div class="col-md-4">
										<input type="submit" class="btn btn-info" value="Add patient">
									</div>
								</div>

							</fieldset>
						</form>
					</div>
					<div class="col-md-6"></div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<legend>patient List</legend>
						<div class="table-responsive">
							<table id="example" class="table table-striped table-bordered">
								<thead>
									<tr>
										<th>Id</th>
										<th>Name</th>
										<th>Age</th>
										<th>Weight</th>
										<th>Gender</th>
										<th>Contact No</th>
										<th>Address</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${allPatient}" var="patient">
										<tr>
											<td><c:out value="${patient.id}" /></td>
											<td><c:out value="${patient.name}" /></td>
											<td><c:out value="${patient.age}" /></td>
											<td><c:out value="${patient.weight}" /></td>
											<td><c:out value="${patient.gender}" /></td>
											<td><c:out value="${patient.contactNo}" /></td>
											<td><c:out value="${patient.address}" /></td>
											<td><a href="patientController?id=${patient.id}"
												class="btn btn-danger" type="button">Delete</a></td>
											<td><a href="patientController?id=${patient.id}"
												class="btn btn-danger" type="button">Search</a></td>

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