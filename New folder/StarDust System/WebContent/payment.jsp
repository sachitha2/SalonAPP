<%@ page import ="com.stardust.dao.CustomerDAO" import= "java.util.*"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    
  	//Secure Page. Need Login Credentials to access to this page	
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    
	  	//Get Data from the Request
	    String serviceType = request.getParameter("service");
		String bookDate = request.getParameter("bookDate");
		String bookTime = request.getParameter("bookTime");
		int branch = Integer.parseInt(request.getParameter("branchID"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		int customerID = Integer.parseInt(request.getParameter("customerID"));
		int vehicle = Integer.parseInt(request.getParameter("vehicleID"));
		
		//Check the login status
  		if(session.getAttribute("email") == null)
  		{
  			response.sendRedirect("login.jsp");
  		}
    
    %>
    
    
    
<!DOCTYPE html>
<html>
<head>
  <title>Payment</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- Bootstrap CSS File -->
   <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<!--   <link rel="stylesheet" href="css/payment.css"> -->
  
  <!-- Favicons -->
    <link href="img/favicon.png" rel="icon" />

<!--   Main Stylesheet File -->
  <link href="css/payment.css" rel="stylesheet" />
</head>
<body>
  <main class="page payment-page">
    <section class="payment-form bg-dark dark">
      <div class="container">
        <div class="block-heading">
          <h2 class="text-success">Payment</h2>
          <p class="text-white">Complete following to make it happen...</p>
        </div>
        <form action="ServiceRegister" method="POST">
          <div class="products">
            <h3 class="title">Checkout</h3>
            <div class="item">
              <span class="price">Rs. <%=amount %>.00/=</span>
              <p class="item-name">Service Type : <%=serviceType %></p>
            </div>
            <div class="total">Total<span class="price">Rs. <%=amount%>.00/=</span></div>
          </div>
          <div class="card-details">
            <h3 class="title">Credit Card Details</h3>
            <div class="row">
              <div class="form-group col-sm-7">
                <label for="card-holder">Card Holder</label>
                <input id="card-holder" type="text" class="form-control" placeholder="Card Holder" aria-label="Card Holder" aria-describedby="basic-addon1" required>
              </div>
              <div class="form-group col-sm-5">
                <label for="">Expiration Date</label>
                <div class="input-group expiration-date">
                  <input type="text" class="form-control" placeholder="MM" aria-label="MM" aria-describedby="basic-addon1" required>
                  <span class="date-separator">/</span>
                  <input type="text" class="form-control" placeholder="YY" aria-label="YY" aria-describedby="basic-addon1" required>
                </div>
              </div>
              <div class="form-group col-sm-8">
                <label for="card-number">Card Number</label>
                <input id="card-number" type="text" class="form-control" placeholder="Card Number" aria-label="Card Holder" aria-describedby="basic-addon1" required>
              </div>
              <div class="form-group col-sm-4">
                <label for="cvc">CVC</label>
                <input id="cvc" type="text" class="form-control" placeholder="CVC" aria-label="Card Holder" aria-describedby="basic-addon1" required>
              </div>
              <div class="form-group col-sm-12">
              
              	<input type="hidden" value="<%=serviceType %>" name="serviceType">
              	<input type="hidden" value="<%=bookDate %>" name="bookDate">
              	<input type="hidden" value="<%=bookTime %>" name="bookTime">
              	<input type="hidden" value="<%=branch %>" name="branch">
              	<input type="hidden" value="<%=vehicle %>" name="vehicle">
              	<input type="hidden" value="<%=amount %>" name="amount">
              	<input type="hidden" value="<%=customerID %>" name="customerID">
              	
                <input type="submit" class="btn btn-success btn-block" value="Proceed" required>
              </div>
            </div>
          </div>
        </form>
      </div>
    </section>
  </main>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>