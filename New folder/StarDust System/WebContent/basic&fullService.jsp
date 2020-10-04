<%@ page import ="com.stardust.dao.CustomerDAO" import ="com.stardust.customer.Customer" import ="com.stardust.services.Service" import= "java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%
    
  		//Secure Page. Need Login Credentials to access to this page
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");   
    
    
    	//Create a Customer Class Object
		Customer customer = Customer.getInstance();
    
  		//Create a CustomerDAO Class Object
  		CustomerDAO dao = new CustomerDAO();
  		
  		//Set Email
  		dao.setEmail((String)session.getAttribute("email"));
  		
  		//Get data From the Database
  		dao.assignData();
  		
  		//Load Data
  		customer = dao.getData();
  		
  		//HashMap Set of Customer Class
  		HashMap <Integer, String> vehicleType = new HashMap <Integer, String>();
  		vehicleType.putAll(customer.getVehicleType());
  		
  		HashMap <Integer, String> vehicleBrand = new HashMap <Integer, String>();
  		vehicleBrand.putAll(customer.getVehicleBrand());
  		
  		HashMap <Integer, String> vehicleModel = new HashMap <Integer, String>();
  		vehicleModel.putAll(customer.getVehicleModel());
  		
  		
  		//Create an Entry Set
  		Set<Map.Entry<Integer, String>> set1 = vehicleType.entrySet();
  		Set<Map.Entry<Integer, String>> set2 = vehicleBrand.entrySet();
  		Set<Map.Entry<Integer, String>> set3 = vehicleModel.entrySet();
  		
  		int row = 0;
  		
  		String vehicle[][] = new String[5][5];
  		
  		//Load Data
  		for(Map.Entry<Integer, String> count : set1)
  		{
  			vehicle[row][0] = count.getValue();
  			row++;
  		}
  		
  		row = 0;
  		
  		for(Map.Entry<Integer, String> count : set2)
  		{
  			vehicle[row][1] = count.getValue();
  			row++;
  		}
  		
  		row = 0;
  		
  		for(Map.Entry<Integer, String> count : set3)
  		{
  			vehicle[row][2] = count.getValue();
  			row++;
  		}		
  		
  		
  		//Check the login status
  		if(session.getAttribute("email") == null)
  		{
  			response.sendRedirect("login.jsp");
  		}
  		
  		
  		
    
    	
    %>
    
     
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Awesome Care : Vehicle Service</title>
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
    
    <!-- Icons font CSS-->
    <link
      href="vendor/mdi-font/css/material-design-iconic-font.min.css"
      rel="stylesheet"
      media="all"
    />
    <link
      href="vendor/font-awesome-4.7/css/font-awesome.min.css"
      rel="stylesheet"
      media="all"
    />
    <!-- Font special for pages-->
    <link
      href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet"
    />

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all" />
    <link
      href="vendor/datepicker/daterangepicker.css"
      rel="stylesheet"
      media="all"
    />
    
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

    <main id="main">
      <div id="service-form-page">
        <div class="container">
          <header class="section-header">
            <div class="text-dark wow fadeInUp lead">
              <h3 class="text-dark">Awesome Care : Vehicle Service</h3>
              <p><b>
                This isn't some kind of normal service... This is the ULTIMATE
                service that a vehicle can have. Of course this is the best
                service in this country. We offer you Basic and Full vehicle
                services, so you can choose a service based on your choice. We
                guarantee the best result from both of those services. After our
                Basic Service your vehicle will looks like a brand new vehicle, and also
                after our Full Service your vehicle will be a brand new vehicle.
                Scroll down to find what we offer...
              </p>
              <p>
                Down there, there's a form to fill some details... You only need
                to fill that. After that hand over your vehicle to us and we
                will take care of that like a precious jewel. Give it a try...
              </b></p>
              <h3>What You get from our basic service...</h3>
              <ul
                class="list-group list-group-flush service-list-text lead text-center"
              >
                <li class="list-group-item">
                  A Complete Exterior Wash...
                  <span class="badge badge-dark">
                    Including all functions of our Wash Service
                  </span>
                </li>
                <li class="list-group-item">
                  Advanced Exterior Dust Cleaning...
                </li>
                <li class="list-group-item">
                  Advanced Glass Cleaning...
                </li>
                <li class="list-group-item">
                  All Lights Repair Service...
                  <span class="badge badge-dark">
                    Seasonal Offer
                  </span>
                </li>
                <li class="list-group-item">
                  A Complete Interior Clean with Advanced Dust Cleaning and much
                  much more...
                </li>
              </ul>
              <br /><br />

              <h3>What You get from our full service...</h3>
              <ul
                class="list-group list-group-flush service-list-text lead text-center"
              >
                <li class="list-group-item">
                  A Complete Exterior Wash...
                  <span class="badge badge-dark">
                    Including all functions of our Wash Service
                  </span>
                </li>
                <li class="list-group-item">
                  Advanced Exterior Dust Cleaning...
                </li>
                <li class="list-group-item">
                  Advanced Glass Cleaning...
                </li>
                <li class="list-group-item">
                  All Lights Repair Service...
                  <span class="badge badge-dark">
                    FREE
                  </span>
                </li>
                <li class="list-group-item">
                  A Complete Interior Clean with Advanced Dust Cleaning and much
                  much more...
                </li>
                <li class="list-group-item">
                  Fine Tuning...
                </li>
                <li class="list-group-item">
                  Oil Checking and much much more...
                </li>
              </ul>
              <br /><br />

              <h3>
                complete below form to make it happen
              </h3>

              <form action="bookingDetails.jsp" method="POST">
                <div class="form-group">
                  <h4>Service Type</h4>
                  <label for="name" class="mr-3">Select Service Type</label>
                  <select
                    id="txtTitle"
                    name="serviceType"
                    class="form-control selectpicker"
                  >
                    <option value="Basic">Basic Service</option>
                    <option value="Full">Full Service</option>
                  </select>
                  <br />
                  <h4>Customer Details</h4>
                  <label for="name" class="mr-3">Customer Name</label>
                  <input
                    type="text"
                    class="form-control mr-3"
                    value="<%out.print(customer.getfName() +" " +customer.getlName()); %>"
                    name="name"
                    required
                    readonly
                  />
                  <br />
                  <label for="tel" class="mr-3">Telephone Number</label>
                  <input
                    type="tel"
                    class="form-control"
                    value="<%out.print(customer.getPhone()); %>"
                    name="phone"
                    required
                    readonly
                  />
                  <br /><br />
                  <h4>Vehicle Details</h4>
                  <label for="vehicleType" class="mr-3"
                    >Select Your Vehicle</label
                  >
                  <select
                    id="txtTitle"
                    name="vehicle"
                    class="form-control"
                    required
                  >
                  
                  
                  <% 
                  row = 0;
                  for(Map.Entry<Integer, String> count : set1) { 
                  
                  %><option value="<%out.print(count.getKey());%>"> <%
                  	for(int col = 0; col < 3; col++){
                  
                    out.print(vehicle[row][col]); %>
                    
                  <%}row++;%></option><%} %>
                  
                  
                  </select>
                  <br /><br />
                  <h4>Booking Details</h4>

                  <div class="input-group calender">
                    <input
                      class="input--style-3 js-datepicker form-control"
                      type="text"
                      placeholder="Pick a comfortable day"
                      name="bookDate"
                    />                   
                    <i
                      class="zmdi zmdi-calendar-note input-icon js-btn-calendar"
                    ></i>
                    
                  </div>
                  <br />
                  <label for="bookTimeLabel" class="mr-3">Booking Time</label>
                  <select name="bookTime" class="form-control">
                    <option value="07:00">7.00 AM</option>
                    <option value="07:30">7.30 AM</option>
                    <option value="08:00">8.00 AM</option>
                    <option value="08:30">8.30 AM</option>
                    <option value="09:00">9.00 AM</option>
                    <option value="09:30">9.30 AM</option>
                    <option value="10:00">10.00 AM</option>
                    <option value="10:30">10.30 AM</option>
                    <option value="11:00">11.00 AM</option>
                    <option value="11:30">11.30 AM</option>
                    <option value="12:00">12.00 PM</option>
                    <option value="12:30">12.30 PM</option>
                    <option value="01:00">1.00 PM</option>
                    <option value="01:30">1.30 PM</option>
                    <option value="02:00">2.00 PM</option>
                    <option value="02:30">2.30 PM</option>
                    <option value="03:00">3.00 PM</option>
                    <option value="03:30">3.30 PM</option>
                    <option value="04:00">4.00 PM</option>
                    <option value="04:30">4.30 PM</option>
                    <option value="05:00">5.00 PM</option>
                    <option value="05:30">5.30 PM</option>
                    <option value="06:00">6.00 PM</option>
                    <option value="06:30">6.30 PM</option>
                    <option value="07:00">7.00 PM</option>
                    <option value="07:30">7.30 PM</option>
                    <option value="08:00">8.00 PM</option>
                    <option value="08:30">8.30 PM</option>
                    <option value="09:00">9.00 PM</option>
                    <option value="09:30">9.30 PM</option>
                    <option value="10:00">10.00 PM</option>
                  </select>
                  <small class="form-text text-muted"
                    >Service will take 30minutes to complete</small
                  >
                  <br />
                  <label for="bookBranch" class="mr-3">Branch</label>
                  <select name="branchSelect" class="form-control" required>
                    <option value="1">Malabe</option>
                    <option value="2">Maharagama</option>
                    <option value="3">Nugegoda</option>
                    <option value="4">Baththaramulla</option>
                    <option value="5">Kollupitiya</option>
                    <option value="6">Kandy</option>
                    <option value="7">Galle</option>
                    <option value="8">Matara</option>
                  </select>
                  <br /><br />

                  <div class="form-inline">
                    <input type="reset" class="form-control" />
                    <input type="submit" class="form-control float-right" />
                  </div>
                </div>
              </form>
            </div>
          </header>
        </div>
      </div>
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
    
    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>
    
  </body>
</html>