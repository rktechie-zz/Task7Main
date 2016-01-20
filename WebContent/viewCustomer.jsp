<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="template-top-employee.jsp" />

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="row">
	<div class="col-lg-12">
		<h2 class="page-header">View Customer Account</h2>
	</div>
</div>

<jsp:include page="error.jsp" />

<div class="col-lg-6">
	<form action="viewCustomer.do" method="POST">
		<div class="form-group">
			<label>Choose an account by UserName:</label> <select
				class="form-control" name="userName1">
				<option></option>
				<c:choose>
					<c:when test="${ (empty customerList) }"></c:when>
					<c:otherwise>
						<c:forEach var="u" items="${ customerList }">
							<option>${ u.getUserName() }</option>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</select> <label>Or search it here:</label> <input name="userName2"
				type="text" class="form-control" value="${form.userName2}">
			<br>
			<button type="submit" name="action" value="select"
				class="btn btn-primary">Select Account</button>
		</div>
	</form>
</div>

<jsp:include page="template-bottom.jsp" />