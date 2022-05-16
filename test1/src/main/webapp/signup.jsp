<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>SE-DTEAM</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <style>
            .main {
                width: 400px;
                height: 500px;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                border: 1px solid lightgrey;
                border-radius: 5px;
                margin-left: 450px;
                background-color: white;
            }

            .logo {
                margin-top: 0px;
                margin-bottom: 40px;
            }

            #login {
                width: 100%;
                background-color: skyblue;
                border-color: transparent;
                color: white;
            }

            .account {
                display: block;
                margin-bottom: 3px;
                padding: 3px;
                border: 1px solid lightgray;
                border-radius: 3px;
            }

            #alert {
                border-color: transparent;
            }
            #sign {
                width: 100%;
                background-color: rgb(209, 233, 252);
                border-color: transparent;
                color: white;
             
            }

            
        </style>
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="#page-top"><img src="assets/img/navbar-logo.svg" alt="..." /></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link" href="index.jsp">Services</a></li>
                        <li class="nav-item"><a class="nav-link" href="#services">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="reservation.jsp">Reservation</a></li>
                        <li class="nav-item"><a class="nav-link" href="login.jsp">Log-in</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    <!-- Contact-->
    <section class="page-section" id="contact">
        
         
                <div class="main">
                    <h1 class="logo">Sign-up</h1>
                    <div class="container">
                    	<form method="post" action="signupAction.jsp">
                    		<input type="text" placeholder="ID" id="id" name="id" class="account" size="37"><br>
	                        <input type="password" placeholder="Password" id="pw" name="pw" class="account" size="37"><br>
	                        <input type="text" placeholder="이름" id="name" name="name" class="account" size="37"><br>
	                        <input type="text" placeholder="Phone Number" id="phoneNumber" name="phoneNumber" class="account" size="37"><br><br>
<!-- 	                        <button type="submit" id="sign" class="account"><a href="signup.jsp"></a> sign-up</button> -->
<!-- 	                        <p id="alert" class="account"> </p> -->
<!-- 							<input type="submit" id="sign" class="btn btn-primary form-control" value="회원가입"> -->
                    		<input type="submit" id="sign" class="account" value="signup">
                    	</form>
            
                    </div>

                </div>   
                <script src="script.js"></script>
        
    
                            

               
</body>
</html>