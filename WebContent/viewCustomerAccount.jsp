<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="template-top-employee.jsp" />
<br>
<br>
<br>
<br>

<jsp:include page="error.jsp" />
<div class="row">
	<div class="container-fluid col-lg-12">
		<h2 class="page-header">${customerName}'sAccount</h2>
	</div>
</div>
<p>
<div class="col-lg-6">
	<h3>Customer information:</h3>
	<div class="table-responsive">
		<table class="table table-hover table-striped">
			<thead>
				<tr>
					<td>Account User Name:</td>
					<td colspan="2">${userName}</td>

				</tr>
				<tr>
					<td width="40%">Customer Name:</td>
					<td colspan="2">${customerName}</td>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Address:</td>
					<td colspan="2">${address1 },${address2 }</td>

				</tr>
				<tr>
					<td>City, State:</td>
					<td colspan="2">${city },${state}.</td>

				</tr>
				<tr>
					<td>Last trading date:</td>
					<td colspan="2">${lastDay}</td>

				</tr>
				<tr>
					<td>Last Posted Balance:</td>
					<td align="center"><b>$ ${cash}</b></td>
					<td width="30%">&nbsp;</td>
				</tr>
				<tr>
					<td>Available Cash:</td>
					<td align="center"><b>$ ${avai_cash}</b></td>
					<td>&nbsp;</td>
				</tr>
			</tbody>
		</table>
	</div>

	<h3>Funds owned:</h3>
	<div class="table-responsive">
		<table class="table table-hover table-striped">


			<c:choose>

				<c:when test="${(empty positionInfoList)}"> No Funds Owned!</c:when>
				<c:otherwise>
					<thead>
						<tr>
							<td width="40%"><b>Fund Name</b></td>
							<td align="right"><b>Shares</b></td>
							<td align="right"><b>Value</b></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${positionInfoList}">
							<tr>
								<td>${ u.getName() }</td>
								<td align="right">${ u.getShares() }</td>
								<td align="right">${u.getTotal()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</c:otherwise>
			</c:choose>

		</table>
	</div>
</div>


<jsp:include page="template-bottom.jsp" />