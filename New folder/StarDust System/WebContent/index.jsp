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
    
    <script type="text/javascript">
    
    function urlReading(){
		var url_string = window.location.href;
		var url = new URL(url_string);
		var msg1 = url.searchParams.get("Contact");
		var msg2 = url.searchParams.get("User");
		
		
		if(msg1 == "Success")
			alert("Your Message Successfully sent to the Administrator!");
		
		if(msg2 == "Deleted")
			alert("Your account has been deleted! Thank you for staying with us...");
    }
    
    </script>
    
    
  </head>

  <body onload="urlReading()">
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
            <li class="menu-active"><a href="index.jsp">Home</a></li>
            <%if(session.getAttribute("name") != null){%>
            <li><a href="customerProfile.jsp"><%out.print(session.getAttribute("name")); %>'s Profile</a></li>
             <%}%>
             <%if(session.getAttribute("user") == "Admin"){%>
            <li><a href="Admin.jsp">Admin Panel</a></li>
             <%}%>
            <li><a href="us.jsp">About Us</a></li>
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
    <!-- #header -->

    <!--==========================
    Intro Section
  ============================-->
    <section id="intro">
      <div class="intro-container">
        <div
          id="introCarousel"
          class="carousel  slide carousel-fade"
          data-ride="carousel"
        >
          <ol class="carousel-indicators"></ol>

          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <div class="carousel-background">
                <img src="img/intro-carousel/1.jpg" alt="" />
              </div>
              <div class="carousel-container">
                <div class="carousel-content">
                  <h2>We are professional</h2>
                  <p>
                    Our corporation is a fully functional establishment 
                    employed by highly trained professionals to 
                    deliver the most tender automobile care and fuel facility for your vehicle.
                  </p>
                  <a href="login.jsp" class="btn-get-started"
                    >Get Started</a
                  >
                </div>
              </div>
            </div>

            <div class="carousel-item">
              <div class="carousel-background">
                <img src="img/intro-carousel/2.jpg" alt="" />
              </div>
              <div class="carousel-container">
                <div class="carousel-content">
                  <h2>Our Services</h2>
                  <p>
                    StarDust Vehicle Care brings you a variety of services for your
                     preferences such as fuel station facilities, Wash Service, 
                     Interior and exterior cleaning, Eco testing, Repair, Tune up 
                     and more.
                  </p>
                  <a href="login.jsp" class="btn-get-started"
                    >Get Started</a
                  >
                </div>
              </div>
            </div>

            <div class="carousel-item">
              <div class="carousel-background">
                <img src="img/intro-carousel/3.jpg" alt="" />
              </div>
              <div class="carousel-container">
                <div class="carousel-content">
                  <h2>Customer Care</h2>
                  <p>
                    We also provide other facilities such as a Customer waiting lounge, 
                    a Cafeteria, free Wi-Fi, Auto Parts Shop so that you can keep 
                    yourself occupied until your ride is ready.

                  </p>
                  <a href="login.jsp" class="btn-get-started"
                    >Get Started</a
                  >
                </div>
              </div>
            </div>

            <div class="carousel-item">
              <div class="carousel-background">
                <img src="img/intro-carousel/4.jpg" alt="" />
              </div>
              <div class="carousel-container">
                <div class="carousel-content">
                  <h2>Why us?</h2>
                  <p>
                    With 20 years of experience and our state-of-the-art equipment,
                    we strive to serve outstanding results from inside and out 
                    while conserving water and keeping the environment clean.
                  </p>
                  <a href="login.jsp" class="btn-get-started"
                    >Get Started</a
                  >
                </div>
              </div>
            </div>

          <a
            class="carousel-control-prev"
            href="#introCarousel"
            role="button"
            data-slide="prev"
          >
            <span
              class="carousel-control-prev-icon ion-chevron-left"
              aria-hidden="true"
            ></span>
            <span class="sr-only">Previous</span>
          </a>

          <a
            class="carousel-control-next"
            href="#introCarousel"
            role="button"
            data-slide="next"
          >
            <span
              class="carousel-control-next-icon ion-chevron-right"
              aria-hidden="true"
            ></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
    </section>
    <!-- #intro -->

    <main id="main">
      <!--==========================
      Featured Services Section
    ============================-->
      <section id="featured-services">
        <div class="container">
          <div class="row">
            <div class="col-lg-4 box text-center">
              <i class="ion-android-car"></i>
              <h4 class="title"><a href="">Service</a></h4>
              <p class="description">
                We are committed to assign the perfect service that best suits your needs.
              </p>
            </div>

            <div class="col-lg-4 box text-center">
              <i class="ion-speedometer"></i>
              <h4 class="title"><a href="">Performance</a></h4>
              <p class="description">

                In and out swiftly while maintaining the best results possible.

              </p>
            </div>

            <div class="col-lg-4 box text-center">
              <i class="ion-android-cart"></i>
              <h4 class="title"><a href="">Shop</a></h4>
              <p class="description">
                  Find the finest products and auto parts at our Store with discount prices.
              </p>
            </div>
          </div>
        </div>
      </section>
      <!-- #featured-services -->



      <!--==========================
      Portfolio Section
    ============================-->
      <section id="portfolio" class="section-bg">
        <div class="container">
          <header class="section-header">
            <h3 class="section-title">Our Portfolio</h3>
          </header>

          <div class="row">
            <div class="col-lg-12">
              <ul id="portfolio-flters">
                <li data-filter="*" class="filter-active">All</li>
                <li data-filter=".filter-wash">Car Wash</li>
                <li data-filter=".filter-repair">Repair</li>
                <li data-filter=".filter-main">Maintenance</li>
              </ul>
            </div>
          </div>

          <div class="row portfolio-container">
            <div
              class="col-lg-4 col-md-6 portfolio-item filter-wash wow fadeInUp"
            >
              <div class="portfolio-wrap">
                <figure>
                  <img src="img/portfolio/wash1.jpg" class="img-fluid" alt="" />
                  <a
                    href="img/portfolio/wash1.jpg"
                    data-lightbox="portfolio"
                    data-title="Exterior wash"
                    class="link-preview"
                    title="Preview"
                    ><i class="ion ion-eye"></i
                  ></a>
                </figure>

                <div class="portfolio-info">
                  <h4><a href="#">Exterior wash</a></h4>
                  <p>Car Wash</p>
                </div>
              </div>
            </div>

            <div
              class="col-lg-4 col-md-6 portfolio-item filter-main wow fadeInUp"
              data-wow-delay="0.1s"
            >
              <div class="portfolio-wrap">
                <figure>
                  <img src="img/portfolio/main1.jpg" class="img-fluid" alt="" />
                  <a
                    href="img/portfolio/main1.jpg"
                    class="link-preview"
                    data-lightbox="portfolio"
                    data-title="Oil Change"
                    title="Preview"
                    ><i class="ion ion-eye"></i
                  ></a>
                </figure>

                <div class="portfolio-info">
                  <h4><a href="#">Oil Change</a></h4>
                  <p>Maintenance</p>
                </div>
              </div>
            </div>

            <div
              class="col-lg-4 col-md-6 portfolio-item filter-wash wow fadeInUp"
              data-wow-delay="0.2s"
            >
              <div class="portfolio-wrap">
                <figure>
                  <img src="img/portfolio/wash2.jpeg" class="img-fluid" alt="" />
                  <a
                    href="img/portfolio/wash2.jpeg"
                    class="link-preview"
                    data-lightbox="portfolio"
                    data-title="Interior Cleaning"
                    title="Preview"
                    ><i class="ion ion-eye"></i
                  ></a>
                </figure>

                <div class="portfolio-info">
                  <h4><a href="#">Interior Cleaning</a></h4>
                  <p>Car Wash</p>
                </div>
              </div>
            </div>

            <div
              class="col-lg-4 col-md-6 portfolio-item filter-repair wow fadeInUp"
            >
              <div class="portfolio-wrap">
                <figure>
                  <img src="img/portfolio/repair1.jpg" class="img-fluid" alt="" />
                  <a
                    href="img/portfolio/repair1.jpg"
                    class="link-preview"
                    data-lightbox="portfolio"
                    data-title="Wheel Alignment"
                    title="Preview"
                    ><i class="ion ion-eye"></i
                  ></a>
                </figure>

                <div class="portfolio-info">
                  <h4><a href="#">Wheel Alignment</a></h4>
                  <p>Repair</p>
                </div>
              </div>
            </div>

            <div
              class="col-lg-4 col-md-6 portfolio-item filter-main wow fadeInUp"
              data-wow-delay="0.1s"
            >
              <div class="portfolio-wrap">
                <figure>
                  <img src="img/portfolio/main2.jpg" class="img-fluid" alt="" />
                  <a
                    href="img/portfolio/main2.jpg"
                    class="link-preview"
                    data-lightbox="portfolio"
                    data-title="Gas Pump Facility"
                    title="Preview"
                    ><i class="ion ion-eye"></i
                  ></a>
                </figure>

                <div class="portfolio-info">
                  <h4><a href="#">Gas Pump Facility</a></h4>
                  <p>Maintenance</p>
                </div>
              </div>
            </div>

            <div
              class="col-lg-4 col-md-6 portfolio-item filter-wash wow fadeInUp"
              data-wow-delay="0.2s"
            >
              <div class="portfolio-wrap">
                <figure>
                  <img src="img/portfolio/wash3.jpg" class="img-fluid" alt="" />
                  <a
                    href="img/portfolio/wash3.jpg"
                    class="link-preview"
                    data-lightbox="portfolio"
                    data-title="Headlight Restoration"
                    title="Preview"
                    ><i class="ion ion-eye"></i
                  ></a>
                </figure>

                <div class="portfolio-info">
                  <h4><a href="#">Headlight Restoration</a></h4>
                  <p>CAR WASH</p>
                </div>
              </div>
            </div>

            <div
              class="col-lg-4 col-md-6 portfolio-item filter-repair wow fadeInUp"
            >
              <div class="portfolio-wrap">
                <figure>
                  <img src="img/portfolio/repair2.jpg" class="img-fluid" alt="" />
                  <a
                    href="img/portfolio/repair2.jpg"
                    class="link-preview"
                    data-lightbox="portfolio"
                    data-title="Engine Repair"
                    title="Preview"
                    ><i class="ion ion-eye"></i
                  ></a>
                </figure>

                <div class="portfolio-info">
                  <h4><a href="#">Engine Repair</a></h4>
                  <p>Repair</p>
                </div>
              </div>
            </div>

            <div
              class="col-lg-4 col-md-6 portfolio-item filter-repair wow fadeInUp"
              data-wow-delay="0.1s"
            >
              <div class="portfolio-wrap">
                <figure>
                  <img src="img/portfolio/repair3.jpg" class="img-fluid" alt="" />
                  <a
                    href="img/portfolio/repair3.jpg"
                    class="link-preview"
                    data-lightbox="portfolio"
                    data-title="Auto Painting"
                    title="Preview"
                    ><i class="ion ion-eye"></i
                  ></a>
                </figure>

                <div class="portfolio-info">
                  <h4><a href="#">Auto Painting</a></h4>
                  <p>Repair</p>
                </div>
              </div>
            </div>

            <div
              class="col-lg-4 col-md-6 portfolio-item filter-main wow fadeInUp"
              data-wow-delay="0.2s"
            >
              <div class="portfolio-wrap">
                <figure>
                  <img src="img/portfolio/main3.jpg" class="img-fluid" alt="" />
                  <a
                    href="img/portfolio/main3.jpg"
                    class="link-preview"
                    data-lightbox="portfolio"
                    data-title="Air Pump Facility"
                    title="Preview"
                    ><i class="ion ion-eye"></i
                  ></a>
                </figure>

                <div class="portfolio-info">
                  <h4><a href="#">Air Pump Facility</a></h4>
                  <p>Maintenance</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- #portfolio -->

      <!--==========================
      Clients Section
    ============================-->
      <section id="clients" class="wow fadeInUp">
        <div class="container">
          <header class="section-header">
            <h3>Our Clients</h3>
          </header>

          <div class="owl-carousel clients-carousel">
            <img src="img/clients/client-1.png" alt="" />
            <img src="img/clients/client-2.png" alt="" />
            <img src="img/clients/client-3.png" alt="" />
            <img src="img/clients/client-4.png" alt="" />
            <img src="img/clients/client-5.png" alt="" />
            <img src="img/clients/client-6.png" alt="" />
            <img src="img/clients/client-7.png" alt="" />
            <img src="img/clients/client-8.png" alt="" />
          </div>
        </div>
      </section>
      <!-- #clients -->

      

      <!--==========================
      Team Section
    ============================-->
      <section id="team">
        <div class="container">
          <div class="section-header wow fadeInUp">
            <h3>Team</h3>
            <p>
              The group of individuals that work as a unit to make this all possible!
            </p>
          </div>

          <div class="row">
            <div class="col-lg-3 col-md-6 wow fadeInUp">
              <div class="member">
                <img src="img/team-1.jpg" class="img-fluid" alt="" />
                <div class="member-info">
                  <div class="member-info-content">
                    <h4>Walter White</h4>
                    <span>Chief Executive Officer</span>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
              <div class="member">
                <img src="img/team-2.jpg" class="img-fluid" alt="" />
                <div class="member-info">
                  <div class="member-info-content">
                    <h4>Sarah Jhonson</h4>
                    <span>Manager</span>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.2s">
              <div class="member">
                <img src="img/team-3.jpg" class="img-fluid" alt="" />
                <div class="member-info">
                  <div class="member-info-content">
                    <h4>William Anderson</h4>
                    <span>Accountant</span>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
              <div class="member">
                <img src="img/team-4.jpg" class="img-fluid" alt="" />
                <div class="member-info">
                  <div class="member-info-content">
                    <h4>Service Crew</h4>
                    <span></span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- #team -->

      <!--==========================
      Contact Section
    ============================-->
      <section id="contact" class="section-bg wow fadeInUp">
        <div class="container">
          <div class="section-header">
            <h3><a href="contact.jsp">Contact Us</a></h3>
            <p>
              Reach us and solve your problem
            </p>
          </div>

          <div class="row contact-info">
            <div class="col-md-4">
              <div class="contact-address">
                <i class="ion-ios-location-outline"></i>
                <h3>Address</h3>
                <address>No : 25, Kandy Road, Malabe</address>
              </div>
            </div>

            <div class="col-md-4">
              <div class="contact-phone">
                <i class="ion-ios-telephone-outline"></i>
                <h3>Phone Number</h3>
                <p><a href="tel:+155895548855">011-1234567</a></p>
              </div>
            </div>

            <div class="col-md-4">
              <div class="contact-email">
                <i class="ion-ios-email-outline"></i>
                <h3>Email</h3>
                <p><a href="mailto:info@example.com">info@stardust.vc.com</a></p>
              </div>
            </div>
          </div>

         
        </div>
      </section>
      <!-- #contact -->
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