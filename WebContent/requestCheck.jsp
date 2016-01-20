<jsp:include page="template-top-customer.jsp" />

<div class="jumbotron text-center">
<h1>&nbsp</h1>
<h1>&nbsp</h1>
<jsp:include page="error.jsp" />
<form action="requestCheck.do" method="POST">
<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td class="col-md-2 text-left">Amount:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="requestAmount" placeholder="Amount in two decimal places">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" class="btn btn-success pull-left">Withdraw Money</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
</form>
</div>
<jsp:include page="template-bottom.jsp" />

