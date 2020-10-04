<%@page import="com.stardust.web.model.Customer" %>
<%@page import="com.stardust.web.model.Services" %>
<%@page import="com.stardust.web.model.Contacts" %>
<%@page import="com.stardust.web.dao.CustomerDao" %>
<%@page import="com.stardust.web.dao.ServicesDao" %>
<%@page import="com.stardust.web.dao.ContactDao" %>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    //Secure Page. Need Login Credentials to access to this page	
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    
    %>
    
    
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Admin Panel</title>
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

    <!-- Font Icon -->
    <link
      rel="stylesheet"
      href="fonts/material-icon/css/material-design-iconic-font.min.css"
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

  <body id="adminPage">
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
            <%if(session.getAttribute("user") == "Admin"){%>
            <li class="menu-active"><a href="Admin.jsp">Admin Panel</a></li>
             <%}%>
            <li><a href="us.jsp">About Us</a></li>
            <li><a href="contact.jsp">Contact Us</a></li>
            <li><a href="bookService.jsp">Services</a></li>
            <li><a href="Logout">Logout</a></li>
          </ul>
        </nav>
        <!-- #nav-menu-container -->
      </div>
    </header>
    <!-- #header -->
 <%
 CustomerDao dao = new CustomerDao();
 List<Customer> userList = CustomerDao.getAllUsers();

 ServicesDao dao1 = new ServicesDao();
 List<Services> serveList = ServicesDao.getServices();

 ContactDao dao2 = new ContactDao();
 List<Contacts> regList = ContactDao.getreg();
 
 ContactDao dao3 = new ContactDao();
 List<Contacts> nonList = ContactDao.nonreg();
 %>


<div class="card mt-5 mx-auto" style="width: 100%;">
<div class="card-header">StarDust Vehicle Care : Administration Control Panel</div>
<div class="card-body">
<h4 class="card-title">Manage Users</h4>
<div class="card-text">

<div class="mx-auto text-center">
	<table class="table table-striped table-responsive">
	<thead class="thead-dark">
	<tr>
	<th>ID</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Phone Number</th>
	<th>Email</th>
	<th>NIC</th>
	<th>Address Line 1</th>
	<th>Address Line 2</th>
	<th>Address Line 3</th>
	<th>Operations</th>
	<th>Operations</th>
	
	</tr>
	</thead>
	<tbody>


<tr>
 
 <%
 for (Customer user : userList) {
 %>
<td><%=user.getCustomerID()%></td>
<td id="<%=user.getCustomerID()%>-fname"><%=user.getfName()%></td>
<td id="<%=user.getCustomerID()%>-lname"><%=user.getlName()%></td>
<td id="<%=user.getCustomerID()%>-phone"><%=user.getPhone()%></td>
<td id="<%=user.getCustomerID()%>-email"><%=user.getEmail()%></td>
<td id="<%=user.getCustomerID()%>-nic"><%=user.getNIC()%></td>
<td id="<%=user.getCustomerID()%>-ad1"><%=user.getAddressLine1()%></td>
<td id="<%=user.getCustomerID()%>-ad2"><%=user.getAddressLine2()%></td>
<td id="<%=user.getCustomerID()%>-ad3"><%=user.getAddressLine3()%></td>
 <td>
 <button class="btn btn-primary edit" data-id="<%=user.getCustomerID()%>">Edit</button>
 <button class="btn btn-info submit" id="<%=user.getCustomerID()%>-submit" data-id="<%=user.getCustomerID()%>">Submit</button>
 </td>
<td><a
href="GetUsersController?action=delete&userId=<%=user.getCustomerID()%>"onclick="return confirm('Confirm to remove user?')"><button class="btn btn-danger">Delete</button></a></td>
</tr>
<%
}
%>
</tbody>
</table>
</div>
</div>
</div>
</div>

<div class="card mt-5 mx-auto" style="width: 100%;">
<div class="card-body">
<h4 class="card-title">Current Service List</h4>
<div class="card-text">

<div class="mx-auto text-center">
	<table class="table table-striped table-responsive">
	<thead class="thead-dark">
	<tr>
	<th>Service ID</th>
	<th>Service Type</th>
	<th>Booked Date</th>
	<th>Booked Time</th>
	<th>Request Date</th>
	<th>Amount</th>
	<th>Customer ID</th>
	<th>Vehicle ID</th>
	<th>Branch ID</th>
	<th>Operations</th>
	
	</tr>
	</thead>
	<tbody>


<tr>
 
 <%
 for (Services service : serveList) {
 %>
<td><%=service.getServiceID()%></td>
<td><%=service.getServiceType()%></td>
<td><%=service.getBookDate()%></td>
<td><%=service.getBookTime()%></td>
<td><%=service.getRequestDate()%></td>
<td><%=service.getAmount()%></td>
<td><%=service.getCustomerID()%></td>
<td><%=service.getVehicleID()%></td>
<td><%=service.getBranchID()%></td>
<td><a
href="GetUsersController?action=serdelete&userId=<%=service.getServiceID()%>"onclick="return confirm('Confirm to remove the Service?')"><button class="btn btn-danger">Delete</button></a></td>
</tr>
<%
}
%>
</tbody>
</table>
</div>
</div>
</div>
</div>

