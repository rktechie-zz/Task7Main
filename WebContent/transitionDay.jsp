<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="template-top-employee.jsp" />
<h1>&nbsp</h1>

<div class="container">
	<jsp:include page="error.jsp" />

	<form role="form-horizontal" method="POST">
	    <h3>Transition Day : </h3><h4>(Last trading day was : ${ lastDay })</h4>
		<br>
		<h3>Select the trading day:</h3>


		<div class="row">
			<div class="col-lg-3">
				<table class="table table-bordered table-hover">
					<thead>
						<tr class="success">
							<th width="20%">Trading Day: (mm/dd/yyyy)</th>
							<th><input name="date" type="date" required
								class="form-control"></th>
							<th><button type="submit" name="action" value="create"
									class="btn btn-primary">Submit Transition Day</button></th>
						</tr>

					</thead>
				</table>
			</div>
		</div>

		<br>
		<div class="row">
			<div class="col-lg-6">
				<h3>Update the funds below:</h3>
				<br>
				<div class="table-responsive">
					<table class="table table-bordered table-hover table-striped">
						<thead>
							<tr>
								<th>Name of Fund</th>
								<th>Symbol</th>
								<th>Price per Share</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="fund" items="${fundList}">
								<tr>
									<td width="40%">${ fund.getName() }</td>
									<td width="30%">${ fund.getSymbol() }</td>
									<td align="right">
										<div class="form-group input-group">
											<span class="input-group-addon">$</span> <input
												name="fund_${fund.getFundId()}" type="text" required
												class="form-control"
												value="${price_map.get(fund.getFundId())}">
										</div>
									</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>

	</form>
</div>


<jsp:include page="template-bottom.jsp" />