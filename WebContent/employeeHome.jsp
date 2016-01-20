<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<html lang="en">
<head>

<title>Employee_Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
 <link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-2.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- Custom CSS -->
<link rel="stylesheet" href="style.css">

</head>

<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">

    <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="login.do">CFS</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="login.do">HOME</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">CUSTOMER ACCOUNT
                 <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="createCustomer.do">CREATE CUSTOMER ACCOUNT</a></li>
                    <li><a href="changePassword.do">RESET CUSTOMER PASSWORD</a></li>
                    <li><a href="viewCustomerAccount.do">VIEW CUSTOMER ACCOUNT</a></li>
                    <li><a href="viewCustomerTransaction.do">VIEW CUSTOMER TRANSACTION HISTORY</a></li>
                </ul></li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">EMPLOYEE OPERATION
                 <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="depositCheck.do">DEPOSIT CHECK</a></li>
                    <li><a href="createFund.do">CREATE FUND</a></li>
                    <li><a href="transitionDay.do">TRANSITION DAY</a></li>
                </ul></li>
            <li><a href="createEmployee.do">CREATE EMPLOYEE ACCOUNT</a></li>
             <li><a href="logOut.jsp">LOG OUT</a></li>
        </ul>
    </div>
    </nav>

	<div id="dashBoard" class="container-fluid text-center">
		<h2>DASHBOARD</h2>
		<h4>What Can I Do?</h4>
		<br>
		<br>

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
					<a href="viewCustomerAccount.do">VIEW CUSTOMER ACCOUNT</a>
				</h4>
				<p>This is VIEW CUSTOMER ACCOUNT</p>
			</div>
         </div>

		<br>
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
					<a href="">RESET CUSTOMER PASSWORD</a>
				</h4>
				<p>This is RESET CUSTOMER PASSWORD</p>
		</div>
		
		<div class="col-sm-4">
				<span class="glyphicon glyphicon-lock logo-small slideanim"></span>
				<h4>
					<a href="employeeChangePassword.do">CHANGE EMPLOYEE PASSWORD</a>
				</h4>
				<p>This is CHANGE EMPLOYEE PASSWORD</p>
		</div>
        
        <div class="col-sm-4">
                <span class="glyphicon glyphicon-eye-open logo-small slideanim"></span>
                <h4>
                    <a href="viewCustomerTransaction.do">VIEW CUSTOMER TRANSACTION HISTORY</a>
                </h4>
                <p>This is VIEW CUSTOMER TRANSACTION HISTORY</p>
         </div>

	</div>
    
    </div>

	<!-- Container ("Contact Us" Section) -->
	<div id="contact" class="contact slideanim">
		<div class="container-fluid">

			<h2 class="text-center">Need Help?</h2>
			<br />
			<br />

			<div class="row">
				<div class="col-sm-5">
					<p>Contact us and we'll get back to you within 24 hours.</p>
					<p>
						<span class="glyphicon glyphicon-map-marker"></span> Pittsburgh,
						PA, US
					</p>
					<p>
						<span class="glyphicon glyphicon-phone"></span> +01 412-268-707X
					</p>
					<p>
						<span class="glyphicon glyphicon-envelope"></span>
						mutualfund@carnegiefinancial.com
					</p>
				</div>

				<div class="col-sm-7">
					<div class="row">

						<div class="col-sm-6 form-group">
							<input class="form-control" id="name" name="name"
								placeholder="Name" type="text" required>
						</div>

						<div class="col-sm-6 form-group">
							<input class="form-control" id="email" name="email"
								placeholder="Email" type="email" required>
						</div>

					</div>

					<textarea class="form-control" id="problem" name="problem"
						placeholder="Problem" rows="5"></textarea>
					<br>

					<div class="row">

						<div class="col-sm-12 form-group">
							<button class="btn btn-default pull-right" type="submit">Send</button>
						</div>
					</div>

				</div>
			</div>
		</div>

	</div>

	<footer class="container-fluid text-center">

		<a href="#myPage" title="To Top"> <span
			class="glyphicon glyphicon-chevron-up"></span>
		</a>

		<p>Â©2016 Carnegie Financial Services (CFS) by MSIT-eBusiness Team
			6</p>
	</footer>

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

					$(window).scroll(function() {
						$(".slideanim").each(function() {
							var pos = $(this).offset().top;

							var winTop = $(window).scrollTop();
							if (pos < winTop + 600) {
								$(this).addClass("slide");
							}
						});
					});
				})
	</script>

</body>

</html>
