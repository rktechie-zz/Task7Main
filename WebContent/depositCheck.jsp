<jsp:include page="template-top-employee.jsp" />
	
    <br><br><br><br><br><br><br><br><br>
    
	<jsp:include page="error.jsp" />
	<form action="depositCheck.do" method="POST">
		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered">
						<tr>
							<td class="col-md-2 text-left">User Name:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="userName" placeholder="User Name">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Amount:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="depositAmount"
								placeholder="Amount in two decimal places">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" name="action" class="btn btn-success pull-left">Deposit
									Money</button></td>
						</tr>
				</table>
			</div>
		</div>
	</form>

<jsp:include page="template-bottom.jsp" />