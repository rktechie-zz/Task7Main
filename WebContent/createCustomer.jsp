<jsp:include page="template-top-customer.jsp" />

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
								class="form-control" id="firstName" placeholder="First Name">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Last Name:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="lastName" placeholder="Last Name">
						</tr>
						<tr>
							<td class="col-md-2 text-left">User Name:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="userName" placeholder="User Name">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Password:</td>
							<td class="col-md-4 text-left"><input type="password"
								class="form-control" id="password" placeholder="Password">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Confirm Password:</td>
							<td class="col-md-4 text-left"><input type="password"
								class="form-control" id="confirmPassword" placeholder="Confirm Password">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Address 1:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="address1" placeholder="Address 1">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Address 2:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="address2" placeholder="Address 2">
						</tr>
						<tr>
							<td class="col-md-2 text-left">City:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="city" placeholder="City">
						</tr>
						<tr>
							<td class="col-md-2 text-left">State:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="state" placeholder="State">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Zip:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="zip" placeholder="zip">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Cash:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="cash" placeholder="cash">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" value="create account" class="btn btn-success pull-left">Create Account</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>


<jsp:include page="template-bottom.jsp" />