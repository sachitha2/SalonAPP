<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>Contact Us</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="keywords" />
    <meta content="" name="description" />

    <!-- Favicons -->
    <link href="img/favicon.png" rel="icon" />
    <link href="img/apple-touch-icon.png" rel="apple-touch-icon" />

    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Montserrat:300,400,500,700"
      rel="stylesheet"
    />

    <!-- Bootstrap CSS File -->
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Libraries CSS Files -->
    <link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="lib/animate/animate.min.css" rel="stylesheet" />
    <link href="lib/ionicons/css/ionicons.min.css" rel="stylesheet" />
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />
    <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet" />

    <!--Stylesheets-->
    <link href="css/style.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/signup.css">
    
</head>

  <body>
    <!--==========================
    Header
  ============================-->
    <header id="header-mod">
      <div class="container-fluid">
        <div id="logo" class="pull-left">
          <a href="us.jsp">
            <img
              src="img/logo.png"
              alt="StarDust Vehicle Service"
              title=""
              class="logo-img"
            />
          </a>
        </div>

        <nav id="nav-menu-container">
          <ul class="nav-menu">
            <li><a href="index.jsp">Home</a></li>
            <%if(session.getAttribute("name") != null){%>
            <li><a href="customerProfile.jsp"><%out.print(session.getAttribute("name")); %>'s Profile</a></li>
             <%}%>
             <%if(session.getAttribute("user") == "Admin"){%>
            <li><a href="Admin.jsp">Admin Panel</a></li>
             <%}%>
            <li><a href="us.jsp">About Us</a></li>
            <li class="menu-active"><a href="contact.jsp">Contact Us</a></li>
            <li><a href="bookService.jsp">Services</a></li>
            <%if(session.getAttribute("name") == null && session.getAttribute("user") == null){%>
            <li><a href="login.jsp">Login/Signup</a></li>
            <%}           
            else {%>
            <li><a href="Logout">Logout</a></li>
            <%}%>
          </ul>
        </nav>
        <!-- #nav-menu-container -->
      </div>
    </header>
    <!-- #header -->

    <div class ="row ml-5">
       <div class="col-md-8">



            <div class="container-contact100">
			    <div class="contact100-map" id="google_map" data-map-x="40.722047" data-map-y="-73.986422" data-pin="images_s/icons/map-marker.png" data-scrollwhell="0" data-draggable="1"></div>
			
			    <div class="wrap-contact100">
			      <div class="contact100-form-title" style="background-image: url(img/bg-01.jpg);">
			        <span class="contact100-form-title-1">
			          <h1>Contact Us</h1>
			        </span>
			
			        <span class="contact100-form-title-2">
			          <h5>Feel free to drop us a line below!</h5>
			          <strong>Note that Registered Users get high priority!</strong>
			        </span>
			      </div>
			
			      <form class="contact100-form validate-form" method="POST" action="ContactUS">
			        <div class="wrap-input100 validate-input" data-validate="Name is required">
			          <span class="label-input100">Full Name:</span>
			          <input class="input100" type="text" name="name" placeholder="Enter full name">
			          <span class="focus-input100"></span>
			        </div>
			
			        <div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
			          <span class="label-input100">Email:</span>
			          <input class="input100" type="text" name="email" placeholder="Enter email addess">
			          <span class="focus-input100"></span>
			        </div>
			
			        <div class="wrap-input100 validate-input" data-validate="Phone is required">
			          <span class="label-input100">Phone:</span>
			          <input class="input100" type="text" name="phone" placeholder="Enter phone number">
			          <span class="focus-input100"></span>
			        </div>
			
			        <div class="wrap-input100 validate-input" data-validate = "Message is required">
			          <span class="label-input100">Message:</span>
			          <textarea class="input100" name="message" placeholder="Your Comment..."></textarea>
			          <span class="focus-input100"></span>
			        </div>
			
			        <div class="container-contact100-form-btn">
			          <button class="contact100-form-btn">
			            <span>
			              Submit
			              <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
			            </span>
			          </button>
			        </div>
			      </form>
			    </div>
			  </div>

    </div>
    
    <div class="col-md-4 mt-4 pt-4 mb-2 text-white contactUsBG">
    
    

       <!--==========================
      Contact Section
    ============================-->
      <section class="wow fadeInUp">
        <div class="container">
          <div class="section-header-mod">
            <h3>Contact Us</h3>
            <p class="text-white">
              Reach us and solve your problem
            </p>
          </div>
          
            <div class="col-sm mb-3 text-left h-25">
                <i class="contact-icon ion-ios-location-outline"></i>
                <h3>Address</h3>
                <address>No : 25, Kandy Road, Malabe</address>
            </div>
            

            <div class="col-sm mb-3 text-right h-25">
                <i class="contact-icon ion-ios-telephone-outline"></i>
                <h3>Phone Number</h3>
                <p class="text-white">011-1234567</p>
            </div>

            <div class="col-sm mb-3 text-left h-25">
                <i class="contact-icon ion-ios-email-outline"></i>
                <h3>Email</h3>
                <p class="text-white">info@stardust.vc.com</p>
            </div>
        </div>
      </section>
      <!-- #contact -->
      
      </div>
  </div>





  <!--==========================
    Footer
  ============================-->
    <footer id="footer">
      <div class="footer-top">
        <div class="container">
          <div class="row">
            <div class="col-lg-3 col-md-6 footer-info">
              <!--<h3>BizPage</h3>-->
              <img
                src="img/logo.png"
                alt="StarDust Vehicle Service"
                title=""
                class="logo-img"
              />
              <br><br>
              <p class="text-justify">
                StarDust Vehicle care provides the best service for all kinds of auto related services. 
                We provide the best service and repair for your vehicle with excellent care and close monitoring. 
                We guarantee that our customers will be fully satisfied with our service.
              </p>
            </div>

            <div class="col-lg-3 col-md-6 footer-links">
              <h4>Useful Links</h4>
              <br>
              <ul>
                <li>
                  <i class="ion-ios-arrow-right"></i> <a href="index.jsp">Home</a>
                </li>
                <li>
                  <i class="ion-ios-arrow-right"></i> <a href="us.jsp">About us</a>
                </li>
                <li>
                  <i class="ion-ios-arrow-right"></i> <a href="bookService.jsp">Services</a>
                </li>
                <li>
                  <i class="ion-ios-arrow-right"></i> <a href="login.jsp">Login/Signup</a>
                </li>
              </ul>
            </div>

            <div class="col-lg-3 col-md-6 footer-contact">
              <h4>Contact Us</h4>
              <br>
              <p class="text-white">
                No:25 <br />
                Kandy Road<br />
                Malabe<br />
                <strong>Phone:</strong> 011-1234567<br />
                <strong>Email:</strong> info@stardust.vc.com<br />
              </p>
              <br>

              <div class="social-links">
                <a href="https://www.twitter.com" class="twitter"><i class="fa fa-twitter"></i></a>
                <a href="https://www.facebook.com" class="facebook"><i class="fa fa-facebook"></i></a>
                <a href="https://www.instagram.com" class="instagram"
                  ><i class="fa fa-instagram"></i
                ></a>
                <a href="https://www.accounts.google.com" class="google-plus"
                  ><i class="fa fa-google-plus"></i
                ></a>
                <a href="https://lk.linkedin.com/" class="linkedin"><i class="fa fa-linkedin"></i></a>
              </div>
            </div>

            <div class="col-lg-3 col-md-6 footer-newsletter">
              <h4>Our Newsletter</h4>
              <br>
              <p class="text-justify text-white">
                Subscribe to our Newsletter for a monthly update on special discounts, 
                new facilities and items you can purchase from us. Coupons will be added 
                with every edition for amazing deals on Car Wash and products. 
                Terms and conditions apply.
              </p>
              <br>
              <form action="" method="post">
                <input type="email" name="email" /><input
                  type="submit"
                  value="Subscribe"
                />
              </form>
            </div>
          </div>
        </div>
      </div>

      <div class="container">
        <div class="copyright">
          &copy; Copyright <strong>StarDust Vehicle Care Pvt Ltd.</strong> All
          Rights Reserved
        </div>
      </div>
    </footer>
    <!-- #footer -->

    <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
    <div id="preloader"></div>

    <!-- JavaScript Libraries -->
    <script src="lib/jquery/jquery.min.js"></script>
    <script src="lib/jquery/jquery-migrate.min.js"></script>
    <script src="lib/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/superfish/hoverIntent.js"></script>
    <script src="lib/superfish/superfish.min.js"></script>
    <script src="lib/wow/wow.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/counterup/counterup.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/isotope/isotope.pkgd.min.js"></script>
    <script src="lib/lightbox/js/lightbox.min.js"></script>
    <script src="lib/touchSwipe/jquery.touchSwipe.min.js"></script>
    <!-- Contact Form JavaScript File -->
    <script src="contactform/contactform.js"></script>

    <!-- Template Main Javascript File -->
    <script src="js/main.js"></script>
  </body>
</html>