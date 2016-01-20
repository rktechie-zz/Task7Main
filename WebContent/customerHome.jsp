<jsp:include page="template-top-customer.jsp" />
    
    <div id="viewAccount" class="container-fluid text-center">
    
        <h2>VIEW ACCOUNT</h2>
        <h4>How Is It Going?</h4>
        <br><br>
        
        <ul class="list-group">
            <li class="list-group-item list-group-item-success">My Name:</li>
            <li class="list-group-item list-group-item-success">My Address:</li>
            <li class="list-group-item list-group-item-warning">Last Trading Date:</li>
            <li class="list-group-item list-group-item-danger">Cash Balance:</li>
            <li class="list-group-item list-group-item-info">Fund Owned:</li>
        </ul>         
            
    </div>
    
    <div id="dashBoard" class="container-fluid text-center">
    
        <h2>DASHBOARD</h2>
        <h4>What Can I Do?</h4>
        <br><br>
        
            <div class="row">
            
            <div class="col-sm-6">
                <span class="glyphicon glyphicon-piggy-bank logo-small slideanim"></span>
                <h4><a href="">BUY FUND</a></h4>
                <p>This is...</p>
            </div>
            
            <div class="col-sm-6">
                <span class="glyphicon glyphicon-send logo-small slideanim"></span>
                <h4><a href="">SELL FUND</a></h4>
                <p>This is...</p>
            </div>
            
            </div>
        
            <br><br>
            
            <div class="row">
            
            <div class="col-sm-6">
                <span class="glyphicon glyphicon-credit-card logo-small slideanim"></span>
                <h4><a href="">REQUEST CHECK</a></h4>
                <p>This is...</p>
            </div>
            
            <div class="col-sm-6">
                <span class="glyphicon glyphicon-transfer logo-small slideanim"></span>
                <h4><a href="">TRANSACTION HISTORY</a></h4>
                <p>This is...</p>
            </div>
            
            </div>
            
            <br><br>
            
            <div class="row">
            
            <div class="col-sm-6">
                <span class="glyphicon glyphicon-stats logo-small slideanim"></span>
                <h4><a href="">RESEARCH FUND</a></h4>
                <p>This is...</p>
            </div>
            
            <div class="col-sm-6">
                <span class="glyphicon glyphicon-lock logo-small slideanim"></span>
                <h4><a href="">MANAGE PASSWORD</a></h4>
                <p>This is...</p>
            </div>
            
            </div>           
            
    </div>

    <!-- Container ("Contact Us" Section) -->
    <div id="contact" class="contact slideanim">
        <div class="container-fluid">
        
            <h2 class="text-center">Need Help?</h2>
            <br/><br/>
          
            <div class="row">
                <div class="col-sm-5">
                    <p>Contact us and we'll get back to you within 24 hours.</p>
                    <p><span class="glyphicon glyphicon-map-marker"></span> Pittsburgh, PA, US</p>
                    <p><span class="glyphicon glyphicon-phone"></span> +01 412-268-707X</p>
                    <p><span class="glyphicon glyphicon-envelope"></span> mutualfund@carnegiefinancial.com</p> 
                </div>
                
                <div class="col-sm-7">
                    <div class="row">
                    
                        <div class="col-sm-6 form-group">
                            <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
                        </div>
                    
                        <div class="col-sm-6 form-group">
                            <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
                        </div>
                   
                   </div>
              
                   <textarea class="form-control" id="problem" name="problem" placeholder="Problem" rows="5"></textarea><br>
              
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
    
        <a href="#myPage" title="To Top">        
            <span class="glyphicon glyphicon-chevron-up"></span>            
        </a>
        
        <p>Â©2016 Carnegie Financial Services (CFS) by MSIT-eBusiness Team 6</p> 
    </footer>
    
    <script>
    $(document).ready(function(){
        // Add smooth scrolling to all links in navbar + footer link
        $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

        // Prevent default anchor click behavior
        event.preventDefault();

        // Store hash
        var hash = this.hash;

        // Using jQuery's animate() method to add smooth page scroll
        // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 900, function(){

            // Add hash (#) to URL when done scrolling (default click behavior)
            window.location.hash = hash;
            });
        });
        
      $(window).scroll(function() {
          $(".slideanim").each(function(){
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
