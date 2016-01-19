<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="template-top-customer.jsp" />

<div id="viewTransactionHistory" class="container-fluid text-center">

     <br><br><br><br><br><br><br><br>

    <ul class="list-group">
        <li class="list-group-item list-group-item-success">Customer
            Name:</li>
        <li class="list-group-item list-group-item-warning">Customer
            Id:</li>
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
                    <th>${tran.fundName}</th>
                    <th>${tran.shares}</th>
                    <th>${tran.sharePrice}</th>
                    <th>${tran.amount}</th>
                </tr>
             </c:forEach>   
        </tbody>
    </table>
</div>

<br><br>

<jsp:include page="template-bottom.jsp" />
