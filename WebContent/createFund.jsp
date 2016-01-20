<jsp:include page="template-top-customer.jsp" />
	
    <br><br><br><br><br><br><br><br>
    
	<form action="createFund.do" method="POST">
		<div class="row">
			<div class="col-md-6">
				<table class="table table-bordered">
						<tr>
							<td class="col-md-2 text-left">Fund Name:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="fundName" placeholder="Fund Name">
						</tr>
						<tr>
							<td class="col-md-2 text-left">Fund ID:</td>
							<td class="col-md-4 text-left"><input type="text"
								class="form-control" id="fundId" placeholder="Fund ID">
						</tr>
						<tr>
							<td></td>
							<td><button type="submit" class="btn btn-success pull-left">Create Fund</button></td>
						</tr>
				</table>
			</div>
		</div>
	</form>

<jsp:include page="template-bottom.jsp" />