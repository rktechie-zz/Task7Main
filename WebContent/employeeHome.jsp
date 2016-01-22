<jsp:include page="template-top-employee.jsp" />

<div id="content">
	<div id="dashBoard" class="container-fluid text-center">
		<h2>DASHBOARD</h2>
		<h4>What Can I Do?</h4>
		<br> <br>

		<div class="row">

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-user logo-small slideanim"></span>
				<h4>
					<a href="createEmployee.do">CREATE EMPLOYEE ACCOUNT</a>
				</h4>
				<p>This is CREATE EMPLOYEE ACCOUNT</p>
			</div>

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-user logo-small slideanim"></span>
				<h4>
					<a href="createCustomer.do">CREATE CUSTOMER ACCOUNT</a>
				</h4>
				<p>This is CREATE CUSTOMER ACCOUNT</p>
			</div>

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-eye-open logo-small slideanim"></span>
				<h4>
					<a href="viewCustomer.do">VIEW CUSTOMER ACCOUNT</a>
				</h4>
				<p>This is VIEW CUSTOMER ACCOUNT</p>
			</div>
		</div>

		<br>

		<div class="row">

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-floppy-open logo-small slideanim"></span>
				<h4>
					<a href="createFund.do">CREATE FUND</a>
				</h4>
				<p>This is CREATE FUND</p>
			</div>

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-list-alt logo-small slideanim"></span>
				<h4>
					<a href="transitionDay.do">TRANSITION DAY</a>
				</h4>
				<p>This is TRANSITION DAY</p>
			</div>

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-briefcase logo-small slideanim"></span>
				<h4>
					<a href="depositCheck.do">DEPOSIT CHECK</a>
				</h4>
				<p>This is DEPOSIT CHECK</p>
			</div>

		</div>

		<br>
		<div class="row">
			<div class="col-sm-4">
				<span class="glyphicon glyphicon-lock logo-small slideanim"></span>
				<h4>
					<a href="reset.do">RESET CUSTOMER PASSWORD</a>
				</h4>
				<p>This is RESET CUSTOMER PASSWORD</p>
			</div>

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-lock logo-small slideanim"></span>
				<h4>
					<a href="changePassword.do">CHANGE EMPLOYEE PASSWORD</a>
				</h4>
				<p>This is CHANGE EMPLOYEE PASSWORD</p>
			</div>

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-eye-open logo-small slideanim"></span>
				<h4>
					<a href="viewCustomerTransaction.do">VIEW CUSTOMER TRANSACTION
						HISTORY</a>
				</h4>
				<p>This is VIEW CUSTOMER TRANSACTION HISTORY</p>
			</div>

		</div>

	</div>
</div>

<jsp:include page="template-bottom.jsp" />
<script src="js/custom.js"></script>

</body>

</html>