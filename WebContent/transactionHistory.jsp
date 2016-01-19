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
            <tr>
                <td>John</td>
                <td>Doe</td>
                <td>john@example.com</td>
                <td>John</td>
                <td>Doe</td>
                <td>john@example.com</td>
            </tr>
        </tbody>
    </table>
</div>

<br><br>

<jsp:include page="template-bottom.jsp" />
