<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="template-top-customer.jsp" />
<br>
<br>
<br>
<br>
<jsp:include page="error.jsp" />
<div class="container-fluid">
	<div class="row">
		<div class="col-lg-12">
			<h2 class="page-header">Welcome ${user.getFirstName()}</h2>
		</div>
	</div>

	<div class="row col-lg-6">
		<h3>Customer information:</h3>
		<div class="table-responsive">
			<table class="table table-hover table-striped">
				<thead>
					<tr>
						<td>Account User Name:</td>
						<td colspan="2">${user.getUserName()}</td>

					</tr>
					<tr>
						<td width="40%">Customer Name:</td>
						<td colspan="2">${user.getFirstName()}</td>

					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Address:</td>
						<td colspan="2">${user.getAddress1() }${user.getAddress2() }</td>

					</tr>
					<tr>
						<td>City, State:</td>
						<td colspan="2">${user.getCity() },${user.getState()}.</td>

					</tr>
					<tr>
						<td>Last trading date:</td>
						<td colspan="2">${lastDay}</td>

					</tr>
					<tr>
						<td>Last Posted Balance:</td>
						<td align="right"><b>$ ${user.getCash()/100}</b></td>
						<td width="30%">&nbsp;</td>
					</tr>
				</tbody>
			</table>
		</div>

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

					<c:choose>

						<c:when test="${(empty positionInfoList)}"></c:when>
						<c:otherwise>
							<c:forEach var="u" items="${positionInfoList}">
								<tr>
									<td>${ u.getName() }</td>
									<td align="right">${ u.getShares() }</td>
									<td align="right">${u.getTotal()}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>

<jsp:include page="template-bottom.jsp" />