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

		<div class="container">

			<div class="navbar-header">

				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<a class="navbar-brand" href="#">Logo</a>

			</div>

			<div class="collapse navbar-collapse" id="myNavbar">

				<ul class="nav navbar-nav navbar-right">
					<li><a href="#dashBoard">DASHBOARD</a></li>
					<li><a href="#contact">NEED HELP</a></li>
					<li><a href="logout.do">LOG OUT</a></li>
				</ul>

			</div>

		</div>

	</nav>

	<div id="dashBoard" class="container-fluid text-center">

		<h2>DASHBOARD</h2>
		<h4>What Can I Do?</h4>
		<br>
		<br>

		<div class="row">

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-briefcase logo-small slideanim"></span>
				<h4>
					<a href="">CREATE EMPLOYEE ACCOUNT</a>
				</h4>
				<p>This is...</p>
			</div>

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-user logo-small slideanim"></span>
				<h4>
					<a href="">CREATE CUSTOMER ACCOUNT</a>
				</h4>
				<p>This is...</p>
			</div>

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-eye-open logo-small slideanim"></span>
				<h4>
					<a href="">VIEW CUSTOMER ACCOUNT</a>
				</h4>
				<p>This is...</p>
			</div>

		</div>

		<br>
		<br>

		<div class="row">

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-floppy-open logo-small slideanim"></span>
				<h4>
					<a href="">CREATE FUND</a>
				</h4>
				<p>This is...</p>
			</div>

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-list-alt logo-small slideanim"></span>
				<h4>
					<a href="">TRANSITION DAY</a>
				</h4>
				<p>This is...</p>
			</div>

			<div class="col-sm-4">
				<span class="glyphicon glyphicon-lock logo-small slideanim"></span>
				<h4>
					<a href="">MANAGE PASSWORD</a>
				</h4>
				<p>This is...</p>
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

		<p>©2016 Carnegie Financial Services (CFS) by MSIT-eBusiness Team
			6</p>
	</footer>

	<script>
		$(document).ready(
				function() {
					// Add smooth scrolling to all links in navbar + footer link
					$(".navbar a, footer a[href='#myPage']").on('click',
							function(event) {

								// Prevent default anchor click behavior
								event.preventDefault();

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
