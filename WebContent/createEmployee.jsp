<jsp:include page="template-top-employee.jsp" />
<jsp:include page="error.jsp" />
	<h1>&nbsp</h1>
	<h1>&nbsp</h1>
	<form action="createEmployee.do" method="POST">
		<div class="row">
			<div class="col-md-6">
				<table class="table">
					<tbody>
						<tr>
							<td class="col-md-2 text-left">First Name:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="firstName" name="firstName" placeholder="First Name" value="${form.firstName}">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Last Name:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="lastName" name="lastName" placeholder="Last Name" value="${form.lastName}">
						</tr>
						<tr>
							<td class="col-md-2 text-left">User Name:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="userName" name="userName" placeholder="User Name" value="${form.userName}">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Password:</td>
							<td class="col-md-4 text-left"><input type="password"
								class="form-control" id="password" name="password" placeholder="Password" value="${form.password}">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Confirm Password:</td>
							<td class="col-md-4 text-left"><input type="password"
								class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password" value="${form.confirmPassword}">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" id="type" name="type" value="create account" class="btn btn-success pull-left">Create Account</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>


<jsp:include page="template-bottom.jsp" />