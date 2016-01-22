<jsp:include page="template-top-employee.jsp" />
<br><br><br><br><br>
<jsp:include page="error.jsp" />
	<h1>&nbsp</h1>
	<h1>&nbsp</h1>
	<form action="createCustomer.do" method="POST">
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
							<td class="col-md-2 text-left">Address 1:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="address1" name="address1" placeholder="Address 1" value="${form.address1}">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Address 2:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="address2" name="address2" placeholder="Address 2" value="${form.address2}">
						</tr>
						<tr>
							<td class="col-md-2 text-left">City:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="city" name="city" placeholder="City" value="${form.city}">
						</tr>
						<tr>
							<td class="col-md-2 text-left">State:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="state" name="state" placeholder="State" value="${form.state}">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Zip:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="zip" name="zip" placeholder="zip" value="${form.zip}">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Cash:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="cash" name="cash" placeholder="cash" value="${form.cash}">
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