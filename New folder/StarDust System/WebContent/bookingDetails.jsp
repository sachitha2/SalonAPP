<%@ page import ="com.stardust.dao.CustomerDAO" import ="com.stardust.customer.Customer" import ="com.stardust.services.ServiceCharger" language="java" import= "java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%
    
  	//Secure Page. Need Login Credentials to access to this page	
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    
        //Get data from the form
        String serviceType = request.getParameter("serviceType");
    	String name = request.getParameter("name");
    	String phone = request.getParameter("phone");
    	int vehicle = Integer.parseInt(request.getParameter("vehicle"));
    	String bookDate = request.getParameter("bookDate");
    	String bookTime = request.getParameter("bookTime");
    	int branch;
    	
    	if(serviceType.equals("Mobile Repair"))
    	{
    		branch = 0;
    	}
    	
    	else
    	{
    		branch = Integer.parseInt(request.getParameter("branchSelect"));
    	}
    		
    	
    	//Get Customer ID from the Session
    	int customerID = (int)session.getAttribute("customerID");
    	
    	//Check the login status
    	if(session.getAttribute("email") == null)
    	{
    		response.sendRedirect("login.jsp");
    	}
    	    
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
    	    	
    	 //HashMap Set & Assign Values
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
    	
    	  //Create a Variable to Store Vehicle Type		
    	  String vType = "";
    	  
    	  //Find Vehicle Type & Store it in the Variable
    	  for(Map.Entry<Integer, String> count1 : set1)
          {
                if(count1.getKey()== vehicle)
                {
                	  	vType = count1.getValue();			
                }
          }
    	  	
    	  //Create an Object of the ServiceCharger Class
    	  ServiceCharger charger = new ServiceCharger();
    	  
    	  //Calculate the Amount
    	  int amount = charger.calculateAmount(serviceType, vType);
    	  
    %>
    
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
              <h3 class="text-dark">Booking Details</h3>

              <form action="payment.jsp" method="POST">
                <div class="form-group">
                  <label class="mr-3" for="service">Service Type</label>
                  <input
                    type="text"
                    class="form-control"
                    name="service"
                    value="<%=serviceType %>"
                    readonly
                  />
                  <br />
                  <label for="name" class="mr-3">Customer ID</label>
                  <input
                    type="text"
                    class="form-control mr-3"
                    name="customerID"
                    value="<%=customerID %>"
                    readonly
                  />
                  <br />
                  <label for="name" class="mr-3">Customer Name</label>
                  <input
                    type="text"
                    class="form-control mr-3"
                    value="<%=name %>"
                    readonly
                  />
                  <br />
                  <label for="tel" class="mr-3"
                    >Customer Telephone Number</label
                  >
                  <input
                    type="tel"
                    class="form-control"
                    name="phone"
                    value="<%=phone %>"
                    readonly
                  />
                  <br />
                  <input type="hidden" value="<%=vehicle %>" name="vehicleID">
                  <label for="vehicleType" class="mr-3">Vehicle</label>
                  <input
                    type="text"
                    class="form-control"
                    value="<%
                    
                    		for(Map.Entry<Integer, String> count1 : set1)
                	  		{
                	  			if(count1.getKey()== vehicle)
                	  			{
                	  				for(Map.Entry<Integer, String> count2 : set2)
                	  				{
                	  					if(count2.getKey()== vehicle)
                	  					{
                	  						for(Map.Entry<Integer, String> count3 : set3)
                	  						{
                	  							if(count3.getKey()== vehicle)
                	  							{
                	  								out.print(count1.getValue() +" " +count2.getValue() +" " +count3.getValue());
                	  							}
                	  						}
                	  					}
                	  				}
                	  			}
                	  		}
                    
                    %>"
                    readonly
                  />
                  <br />
                  <label for="bookDate" class="mr-3">Booking Date</label>
                  <input
                    type="text"
                    class="form-control"
                    name="bookDate"
                    value="<%=bookDate %>"
                    readonly
                  />
                  <br />
                  <label for="bookTime" class="mr-3">Booking Time</label>
                  <input
                    type="text"
                    class="form-control"
                    name="bookTime"
                    value="<%=bookTime %>"
                    readonly
                  />
                  <br />
                  <input type="hidden" name="branchID" value="<%=branch %>">
                  <label for="bookBranch" class="mr-3">Branch</label>
                  <input
                    type="text"
                    class="form-control"
                    value="<%
                    
                    		if(branch == 1)
                    		{
                    			out.print("Malabe");
                    		}
                  
                    		else if(branch == 2)
		          			{
		          				out.print("Maharagama");
		          			}
		                  	
                    		else if(branch == 3)
                    		{
                    			out.print("Nugegoda");
                    		}
                  
                    		else if(branch == 4)
		          			{
		          				out.print("Baththaramulla");
		          			}
		                  	
                    		else if(branch == 5)
                    		{
                    			out.print("Kollupitiya");
                    		}
                  
                    		else if(branch == 6)
		          			{
		          				out.print("Kandy");
		          			}
		                  	
                    		else if(branch == 7)
                    		{
                    			out.print("Galle");
                    		}
                  
                    		else
		          			{
		          				out.print("Matara");
		          			}
                    
                    
                    %>"
                    readonly
                  />
                  <br />
                  <label for="amount" class="mr-3">Amount</label>
                  <input type="hidden" value="<%=amount %>" name="amount">
                  <input
                    type="text"
                    class="form-control"
                    value="Rs. <%=amount %>.00/="
                    readonly
                  />
                  <br /><br />

                  <div class="form-check">
                    <label for="agree" class="form-check-label">
                      <input
                        type="checkbox"
                        class="form-check-input"
                        required
                      />By clicking this I agree to StarDust's
                      <a href="#">Terms of Service</a>, as well as I follow the
                      terms and regulations.
                    </label>
                  </div>
                  <br />

                  <div class="form-inline">
                    
                    <input
                      type="submit"
                      class="form-control mx-auto"
                      value="Submit & Pay"
                    />
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
  </body>
</html>
