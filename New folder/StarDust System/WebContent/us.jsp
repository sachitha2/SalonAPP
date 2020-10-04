<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>StarDust Vehicle Care</title>
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

    <!-- Main Stylesheet File -->
    <link href="css/style.css" rel="stylesheet" />
</head>
<body>

<!-- 

		HEADER

 -->
 
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
            <li class="menu-active"><a href="us.jsp">About Us</a></li>
            <li><a href="contact.jsp">Contact Us</a></li>
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
    
    
    <main id="main">

		<section id="about">
	        <div class="container">
	          <header class="section-header">
	            <h3>About Us</h3>
	            <p>
	             We are working to our optimum capacity to ensure 
	             that our customers are able to experience a different and a 
	             superior service from every aspect. 
	            </p>
	          </header>
	
	          <div class="row about-cols">
	            <div class="col-md-4 wow fadeInUp">
	              <div class="about-col">
	                <div class="img">
	                  <img src="img/about-mission.jpg" alt="" class="img-fluid" />
	                  <div class="icon">
	                    <i class="ion-ios-speedometer-outline"></i>
	                  </div>
	                </div>
	                <h2 class="title"><a href="#">Our Mission</a></h2>
	                <p class="text-justify">
	                  Our mission is to provide a genuinely pleasant 
	                  and satisfying car wash experience to each of our customers.
	                  Your time is precious, and we will not waste it. Your automobile is valued, 
	                  and we will not abuse it. Your trust is essential, and we will work hard to earn it. 
	                </p>
	              </div>
	            </div>
	
	            <div class="col-md-4 wow fadeInUp" data-wow-delay="0.1s">
	              <div class="about-col">
	                <div class="img">
	                  <img src="img/about-plan.jpg" alt="" class="img-fluid" />
	                  <div class="icon"><i class="ion-ios-list-outline"></i></div>
	                </div>
	                <h2 class="title"><a href="#">Our Plan</a></h2>
	                <p class="text-justify">
	                  At StarDust, we aim to improve and better ourselves. 
	                  Recruit individuals who reflect our values and share an enthusiasm 
	                  to work as a team with one common goal: to provide the best possible 
	                  experience for both customers and co-workers. We are keeping our stations 
	                  upgraded with the latest technology available.
	                </p>
	              </div>
	            </div>
	
	            <div class="col-md-4 wow fadeInUp" data-wow-delay="0.2s">
	              <div class="about-col">
	                <div class="img">
	                  <img src="img/about-vision.jpg" alt="" class="img-fluid" />
	                  <div class="icon"><i class="ion-ios-eye-outline"></i></div>
	                </div>
	                <h2 class="title"><a href="#">Our Vision</a></h2>
	                <p class="text-justify">
	                 Our vision is to develop a trust relationship with you, defined by honesty, 
	                 integrity and fairness. Your satisfaction is our greatest desire, and 
	                 we mean to provide it. If you are pleased with our services and want to return,
	                  we could have no greater reward.
	                </p>
	              </div>
	            </div>
	          </div>
	        </div>
	      </section>
	     </main>
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
              <p>
                No:25 <br />
                Kandy Road<br />
                Malabe<br />
                <strong>Phone:</strong> 011-1234567<br />
                <strong>Email:</strong> info@stardust.vc.com<br />
              </p>

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
              <p class="text-justify">
                Subscribe to our Newsletter for a monthly update on special discounts, 
                new facilities and items you can purchase from us. Coupons will be added 
                with every edition for amazing deals on Car Wash and products. 
                Terms and conditions apply.
              </p>
              <form action="" method="post" class="form-inline">
                <input type="email" name="email" />
                <input
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