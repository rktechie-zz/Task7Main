<jsp:include page="template-top-employee.jsp" />

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

	<br> <br>

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

		<br> <br>

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
					<a href="">TRANSITION DAY</a>
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

	<jsp:include page="template-bottom.jsp" />

	<script>
		$(document).ready(
				function() {
					// Add smooth scrolling to all links in navbar + footer link
					$(".navbar a, footer a[href='#myPage']").on('click',
							function(event) {

								// Store hash
								var hash = this.hash;

								// Using jQuery's animate() method to add smooth page scroll
								// The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
								$('html, body').animate({
									scrollTop : $(hash).offset().top
								}, 900, function() {

									// Add hash (#) to URL when done scrolling (default click behavior)
									window.location.hash = hash;
								});
							});

					$(".slideanim").each(function() {
						var pos = $(this).offset().top;

						var winTop = $(window).scrollTop();
						if (pos < winTop + 600) {
							$(this).addClass("slide");
						}
					});
				})
	</script>

	</body>

	</html>