<jsp:include page="template-top-employee.jsp" />

    <br><br><br><br><br><br><br><br><br>
    <jsp:include page="error.jsp" />
	<form action="createFund.do" method="POST">
		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered">
						<tr>
							<td class="col-md-2 text-left">Fund Name:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="name" placeholder="Fund Name">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Fund Symbol:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="symbol" placeholder="Fund Symbol">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" name="button" class="btn btn-success pull-left">Create Fund</button></td>
						</tr>
				</table>
			</div>
		</div>
	</form>

<jsp:include page="template-bottom.jsp" />