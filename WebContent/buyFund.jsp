<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="template-top-customer.jsp" />
<h1>&nbsp</h1>
<h1>&nbsp</h1>
<form class="form-horizontal" role="form" action="buyFund.do"
	method="POST">
	<jsp:include page="error.jsp" />
	<div class="form-group">
		<label class="control-label col-sm-2">Buy Fund :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="name" name="name"
				placeholder="Put Fund Name here" value="${form.name}">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-sm-2">Buy Amount :</label>
		<div class="col-sm-4">
			<input type="text" class="form-control" id="amount" name="amount"
				placeholder="Put Amount here" value="${form.amount}">
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
			<button type="submit" id="type" name="type" value="buy fund"
				class="btn btn-success pull-left">Buy Fund</button>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4"></div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<h3>Funds able to buy:</h3>
			<div class="table-responsive">
				<table class="table table-hover table-striped">
					<thead>
						<tr>
							<td width="40%"><b>Fund Name</b></td>
							<td align="right"><b>Price</b></td>
						</tr>
					</thead>
					<tbody>
						<c:if test="${!(empty fundListInfoList)}">
							<c:forEach var="u" items="${fundListInfoList}">
								<tr>
									<td>${ u.getName() }</td>
									<td align="right">${ u.getPrice() }</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</form>
<jsp:include page="template-bottom.jsp" />