<div class="card mt-5 mx-auto" style="width: 100%;">
<div class="card-body">
<h4 class="card-title">Registered Member Messages</h4>
<div class="card-text">

<div class="mx-auto">
	<table class="table table-striped table-responsive">
	<thead class="thead-dark">
	<tr>
	<th>Message ID</th>
	<th>ID</th>
	<th>Name</th>
	<th>Email</th>
	<th>Phone</th>
	<th>Message</th>
	
	</tr>
	</thead>
	<tbody>


<tr>
 
 <%
 for (Contacts regis : regList) {
 %>
<td><%=regis.getRegContactID()%></td>
<td><%=regis.getRegCustomerID()%></td>
<td><%=regis.getRegName()%></td>
<td><%=regis.getRegEmail()%></td>
<td><%=regis.getRegPhone()%></td>
<td><%=regis.getRegMessage()%></td>
</tr>
<%
}
%>
</tbody>
</table>
</div>
</div>

<h4 class="card-title">Non-Registered Member Messages</h4>
<div class="card-text">

<div class="mx-auto">
	<table class="table table-striped table-responsive">
	<thead class="thead-dark">
	<tr>
	<th>Message ID</th>
	<th>Name</th>
	<th>Email</th>
	<th>Phone</th>
	<th>Message</th>
	
	</tr>
	</thead>
	<tbody>


<tr>
 
 <%
 for (Contacts noreg : nonList) {
 %>
<td><%=noreg.getNonContactID()%></td>
<td><%=noreg.getNonName()%></td>
<td><%=noreg.getNonEmail()%></td>
<td><%=noreg.getNonPhone()%></td>
<td><%=noreg.getNonMessage()%></td>
</tr>
<%
}
%>
</tbody>
</table>
</div>
</div>


</div>
</div>

</body>
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$('.submit').hide();
	$('.edit').on('click',function(){
		var id = $(this).data('id');
		$(this).hide();
		$('#'+id+'-submit').show();
		var fname = document.getElementById(id+'-fname').innerHTML;
		document.getElementById(id+'-fname').innerHTML = '<input type="text" id="'+id+'-edited-fname" value="'+fname+'" />';
		
		var lname = document.getElementById(id+'-lname').innerHTML;
		document.getElementById(id+'-lname').innerHTML = '<input type="text" id="'+id+'-edited-lname" value="'+lname+'" />';
		
		var phone = document.getElementById(id+'-phone').innerHTML;
		document.getElementById(id+'-phone').innerHTML = '<input type="text" id="'+id+'-edited-phone" value="'+phone+'" />';
		
		var email = document.getElementById(id+'-email').innerHTML;
		document.getElementById(id+'-email').innerHTML = '<input type="text" id="'+id+'-edited-email" value="'+email+'" />';
		
		var nic = document.getElementById(id+'-nic').innerHTML;
		document.getElementById(id+'-nic').innerHTML = '<input type="text" id="'+id+'-edited-nic" value="'+nic+'" />';
		
		var ad1 = document.getElementById(id+'-ad1').innerHTML;
		document.getElementById(id+'-ad1').innerHTML = '<input type="text" id="'+id+'-edited-ad1" value="'+ad1+'" />';
		
		var ad2 = document.getElementById(id+'-ad2').innerHTML;
		document.getElementById(id+'-ad2').innerHTML = '<input type="text" id="'+id+'-edited-ad2" value="'+ad2+'" />';
		
		var ad3 = document.getElementById(id+'-ad3').innerHTML;
		document.getElementById(id+'-ad3').innerHTML = '<input type="text" id="'+id+'-edited-ad3" value="'+ad3+'" />';
	});
	$('.submit').on('click',function(){
		var id = $(this).data('id');
		var editedFname = document.getElementById(id+'-edited-fname').value;
		var editedLname = document.getElementById(id+'-edited-lname').value;
		var editedPhone = document.getElementById(id+'-edited-phone').value;
		var editedemail = document.getElementById(id+'-edited-email').value;
		var editedNic = document.getElementById(id+'-edited-nic').value;
		var editedAd1 = document.getElementById(id+'-edited-ad1').value;
		var editedAd2 = document.getElementById(id+'-edited-ad2').value;
		var editedAd3 = document.getElementById(id+'-edited-ad3').value;
		
		window.location.href = "GetUsersController?action=edit&userId="+id+"&firstName="+editedFname+"&lastName="+editedLname+"&phone="+editedPhone+"&email="+editedemail+"&nic="+editedNic+"&ad1="+editedAd1+"&ad2="+editedAd2+"&ad3="+editedAd3;
	});
});
</script>
</html>