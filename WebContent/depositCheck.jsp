<jsp:include page="template-top-customer.jsp" />
<div class="jumbotron text-center">
<h1>&nbsp</h1>
<h1>&nbsp</h1>
<form action="depositCheck.do" method="POST">
<div class="form-group">
<label class="control-label col-sm-4" for="userName">User Name:</label>
<div class="col-sm-4">
<input type="text" class="form-control" id="userName" placeholder="User Name">
</div>
</div>
<div class="form-group">
<div class="col-sm-4">
<span class="input-group-addon">$</span>
<input type="text" class="form-control" id="depoistAmount" placeholder="Amount in two decimal places">
</div>
<div class="col-sm-4">
<button type="submit" class="btn btn-success">Deposit Money</button>
</div>
</div>
</form>
</div>
<jsp:include page="template-bottom.jsp" />