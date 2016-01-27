<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="template-top-customer.jsp" />
<jsp:include page="error.jsp" />

<div id="viewTransactionHistory" class="container-fluid text-center">
     <br><br><br><br>
     <jsp:include page="error.jsp" />
    <ul class="list-group">
        <li class="list-group-item list-group-item-success">Customer
            First Name: ${customer.firstName}</li>
         <li class="list-group-item list-group-item-success">Customer
            Last Name: ${customer.lastName}</li>
        <li class="list-group-item list-group-item-warning">Customer
            User Name: ${customer.userName}</li>
    </ul>
</div>

<div class="container">
    <h3>Detailed Information</h3>
    <p>Include all pending transactions but no cash operation:</p>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Transaction Date</th>
                <th>Operation</th>
                <th>Fund Name</th>
                <th>Number of Shares</th>
                <th>Share Price</th>
                <th>Dollar Amount</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tran" items="${transactions}">   
                <tr>
                    <th>${tran.executeDate}</th>
                    <th>${tran.transactionType}</th>
                    <c:choose>
                        <c:when test="${tran.fundId == -1}">
                        <th>N/A</th>
                        </c:when>
                        <c:otherwise>
                        <th>${tran.fundName}</th>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${tran.shares == -1}">
                        <th>N/A</th>
                        </c:when>
                        <c:otherwise>
                        <th>${tran.shares}</th>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${tran.sharePrice == -1}">
                        <th>N/A</th>
                        </c:when>
                        <c:otherwise>
                        <th><fmt:setLocale value="en_US"/>
                        <fmt:formatNumber value="${tran.sharePrice}" type="currency"/></th>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${tran.amount == -1}">
                        <th>N/A</th>
                        </c:when>
                        <c:otherwise>
                        <th><fmt:setLocale value="en_US"/>
                        <fmt:formatNumber value="${tran.amount}" type="currency"/></th>
                        </c:otherwise>
                    </c:choose>
                </tr>
             </c:forEach>   
        </tbody>
    </table>
</div>

<br><br>

<jsp:include page="template-bottom.jsp" />
