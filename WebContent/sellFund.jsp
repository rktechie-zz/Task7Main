<jsp:include page="template-top-customer.jsp" />
<h1>&nbsp</h1>
<h1>&nbsp</h1>
<form class="form-horizontal" role="form" action="sellFund.do" method="POST">
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