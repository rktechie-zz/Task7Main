<jsp:include page="template-top-customer.jsp" />
<div class="jumbotron text-center">
	<h1>&nbsp</h1>
	<h1>&nbsp</h1>
	<form action="depositCheck.do" method="POST">
	<div class="row">
	<div class = "col-md-8">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td class="col-md-4 text-left">User Name:</td>
					<td class="col-md-4 text-left"><input type="text" class="form-control" id="userName"
						placeholder="User Name">
				</tr>
				<tr>
					<td class="col-md-4 text-left">Amount:</td>
					<td class="col-md-4 text-left"><input type="text" class="form-control" id="depoistAmount"
						placeholder="Amount in two decimal places">
				</tr>
				<tr>
				<td></td>
					<td><button type="submit" class="btn btn-success pull-left">Deposit Money</button></td>
				</tr>
			</tbody>
		</table>
		</div>
		</div>
	</form>
</div>

<jsp:include page="template-bottom.jsp" />