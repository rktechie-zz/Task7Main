<jsp:include page="template-top-customer.jsp" />

    <br><br><br><br><br><br><br><br><br>
	<jsp:include page="error.jsp" />
	<form action="buyFund.do" method="POST">
		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered">
						<tr>
							<td class="col-md-2 text-left">Buy Fund :</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="name" placeholder="Put Fund Name here">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Buy Amount:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="amount" placeholder="Put Amount Here">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" name="button" class="btn btn-success pull-left">Buy Fund</button></td>
						</tr>
				</table>
			</div>
		</div>
	</form>

<jsp:include page="template-bottom.jsp" />