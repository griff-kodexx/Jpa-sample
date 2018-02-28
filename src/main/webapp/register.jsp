
<%
    if (session.getAttribute("isLoggedIn")!=null){
        out.print("<font color=\"red\">LoggedIn already. Logout first</font>");
        String redirectUrl = "index.jsp";
        response.sendRedirect(redirectUrl);
    }
%>

<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/good.js"></script>
</head>
<body>

<div class="container">
    <div class="card card-container">
        <form class="form-signin" method="POST" action="register">
            Email : <input type="email" class="form-control" placeholder="Email Address" name="email" required="required"/>
            <br>
            First Name : <input type="text" class="form-control" placeholder="First Name" name="firstName" required="required"/>
            <br>
            Last Name : <input type="text" class="form-control" placeholder="Last Name" name="lastName" required="required"/>
            <br>
            Password : <input type="password" class="form-control" placeholder="Password" name="password" required="required" />
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Register</button>

            <%
                if ((request.getAttribute("status")!=null)){
                    boolean status = (boolean) request.getAttribute("status");
                    if (status){
                        out.print("<font color=\"green\">Registration Successful</font><br>");
                    }else{
                        out.print("<font color=\"red\">Registration failed!</font><br>");
                    }
                }

            %>


            <a href="login">Login</a>
        </form>
    </div>
</div>
</body>
</html>
