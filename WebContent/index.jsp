<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<title>Index</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-2.2.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- Custom CSS -->
<link rel="stylesheet" href="css/style.css">

</head>

<body id="myPage" data-spy="scroll" data-target=".navbar"
    data-offset="60">

    <nav class="navbar navbar-default navbar-fixed-top">

        <div class="container">

            <div class="navbar-header">

                <button type="button" class="navbar-toggle"
                    data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand" href="#">Logo</a>

            </div>

            <div class="collapse navbar-collapse" id="myNavbar">

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#about">ABOUT COMPANY</a></li>
                    <li><a href="#value">OUR VALUES</a></li>
                    <li><a href="#contact">CONTACT US</a></li>
                </ul>

            </div>

        </div>

    </nav>

    <div class="jumbotron text-center">

        <h1>Carnegie Financial Services</h1>

        <p>We specialize in mutual fund investments.</p>

        <form class="form-horizontal" role="form" method="POST">

            <div class="form-group">
                <label class="control-label col-sm-4" for="email">Username:</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="email"
                        placeholder="Enter Username" name="userName">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" for="pwd">Password:</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="pwd"
                        placeholder="Enter password" name="password">
                </div>
            </div>
            <c:forEach var="error" items="${errors}">
                <h3 style="color: red">${error}</h3>
            </c:forEach>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <div class="checkbox">
                        <label><input type="checkbox">
                            Remember me</label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-7">
                    <button type="submit" class="btn btn-danger"
                        name="type" value="customer">Customer
                        Login</button>
                    <button type="submit" class="btn btn-success"
                        name="type" value="employee">Employee
                        Login</button>
                </div>
            </div>

        </form>

    </div>

    <!-- Container ("About Company" Section) -->
    <div id="about" class="container-fluid bg-grey">
        <div class="row">

            <div class="col-sm-8">
                <h2>About Company</h2>
                <h4>Carnegie Financial Services is...</h4>
                <p>Carnegie Financial Services is...</p>
                <button class="btn btn-default btn-lg">Get in
                    Touch</button>
            </div>

            <div class="col-sm-4">
                <span class="glyphicon glyphicon-signal logo slideanim"></span>
            </div>

        </div>
    </div>

    <!-- Container ("Our Values" Section) -->
    <div id="value" class="container-fluid">
        <div class="row">

            <div class="col-sm-4">
                <span class="glyphicon glyphicon-globe logo slideanim"></span>
            </div>

            <div class="col-sm-8">
                <h2>Our Values</h2>
                <h4>
                    <strong>MISSION:</strong> Our mission is...
                </h4>
                <p>
                    <strong>VISION:</strong> Our vision is...
                </p>
            </div>

        </div>
    </div>

    <!-- Container ("Contact Us" Section) -->
    <div id="contact" class="contact slideanim">
        <div class="container-fluid">

            <h2 class="text-center">CONTACT US</h2>
            <br />
            <br />

            <div class="row">
                <div class="col-sm-5">
                    <p>Contact us and we'll get back to you within
                        24 hours.</p>
                    <p>
                        <span class="glyphicon glyphicon-map-marker"></span>
                        Pittsburgh, PA, US
                    </p>
                    <p>
                        <span class="glyphicon glyphicon-phone"></span>
                        +01 412-268-707X
                    </p>
                    <p>
                        <span class="glyphicon glyphicon-envelope"></span>
                        mutualfund@carnegiefinancial.com
                    </p>
                </div>

                <div class="col-sm-7">
                    <div class="row">

                        <div class="col-sm-6 form-group">
                            <input class="form-control" id="name"
                                name="name" placeholder="Name"
                                type="text" required>
                        </div>

                        <div class="col-sm-6 form-group">
                            <input class="form-control" id="email"
                                name="email" placeholder="Email"
                                type="email" required>
                        </div>

                    </div>

                    <textarea class="form-control" id="comments"
                        name="comments" placeholder="Comment" rows="5"></textarea>
                    <br>

                    <div class="row">

                        <div class="col-sm-12 form-group">
                            <button class="btn btn-default pull-right"
                                type="submit">Send</button>
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

        <p>©2016 Carnegie Financial Services (CFS) by
            MSIT-eBusiness Team 6</p>
    </footer>

    <script>
                    $(document)
                            .ready(
                                    function() {
                                        // Add smooth scrolling to all links in navbar + footer link
                                        $(".navbar a, footer a[href='#myPage']")
                                                .on(
                                                        'click',
                                                        function(event) {

                                                            // Prevent default anchor click behavior
                                                            event
                                                                    .preventDefault();

                                                            // Store hash
                                                            var hash = this.hash;

                                                            // Using jQuery's animate() method to add smooth page scroll
                                                            // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
                                                            $('html, body')
                                                                    .animate(
                                                                            {
                                                                                scrollTop : $(
                                                                                        hash)
                                                                                        .offset().top
                                                                            },
                                                                            900,
                                                                            function() {

                                                                                // Add hash (#) to URL when done scrolling (default click behavior)
                                                                                window.location.hash = hash;
                                                                            });
                                                        });

                                        $(window)
                                                .scroll(
                                                        function() {
                                                            $(".slideanim")
                                                                    .each(
                                                                            function() {
                                                                                var pos = $(
                                                                                        this)
                                                                                        .offset().top;

                                                                                var winTop = $(
                                                                                        window)
                                                                                        .scrollTop();
                                                                                if (pos < winTop + 600) {
                                                                                    $(
                                                                                            this)
                                                                                            .addClass(
                                                                                                    "slide");
                                                                                }
                                                                            });
                                                        });
                                    })
                </script>

</body>

</html>