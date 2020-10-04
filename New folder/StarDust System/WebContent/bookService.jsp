<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Book a Vehicle Service</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
    <meta content="" name="keywords" />
    <meta content="" name="description" />

    <!-- Favicons -->
    <link href="img/favicon.png" rel="icon" />

    <!--Font Awesome-->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
      integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
      crossorigin="anonymous"
    />

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
            <li><a href="contact.jsp">Contact Us</a></li>
            <li class="menu-active"><a href="bookService.jsp">Services</a></li>
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

    <main id="main">
      <!--==========================
      Service Types
    ============================-->
      <section id="serviceTypes">
        <div class="container">
          <header class="section-header">
            <h3>Pick What You Want...</h3>
            <p>
              Choose our amazing services to protect your beloved vehicle. All
              services we are giving to you, made with love to guarantee the
              best result... No matter what your vehicle is, we are giving the
              best service in this country. Scroll down to pick one as you
              desire...
            </p>
          </header>

          <div class="row about-cols">
            <a href="washService.jsp">
              <div class="col-md-4 wow fadeInUp">
                <div class="about-col">
                  <div class="img">
                    <img
                      src="img/vehicle-service-basic.jpg"
                      alt=""
                      class="img-fluid"
                    />
                    <div class="icon">
                      <i class="fas fa-car-alt"></i>
                    </div>
                  </div>
                  <h2 class="title">
                    <a href="washService.jsp">Wooshie Wash : A Complete Wash</a>
                  </h2>
                  <p class="text-justify">
                    A perfect wash to make her more beautiful... After this your
                    vehicle will be a star... A easy peacy quick service for a
                    cheap price. We suggest you to do this once in every month.
                    Try it now, click the above image...
                  </p>
                </div>
              </div>
            </a>

            <a href="basic&fullService.jsp">
              <div class="col-md-4 wow fadeInUp" data-wow-delay="0.1s">
                <div class="about-col">
                  <div class="img">
                    <img
                      src="img/vehicle-service-full.jpg"
                      alt=""
                      class="img-fluid"
                    />
                    <div class="icon"><i class="fas fa-car"></i></div>
                  </div>
                  <h2 class="title">
                    <a href="basic&fullService.jsp"
                      >Awesome Care : Vehicle Service</a
                    >
                  </h2>
                  <p class="text-justify">
                    This is the necessary service to make your vehicle more
                    beauty and efficient. It's important to protect your vehicle
                    from various hazards, in-order to do that try our Basic and
                    Full Services. We guarantee after this
                    service your vehicle will be looks like a Brand New Vehicle. Check
                    it out, click the above image...
                  </p>
                </div>
              </div>
            </a>

            <a href="repairService.jsp">
              <div class="col-md-4 wow fadeInUp" data-wow-delay="0.2s">
                <div class="about-col">
                  <div class="img">
                    <img
                      src="img/vehicle-repair.jpg"
                      alt=""
                      class="img-fluid"
                    />
                    <div class="icon"><i class="fas fa-ambulance"></i></div>
                  </div>
                  <h2 class="title">
                    <a href="repairService.jsp"
                      >Ambulance Repair : Regular & Mobile Vehicle Repair
                      Service</a
                    >
                  </h2>
                  <p class="text-justify">
                    Is your vehicle broken? Then come to us with your vehicle. We'll fix it. You
                    do not need to worry about anything... Can't come to us?
                    Don't worry about that too. We can come to you... Contact us, and we will be there. Click the above image to make it
                    happen...
                  </p>
                </div>
              </div>
            </a>
          </div>
        </div>
      </section>
      <!-- #Service Types -->
    </main>

    <!--==========================
      Service Big Picture Section
    ============================-->
    <!-- <section id="ServiceBigPicture" class="wow fadeIn">
      <div class="container">
        <div class="ServiceBigPicture-img">
          <img src="img/vehicleServiceBig.jpg" alt="" class="img-fluid" />
        </div>
      </div>
    </section> -->
    <!-- #Service Big Picture Section -->

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
                <a href="#" class="twitter"><i class="fa fa-twitter"></i></a>
                <a href="#" class="facebook"><i class="fa fa-facebook"></i></a>
                <a href="#" class="instagram"
                  ><i class="fa fa-instagram"></i
                ></a>
                <a href="#" class="google-plus"
                  ><i class="fa fa-google-plus"></i
                ></a>
                <a href="#" class="linkedin"><i class="fa fa-linkedin"></i></a>
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
    <!-- Uncomment below i you want to use a preloader -->
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
