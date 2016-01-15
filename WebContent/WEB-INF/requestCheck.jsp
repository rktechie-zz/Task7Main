<jsp:include page="template-top-customer.jsp" />
<div class="jumbotron text-center">
<h1>&nbsp</h1>
<h1>&nbsp</h1>
<form action="requestCheck.do" method="POST">
<div class="form-group">
<div class="col-sm-4">
<span class="input-group-addon">$</span>
<input type="text" class="form-control" id="checkAmount" placeholder="Amount in dollars">
<sapn class="input-group-addon">.00</sapn>
</div>
<div class="col-sm-4">
<button type="submit" class="btn btn-success">Witdraw Money</button>
</div>
</div>
</form>
</div>
<jsp:include page="template-bottom.jsp" />

