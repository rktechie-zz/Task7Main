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
<jsp:include page="error.jsp" />

<c:choose>
	<c:when test="${ (empty msg) }">
	</c:when>
	<c:otherwise>
		<h3 style="color: blue">${msg}</h3>
	</c:otherwise>
</c:choose>

<form role="form" action="reset.do" method="POST">
	<div class="form-group">
		<label>Choose an account by UserName:</label> <select
			class="form-control" name="customer1">
			<option></option>
			<c:choose>
				<c:when test="${ (empty customerList) }"></c:when>
				<c:otherwise>
					<c:forEach var="u" items="${ customerList }">
						<option>${ u.getUserName() }</option>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</select> 
		<label>Or search it here:</label> <input name="customer2"
                type="text" class="form-control" >
		<br> <label>New Password</label> <input class="form-control"
			name="newPass" type="password" placeholder="Case sensitive field">
	</div>

	<div class="form-group">
		<label>Confirm Password</label> <input class="form-control"
			name="confPass" type="password" placeholder="Case sensitive field">
		<input type="hidden" name="customer" value="${customer}">
	</div>
	<button type="submit" name="action" value="reset"
		class="btn btn-default">Set Password</button>
</form>

<jsp:include page="template-bottom.jsp" />