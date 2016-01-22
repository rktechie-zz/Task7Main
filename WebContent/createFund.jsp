<jsp:include page="template-top-employee.jsp" />
<jsp:include page="error.jsp" />
<h1>&nbsp</h1>
<h1>&nbsp</h1>
<!-- 	<form class="form-horizontal" role="form" action="createFund.do" method="POST">
		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered">
						<tr>
							<td class="col-md-2 text-left">Fund Name:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="name" placeholder="Fund Name">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Fund Symbol:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" name="symbol" placeholder="Fund Symbol">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" name="button" class="btn btn-success pull-left">Create Fund</button></td>
						</tr>
				</table>
			</div>
		</div>
	</form> -->
<jsp:include page="error.jsp" />
	<div class="form-group">
		<label class="control-label col-sm-2">Fund Name :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="name"
				name="name" placeholder="Put Fund Name here" value="${form.name}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Fund Symbol :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="symbol"
				name="symbol" placeholder="Put Symbol here" value="${form.symbol}">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
			<button type="submit" id="type" name="type" value="create account"
				class="btn btn-success pull-left">Create Fund</button>
		</div>
	</div>
</form>
<jsp:include page="template-bottom.jsp" />