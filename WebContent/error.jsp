<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="form-group">
	<c:forEach var="error" items="${errors}">
		<div class="col-sm-offset-2 col-sm-4 alert alert-danger">
			${error}</div>
	</c:forEach>
</div>