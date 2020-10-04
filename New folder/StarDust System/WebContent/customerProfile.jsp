<%@ page import ="com.stardust.dao.CustomerDAO" import ="com.stardust.customer.Customer" import ="com.stardust.services.Service" import= "java.util.*" import="java.text.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    
  	//Secure Page. Need Login Credentials to access to this page	
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    
  		//Check the login status
		if(session.getAttribute("email") == null)
		{
			response.sendRedirect("login.jsp");
		}
    
  		//Create a Customer Class Object
  		Customer customer = Customer.getInstance();
  		
  		//Create a Service Class Object
  		Service service = Service.getInstance();
      
    	//Create a CustomerDAO Class Object
    	CustomerDAO dao = new CustomerDAO();
    		
    	//Set Email
    	dao.setEmail((String)session.getAttribute("email"));
    		
    	//Get data From the Database
    	dao.assignData();
    		
    	//Load Data
    	customer = dao.getData();
    	
    	//Load Service Data
    	dao.assignServiceDetails();
    	
    	//Get Service Details
    	service = dao.getServiceDetails();
    	
    	//Assigning Values to the Session
    	session.setAttribute("customerID", customer.getCustomerID());
    	session.setAttribute("name", customer.getfName());
    		
    	//HashMap Set of Customer Class
    	HashMap <Integer, String> vehicleType = new HashMap <Integer, String>();
    	vehicleType.putAll(customer.getVehicleType());
    		
    	HashMap <Integer, String> vehicleBrand = new HashMap <Integer, String>();
    	vehicleBrand.putAll(customer.getVehicleBrand());
    		
    	HashMap <Integer, String> vehicleModel = new HashMap <Integer, String>();
    	vehicleModel.putAll(customer.getVehicleModel());
    	
    	HashMap <Integer, String> lastService = new HashMap <Integer, String>();
    	lastService.putAll(customer.getLastService());
    		
    	HashMap <Integer, String> engineNumber = new HashMap <Integer, String>();
    	engineNumber.putAll(customer.getEngineNumber());
    		
    	HashMap <Integer, String> engineCapacity = new HashMap <Integer, String>();
    	engineCapacity.putAll(customer.getEngineCapacity());
    	
    	HashMap <Integer, String> wheelSize = new HashMap <Integer, String>();
    	wheelSize.putAll(customer.getWheelSize());
    		
    	HashMap <Integer, Float> fuelCapacity = new HashMap <Integer, Float>();
    	fuelCapacity.putAll(customer.getFuelCapacity());
    	
    	
    	
    	//HashMap Set of Customer Class
    	HashMap <Integer, String> serviceType = new HashMap <Integer, String>();
    	serviceType.putAll(service.getServiceType());
    		
    	HashMap <Integer, String> bookDate = new HashMap <Integer, String>();
    	bookDate.putAll(service.getBookDate());
    		
    	HashMap <Integer, String> bookTime = new HashMap <Integer, String>();
    	bookTime.putAll(service.getBookTime());
    	
    	HashMap <Integer, String> requestDate = new HashMap <Integer, String>();
    	requestDate.putAll(service.getRequestDate());
    		
    	HashMap <Integer, Integer> vehicleServiceID = new HashMap <Integer, Integer>();
    	vehicleServiceID.putAll(service.getVehicleID());
    		
    	HashMap <Integer, Integer> branchServiceID = new HashMap <Integer, Integer>();
    	branchServiceID.putAll(service.getBranchID());
    	
    	
    	
    		
    	//Create an Entry Set of Customer Class
    	Set<Map.Entry<Integer, String>> set1 = vehicleType.entrySet();
    	Set<Map.Entry<Integer, String>> set2 = vehicleBrand.entrySet();
    	Set<Map.Entry<Integer, String>> set3 = vehicleModel.entrySet();
    	Set<Map.Entry<Integer, String>> set4 = lastService.entrySet();
    	Set<Map.Entry<Integer, String>> set5 = engineNumber.entrySet();
    	Set<Map.Entry<Integer, String>> set6 = engineCapacity.entrySet();
    	Set<Map.Entry<Integer, String>> set7 = wheelSize.entrySet();
    	Set<Map.Entry<Integer, Float>> set8 = fuelCapacity.entrySet();
    	
    	
    	
    	//Create an Entry Set of Service Class
    	Set<Map.Entry<Integer, String>> set10 = serviceType.entrySet();
    	Set<Map.Entry<Integer, String>> set11 = bookDate.entrySet();
    	Set<Map.Entry<Integer, String>> set12 = bookTime.entrySet();
    	Set<Map.Entry<Integer, String>> set13 = requestDate.entrySet();
    	Set<Map.Entry<Integer, Integer>> set14 = vehicleServiceID.entrySet();
    	Set<Map.Entry<Integer, Integer>> set15 = branchServiceID.entrySet();
    	
    	
    		
    	int row = 0;
    	
    	//Load Data
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
    	
    	//Create a two dimentional array to store Vehicle Details
    	String vehicle[][] = new String[5][8];
		
    	//Storing values in the Array
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
    	
    	row = 0;
    	
    	for(Map.Entry<Integer, String> count : set4)
    	{
    		vehicle[row][3] = count.getValue();
    		row++;
    	}
    		
    	row = 0;
    		
    	for(Map.Entry<Integer, String> count : set5)
    	{
    		vehicle[row][4] = count.getValue();
    		row++;
    	}
    		
    	row = 0;
    		
    	for(Map.Entry<Integer, String> count : set6)
    	{
    		vehicle[row][5] = count.getValue();
    		row++;
    	}
    	
    	row = 0;
    	
    	for(Map.Entry<Integer, String> count : set7)
    	{
    		vehicle[row][6] = count.getValue();
    		row++;
    	}
    		
    	row = 0;
    		
    	for(Map.Entry<Integer, Float> count : set8)
    	{
    		vehicle[row][7] = Float.toString(count.getValue());
    		row++;
    	}
    	
    	
    	
    	//Saving Service Details in an Array
    	//Create a two dimentional array to store Service Details
    	String serviceData[][] = new String[100][6];
		
    	//Storing values in the Array
    	
    	row = 0; 
    	
    	for(Map.Entry<Integer, String> count : set10)
    	{
    		serviceData[row][0] = count.getValue();
    		row++;
    	}
    	
		row = 0; 
    	
    	for(Map.Entry<Integer, String> count : set11)
    	{
    		serviceData[row][1] = count.getValue();
    		row++;
    	}
    	
		row = 0; 
    	
    	for(Map.Entry<Integer, String> count : set12)
    	{
    		serviceData[row][2] = count.getValue();
    		row++;
    	}
    	
		row = 0; 
    	
    	for(Map.Entry<Integer, String> count : set13)
    	{
    		serviceData[row][3] = count.getValue();
    		row++;
    	}
    	
		row = 0; 
    	
    	for(Map.Entry<Integer, Integer> count : set14)
    	{
    		serviceData[row][4] = Integer.toString(count.getValue());
    		row++;
    	}
    	
		row = 0; 
    	
    	for(Map.Entry<Integer, Integer> count : set15)
    	{
    		
    		if(count.getValue()==1)
    		{
    			serviceData[row][5] = "Malabe";
    		}
    		
    		else if(count.getValue()==2)
    		{
    			serviceData[row][5] = "Maharagama";
    		}
    		
    		else if(count.getValue()==3)
    		{
    			serviceData[row][5] = "Nugegoda";
    		}

    		else if(count.getValue()==4)
    		{
    			serviceData[row][5] = "Baththaramulla";
    		}

    		else if(count.getValue()==5)
    		{
    			serviceData[row][5] = "Kollupitiya";
    		}

    		else if(count.getValue()==6)
    		{
    			serviceData[row][5] = "Kandy";
    		}

    		else if(count.getValue()==7)
    		{
    			serviceData[row][5] = "Galle";
    		}

    		else
    		{
    			serviceData[row][5] = "Matara";
    		}	
    		
    		row++;
    	}
    	
    %>
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
	<title><%out.print(customer.getfName() +" " +customer.getlName()); %></title>
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
    
    <script>
    function checkCurrentPassword(){
    	var cPass = document.getElementById("currentPass").value;
    	var dbPass = document.getElementById("dbPassword").value;
    	var newPass = document.getElementById("newPass").value;
    	var newPassCon = document.getElementById("newPassConfirm").value;
    	
    	if(cPass != dbPass){
    		document.getElementById("currentPass").classList.add("is-invalid");
    	}
    	
    	else{
    		if(document.getElementById("currentPass").classList.contains("is-invalid")){
    			document.getElementById("currentPass").classList.remove("is-invalid");
    			document.getElementById("currentPass").classList.add("is-valid");
    		}
    		
    		if(newPass != newPassCon){
    			alert("New Password doesn't match with the Confirm New Password");
    		}
    		
    		else{
    			document.getElementById("changePasswordForm").submit();    		}
    	}
    }
    
    function urlReading(){
		var url_string = window.location.href;
		var url = new URL(url_string);
		var msg = url.searchParams.get("Request");
		
		if(msg == null)
		{
			document.getElementById("updatePasswordAlert").style.display="none";
			document.getElementById("updateDetailsAlert").style.display="none";
			document.getElementById("vehicleAddedAlert").style.display="none";
			document.getElementById("vehicleDeletedAlert").style.display="none";
			document.getElementById("serviceAddedAlert").style.display="none";
			document.getElementById("accountCreated").style.display="none";
		}
		
		else if(msg == "UpdatePassword-Success")
		{
			document.getElementById("updatePasswordAlert").style.display="block";
			document.getElementById("updateDetailsAlert").style.display="none";
			document.getElementById("vehicleAddedAlert").style.display="none";
			document.getElementById("vehicleDeletedAlert").style.display="none";
			document.getElementById("serviceAddedAlert").style.display="none";
			document.getElementById("accountCreated").style.display="none";
		}
		
		else if(msg == "ChangeDetails-Success")
		{
			document.getElementById("updateDetailsAlert").style.display="block";
			document.getElementById("updatePasswordAlert").style.display="none";
			document.getElementById("vehicleAddedAlert").style.display="none";
			document.getElementById("vehicleDeletedAlert").style.display="none";
			document.getElementById("serviceAddedAlert").style.display="none";
			document.getElementById("accountCreated").style.display="none";
		}
		
		else if(msg == "Vehicle-Added")
		{
			document.getElementById("vehicleAddedAlert").style.display="block";
			document.getElementById("updatePasswordAlert").style.display="none";
			document.getElementById("updateDetailsAlert").style.display="none";
			document.getElementById("vehicleDeletedAlert").style.display="none";
			document.getElementById("serviceAddedAlert").style.display="none";
			document.getElementById("accountCreated").style.display="none";
		}
		
		else if(msg == "Vehicle-Deleted")
		{
			document.getElementById("vehicleDeletedAlert").style.display="block";
			document.getElementById("updatePasswordAlert").style.display="none";
			document.getElementById("updateDetailsAlert").style.display="none";
			document.getElementById("vehicleAddedAlert").style.display="none";
			document.getElementById("serviceAddedAlert").style.display="none";
			document.getElementById("accountCreated").style.display="none";
		}
		
		else if(msg == "Service-Added")
		{
			document.getElementById("serviceAddedAlert").style.display="block";
			document.getElementById("updatePasswordAlert").style.display="none";
			document.getElementById("updateDetailsAlert").style.display="none";
			document.getElementById("vehicleAddedAlert").style.display="none";
			document.getElementById("vehicleDeletedAlert").style.display="none";
			document.getElementById("accountCreated").style.display="none";
		}
		
		else if(msg == "Account-Created")
		{
			document.getElementById("accountCreated").style.display="block";
			document.getElementById("updatePasswordAlert").style.display="none";
			document.getElementById("updateDetailsAlert").style.display="none";
			document.getElementById("vehicleAddedAlert").style.display="none";
			document.getElementById("vehicleDeletedAlert").style.display="none";
			document.getElementById("serviceAddedAlert").style.display="none";
		}
			
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
            <li><a href="index.jsp">Home</a></li>
            <%if(session.getAttribute("name") != null){%>
            <li class="menu-active"><a href="customerProfile.jsp"><%out.print(session.getAttribute("name")); %>'s Profile</a></li>
             <%}%>
            <li><a href="us.jsp">About Us</a></li>
            <li><a href="contact.jsp">Contact Us</a></li>
            <li><a href="bookService.jsp">Services</a></li>
            <%if(session.getAttribute("name") == null){%>
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
            <h3>Welcome <%out.print(customer.getfName() +" " +customer.getlName()); %>...</h3>
            <br>
            <h4 class="text-center text-dark">
              "Your happiness and security is our pleasure"
            </h4>
            <br>
            <p>
              This is your profile... Manage it as you want...
            </p>
          </header>
          
          
			<!--Message Section -->
			<div id="updatePasswordAlert" class="alert alert-success alert-dismissible">
				<button class="close" type="button" data-dismiss="alert">
					<span>&times;</span>
				</button>
				Your Password Updated Successfully
			</div>
			
			<div id="updateDetailsAlert" class="alert alert-success alert-dismissible">
				<button class="close" type="button" data-dismiss="alert">
					<span>&times;</span>
				</button>
				Your Details Updated Successfully
			</div>
			
			<div id="vehicleAddedAlert" class="alert alert-success alert-dismissible">
				<button class="close" type="button" data-dismiss="alert">
					<span>&times;</span>
				</button>
				Your New Vehicle Added Successfully
			</div>
			
			<div id="vehicleDeletedAlert" class="alert alert-danger alert-dismissible">
				<button class="close" type="button" data-dismiss="alert">
					<span>&times;</span>
				</button>
				Your Vehicle Deleted
			</div>
			
			<div id="serviceAddedAlert" class="alert alert-success alert-dismissible">
				<button class="close" type="button" data-dismiss="alert">
					<span>&times;</span>
				</button>
				Thank You! Your Requested Service Added Successfully!
			</div>
			
			<div id="accountCreated" class="alert alert-success">
				<h4 class="alert-heading">Greetings <%=session.getAttribute("name") %>!</h4>
				<p class="text-dark">Your account created successfully! Let's Start our working by <strong>Adding a Vehicle to Your Account</strong>. 
				Click <strong>Add a Vehicle</strong> button to add a new Vehicle. Provide correct details to ensure the best service from us.
				We will be always here to help you! Hope to see you around! Have a great day!</p>
			</div>

          
          
          
          
          
          

          <div class="card bg-dark text-white mb-5">
            <div class="card-header">Your Details</div>
            <div class="card-body">
              <h4 class="card-title"><%out.print(customer.getfName() +" " +customer.getlName()); %></h4>
              <p class="card-text">
                Phone Number : <%out.print(customer.getPhone());%> <br />
                Address : <%out.print(customer.getAddressLine1() +", " +customer.getAddressLine2() +", " +customer.getAddressLine3()); %>
              </p>
              <h4 class="card-title">Vehicle Details</h4>
              <p class="card-text">
              
              <table class="table text-center">
                  <thead>
                    <tr>
                      <th>Vehicle Number</th>
                      <th>Vehicle Type</th>
                      <th>Brand Name</th>
                      <th>Model Name</th>
                      <th>Last Service Date</th>
                      <th>Engine Number</th>
                      <th>Engine Capacity</th>
                      <th>Wheel Size</th>
                      <th>Fuel Capacity</th>
                    </tr>
                  </thead>
                  <tbody>
                  
                  <!-- Display Vehicle Details -->
                  
                  <% 
                  row = 0;
                  for(Map.Entry<Integer, String> count : set1) { 
                	 
                  %>
                  
                    <tr>
                    	<td>Vehicle <%out.print(row+1); %></td>
                    <%for(int col = 0; col < 8; col++){ 
                    	if(vehicle[row][col]==null)
                    	{
                    %>
                      			<td>No Results</td>
                      			
                     <%}
                    	
                  		else{                  				
                  		%>
                  				<td><%out.print(vehicle[row][col]); %></td>
                  		<%}
                    	
                    
                  	}
                  	
                  	row++;
                  	%>
                  	
                  	</tr>
                  	
                  	<%
                 	} 
                 
                 	%>
                    
                  </tbody>
                </table>               
              </p>
              <div class="card-footer text-center">
                <button
                  class="btn btn-success mr-3 w-18"
                  data-toggle="modal"
                  data-target="#passwordModal"
                >
                  Change Password
                </button>
                <button
                  class="btn btn-success mr-3 w-18"
                  data-toggle="modal"
                  data-target="#detailsModal"
                >
                  Change My Details
                </button>
                <button
                  class="btn btn-success mr-3 w-18"
                  data-toggle="modal"
                  data-target="#addVehicleModal"
                >
                  Add a Vehicle
                </button>
                <button
                  class="btn btn-success mr-3 w-18"
                  data-toggle="modal"
                  data-target="#deleteVehicleModal"
                >
                  Delete a Vehicle
                </button>
                <button
                  class="btn btn-success w-18"
                  data-toggle="modal"
                  data-target="#deleteAccountModal"
                >
                  Delete My Account
                </button>
              </div>
            </div>
          </div>
          
          
          <div class="card bg-dark text-white">
            <div class="card-body">
              <h4 class="card-title">Service Details</h4>
              <p class="card-text">
              
              <table class="table text-center">
                  <thead>
                    <tr>
                      <th>Service Number</th>
                      <th>Service Type</th>
                      <th>Scheduled Date</th>
                      <th>Scheduled Time</th>
                      <th>Requested Date</th>
                      <th>Vehicle</th>
                      <th>Branch</th>
                    </tr>
                  </thead>
                  <tbody>
                  
                  <!-- Display Service Details -->
                  
                  <% 
                  row = 0;
                  for(Map.Entry<Integer, String> count : set10) { 
                	 
                  %>
                  
                    <tr>
                    	<td>Service <%out.print(row+1); %></td>
                    <%for(int col = 0; col < 6; col++){ 
                    	if(serviceData[row][col]==null)
                    	{
                    %>
                      			<td>No Results</td>
                      			
                     <%}
                    	
                  		else{                  				
                  		%>
                  				<td><%
                  				
                  						if(col==4)
                  						{
                  							int vID = Integer.parseInt(serviceData[row][col]);
                  							
                  							for(Map.Entry<Integer, String> count1 : set1)
                                	  		{
                                	  			if(count1.getKey()== vID)
                                	  			{
                                	  				for(Map.Entry<Integer, String> count2 : set2)
                                	  				{
                                	  					if(count2.getKey()== vID)
                                	  					{
                                	  						for(Map.Entry<Integer, String> count3 : set3)
                                	  						{
                                	  							if(count3.getKey()== vID)
                                	  							{
                                	  								out.print(count1.getValue() +" " +count2.getValue() +" " +count3.getValue());
                                	  							}
                                	  						}
                                	  					}
                                	  				}
                                	  			}
                                	  		}
                  						}
                  				
                  						else
                  						{
                  							out.print(serviceData[row][col]); }%></td>
                  						
                  		<%}
                    	
                    
                  	}
                  	
                  	row++;
                  	%>
                  	
                  	</tr>
                  	
                  	<%
                 	} 
                 
                 	%>
                    
                  </tbody>
                </table>               
              </p>
              <div class="card-footer text-center">
                <button
                  class="btn btn-success btn-block"
                  onclick="location.href='bookService.jsp';"
                >
                  Book a Service
                </button>
              </div>
            </div>
          </div>
          
          
        </div>
      </section>
      <!-- #Service Types -->
    </main>

    <!--====================================================
      
                            Modal
    
    =======================================================-->

    <!--Change Password Modal-->
    <div class="modal" id="passwordModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Change Password</h5>
            <button class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <form action="ChangePassword" method="POST" id="changePasswordForm">
              <div class="form-group">
                <input
                  type="password"
                  class="form-control mb-2"
                  placeholder="Current Password"
                  name="passwordCurrent"
                  id="currentPass"
                  required                
                />
                <input
                  type="hidden"
                  class="form-control mb-2"
                  placeholder=""
                  name="xyz"
                  value = "<%out.print(session.getAttribute("password")); %>"
                  id="dbPassword"
                  required                
                />
                <div class="invalid-feedback">Password is incorrect</div>
                
                <input
                  type="password"
                  class="form-control mb-2"
                  placeholder="New Password"
                  name="passwordNew"
                  id="newPass"
                  required
                />
                
                <input
                  type="password"
                  class="form-control mb-2"
                  placeholder="Confirm New Password"
                  name="passwordNewConfirm"
                  id="newPassConfirm"
                  required
                />
                <input
                  type="button"
                  class="btn btn-dark"
                  value="Change Password"
                  onclick="checkCurrentPassword()"
                />
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!--Change Details Modal-->
    <div class="modal" id="detailsModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Change Details</h5>
            <button class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <form action="ChangeDetails" method="POST">
              <div class="form-group">
                <input
                  type="text"
                  class="form-control mb-2"
                  value="<%=customer.getfName() %>"
                  name="fName"
                  required
                />
                <input
                  type="text"
                  class="form-control mb-2"
                  value="<%=customer.getlName() %>"
                  name="lName"
                  required
                />
                <input
                  type="tel"
                  class="form-control mb-2"
                  value="<%=customer.getPhone() %>"
                  name="phone"
                  required
                />
                <input
                  type="text"
                  class="form-control mb-2"
                  value="<%=customer.getAddressLine1() %>"
                  name="address1"
                  required
                />
                <input
                  type="text"
                  class="form-control mb-2"
                  value="<%=customer.getAddressLine2() %>"
                  name="address2"
                  required
                />
                <input
                  type="text"
                  class="form-control mb-2"
                  value="<%=customer.getAddressLine3() %>"
                  name="address3"
                  required
                />
                <input
                  type="submit"
                  class="btn btn-dark"
                  value="Change Details"
                />
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!--Add Vehicle Modal-->
    <div class="modal" id="addVehicleModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Add a Vehicle</h5>
            <button class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <form action="AddVehicle" method="POST">
              <div class="form-group">
                <select name="vehicleType" class="form-control mb-2" required>
                  <option value="" selected>Select Your Vehicle type</option>
                  <option value="Car">Car</option>
                  <option value="Van">Van</option>
                  <option value="Bus">Bus</option>
                  <option value="Lorry">Lorry</option>
                  <option value="Motor Cycle">Motor Cycle</option>
                  <option value="Three Wheel">Three Wheel</option>
                </select>
                <input
                  type="text"
                  class="form-control mb-2"
                  placeholder="Vehicle Brand"
                  name="vehicleBrand"
                  required
                />
                <input
                  type="text"
                  class="form-control mb-2"
                  placeholder="Vehicle Model"
                  name="vehicleModel"
                  required
                />
                <input
                  type="text"
                  class="form-control mb-2"
                  placeholder="Engine Number"
                  name="engineNumber"
                  required
                />
                <input
                  type="text"
                  class="form-control mb-2"
                  placeholder="Engine Capacity"
                  name="engineCapacity"
                  required
                />
                <input
                  type="text"
                  class="form-control mb-2"
                  placeholder="Wheel Size"
                  name="wheelSize"
                />
                <input
                  type="text"
                  class="form-control mb-2"
                  placeholder="Fuel Capacity"
                  name="fuelCapacity"
                  required
                />
                <input type="submit" class="btn btn-dark" value="Add Vehicle" />
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!--Delete Vehicle Modal-->
    <div class="modal" id="deleteVehicleModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Delete a Vehicle</h5>
            <button class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <form action="DeleteVehicle" method="POST">
              <div class="form-group">
                <select name="vehicleID" class="form-control mb-2" required>
                  <option value="" selected>Select Your Vehicle</option>
				<% row = 0;
                  for(Map.Entry<Integer, String> count : set1) { 
                	 
                  %>
                    	<Option value="<%out.print(count.getKey()); %>">
                    	
                    <%for(int col = 0; col < 3; col++){ 
                    	if(vehicle[row][col]==null)
                    	{
                    %>
                      			No Results</option>
                      			
                     <%}
                  		else{                  				
                  		%>
                  				<%out.print(vehicle[row][col] +" "); %>
                  		<%}                                    
                  	}                  	
                  	row++;
                  	%>
                  	</option>                	
                  	<%
                 	}                  
                 	%>
                </select>
                <input
                  type="submit"
                  class="btn btn-dark"
                  value="Delete Vehicle"
                />
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <!--Delete Account Modal-->
    <div class="modal" id="deleteAccountModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">Delete My Account</h5>
            <button class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <form action="DeleteCustomer" method="POST">
              <div class="form-group">
                <label for="">Are you Sure about this?</label>
                <input
                  type="submit"
                  class="btn btn-dark btn-block"
                  value="Delete Account"
                />
              </div>
            </form>
          </div>
        </div>
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