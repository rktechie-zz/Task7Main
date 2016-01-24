<jsp:include page="template-top-customer.jsp" />
<h1>&nbsp</h1>
<h1>&nbsp</h1>
<form class="form-horizontal" role="form" action="buyFund.do" method="POST">
	<jsp:include page="error.jsp" />
	<div class="form-group">
		<label class="control-label col-sm-2">Buy Fund :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="name"
				name="name" placeholder="Put Fund Name here" value="${form.name}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Buy Amount :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="amount"
				name="amount" placeholder="Put Amount here" value="${form.amount}">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
			<button type="submit" id="type" name="type" value="buy fund"
				class="btn btn-success pull-left">Buy Fund</button>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">

		</div>
	</div>
</form>	
<jsp:include page="template-bottom.jsp" />