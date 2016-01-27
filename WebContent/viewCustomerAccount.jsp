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
<div class="row">
<div class="container-fluid">
<div class="col-lg-6">
	<h3>Customer information:</h3>
	<div class="table-responsive">
		<table class="table table-hover table-striped">
			<tbody>
				<tr>
					<td>Account User Name:</td>
					<td colspan="2">${userName}</td>

				</tr>
				<tr>
					<td width="40%">Customer Name:</td>
					<td colspan="2">${customerName}</td>

				</tr>
				<tr>
					<td>Address:</td>
					<td colspan="2">${address1 },${address2 }</td>

				</tr>
				<tr>
					<td>City:</td>
					<td colspan="2">${city}</td>

				</tr>
				<tr>
					<td>State:</td>
					<td colspan="2">${state}</td>

				</tr>
				<tr>
					<td>Zip:</td>
					<td colspan="2">${zip}</td>

				</tr>
				<tr>
					<td>Last trading date:</td>
					<td colspan="2">${lastDay}</td>

				</tr>
				<tr>
					<td>Last Posted Balance:</td>
					<td><b>$ ${cash}</b></td>
				</tr>
				<tr>
					<td>Available Cash:</td>
					<td><b>$ ${avai_cash}</b></td>
				</tr>
				</tbody>
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
</div>
</div>


<jsp:include page="template-bottom.jsp" />