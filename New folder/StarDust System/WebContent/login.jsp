<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>Login</title>
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

    <!-- Login Stylesheet File -->
    <link href="css/login.css" rel="stylesheet" />
    
    <script type="text/javascript">
    
    function urlReading(){
		var url_string = window.location.href;
		var url = new URL(url_string);
		var msg = url.searchParams.get("Login");
		
		if(msg != null)
			alert("Something went wrong : Try correct Email and Password");
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
            <li><a href="customerProfile.jsp"><%out.print(session.getAttribute("name")); %>'s Profile</a></li>
             <%}%>
            <li><a href="us.jsp">About Us</a></li>
            <li><a href="contact.jsp">Contact Us</a></li>
            <li><a href="bookService.jsp">Services</a></li>
            <%if(session.getAttribute("name") == null){%>
            <li class="menu-active"><a href="login.jsp">Login</a></li>
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
    <div class="login-body">
      <main id="main">

        <!-- Login  Form -->
        <div class="main">
          <section class="signup">
            <div class="container">
              <div class="signup-content">
                <form method="POST" id="signup-form" class="signup-form" action="Login">
                  <h3 class="text-dark text-center text-uppercase">Login to Browse More...</h3>
                  <br>
                  <div class="form-group">
                    <input
                      type="email"
                      class="form-input"
                      name="email"
                      id="email"
                      placeholder="Your Email"
                    />
                  </div>
                  <div class="form-group">
                    <input
                      type="password"
                      class="form-input"
                      name="password"
                      id="password"
                      placeholder="Password"
                    />
                    <span
                      toggle="#password"
                      class="zmdi zmdi-eye field-icon toggle-password"
                    ></span>
                  </div>
                  <div class="form-group">
                    <input
                      type="submit"
                      name="submit"
                      id="submit"
                      class="btn btn-dark w-100 mx-auto"
                      value="Login"
                    />
                  </div>
                </form>
                <p class="loginhere">
                  Don't have an account ?
                  <a href="signup.jsp" class="loginhere-link">Create here</a>
                </p>
              </div>
            </div>
          </section>
        </div>

        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>

        <!-- #Service Types -->
      </main>
    </div>

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
