<jsp:include page="template-top-customer.jsp" />
<jsp:include page="error.jsp" />
<h1>&nbsp</h1>
<h1>&nbsp</h1>
<form class="form-horizontal" role="form" action="requestCheck.do" method="POST">
<div class="form-group">
		<label class="control-label col-sm-2" for="requestAmount">Amount:</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="requestAmount"
				name="requestAmount" placeholder="Dollar in two decimal places" value="${form.requestAmount}">
		</div>
	</div>
<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
			<button type="submit" id="action" name="action" value="Withdraw Money"
				class="btn btn-success pull-left">Withdraw Money</button>
		</div>
	</div>
</form>
<jsp:include page="template-bottom.jsp" />

