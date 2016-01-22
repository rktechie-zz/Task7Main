<jsp:include page="template-top-customer.jsp" />
<jsp:include page="error.jsp" />

    <br><br><br><br><br><br><br><br><br>
	
		<form action="sellFund.do" method="POST">
		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered">
						<tr>
							<td class="col-md-2 text-left">Sell Fund :</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="name" placeholder="Fund Name">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Sell Shares:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="shares" placeholder="Fund Symbol">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" name="button" class="btn btn-success pull-left">Sell Fund</button></td>
						</tr>
				</table>
			</div>
		</div>
	</form>

<jsp:include page="template-bottom.jsp" />