<jsp:include page="template-top-employee.jsp" />
<jsp:include page="error.jsp" />
<h1>&nbsp</h1>
<h1>&nbsp</h1>

<form class="form-horizontal" role="form" action="viewCustomerTransaction.do" method="POST">
    <jsp:include page="error.jsp" />
    <div class="form-group">
        <label class="control-label col-sm-2">Customer User Name:</label>
        <div class="col-sm-4">
                    <input type="text" class="form-control" id="userName" name="userName"
                placeholder="Enter customer user name here" value="${form.userName}">
        </div>
    </div>
        <div class="form-group">
        <div class="col-sm-offset-2 col-sm-4">
            <button type="submit" id="action" name="action" value="viewCustomerTransaction"
                class="btn btn-success pull-left">View Transaction</button>
        </div>
    </div>
</form>

<jsp:include page="template-bottom.jsp" />