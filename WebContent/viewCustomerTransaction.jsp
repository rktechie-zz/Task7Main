<jsp:include page="template-top-employee.jsp" />

<br><br><br>

<div class="jumbotron text-center">
	<h1>&nbsp</h1>
	<form action="viewCustomerTransaction.do" method="POST">
		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td class="col-md-2 text-right">Customer First Name:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="customerFirstName" placeholder="Enter customer first name">
						</tr>
                        <tr>
                            <td class="col-md-2 text-right">Customer Last Name:</td>
                            <td class="col-md-4 text-left"><input type="text"
                                class="form-control" id="customerLastName" placeholder="Enter customer last name">
                        </tr>
						<tr>
							<td class="col-md-2 text-right">Customer ID:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="customerId" placeholder="Enter customer ID">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" class="btn btn-success pull-left">View Transaction</button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
</div>

<jsp:include page="template-bottom.jsp" />