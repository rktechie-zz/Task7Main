<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<div class="container-fluid">
	<div class="row">
		<h3>Funds owned:</h3>
		<div class="table-responsive">
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<td width="40%"><b>Fund Name</b></td>
						<td align="right"><b>Shares</b></td>
						<td align="right"><b>Value</b></td>
					</tr>
				</thead>
				<tbody>
					

						<c:if test="${!(empty positionInfoList)}">

							<c:forEach var="u" items="${positionInfoList}">
								<tr>
									<td>${ u.getName() }</td>
									<td align="right">${ u.getShares() }</td>
									<td align="right">${u.getTotal()}</td>
								</tr>
							</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		</div>
		</div>

<jsp:include page="template-bottom.jsp" />