<jsp:include page="template-top-customer.jsp" />
<h1>&nbsp</h1>
<h1>&nbsp</h1>
<form class="form-horizontal" role="form" action="sellFund.do" method="POST">
<!-- 		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered">
						<tr>
							<td class="col-md-2 text-left">Sell Fund :</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="name" placeholder="Put Fund Name here">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Sell Shares:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="shares" placeholder="Put Shares here">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" name="button" class="btn btn-success pull-left">Sell Fund</button></td>
						</tr>
				</table>
			</div>
		</div> -->
<jsp:include page="error.jsp" />
	<div class="form-group">
		<label class="control-label col-sm-2">Sell Fund :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="name"
				name="name" placeholder="Put Fund Name here" value="${form.name}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Sell Shares :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="shares"
				name="shares" placeholder="Put Shares here" value="${form.shares}">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
			<button type="submit" id="type" name="type" value="sell fund"
				class="btn btn-success pull-left">Sell Fund</button>
		</div>
	</div>
</form>
<jsp:include page="template-bottom.jsp" />