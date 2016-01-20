<jsp:include page="template-top-customer.jsp" />
<jsp:include page="error.jsp" />
	<h1>&nbsp</h1>
	<h1>&nbsp</h1>
	<form action="changePassword.do" method="POST">
		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered">
						<tr>
							<td class="col-md-2 text-left">Current Password:</td>
							<td class="col-md-4 text-left"><input type="password"
								class="form-control" id="currentPassword" name="currentPassword" placeholder="Current Password">
						</tr>
						<tr>
							<td class="col-md-2 text-left">New Password:</td>
							<td class="col-md-4 text-left"><input type="password"
								class="form-control" id="newPassword" name="newPassword" placeholder="New Password">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Confirm Password:</td>
							<td class="col-md-4 text-left"><input type="password"
								class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" id="type" name="type" value="change password" class="btn btn-success pull-left">Change Password</button></td>
						</tr>
				</table>
			</div>
		</div>
	</form>

<jsp:include page="template-bottom.jsp" />