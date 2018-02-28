<%
    if (session.getAttribute("isLoggedIn")!=null){
        out.print("<font color=\"red\">LoggedIn already. Logout first</font>");
        String redirectUrl = "index.jsp";
        response.sendRedirect(redirectUrl);
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/good.js"></script>
</head>
<body>

<div class="container">
    <div class="card card-container">
        <form class="form-signin" method="POST" action="login" >
            Email : <input type="email" class="form-control" id="inputEmail" name="email" placeholder="email address" required/>
            <br>
            Password : <input type="password" class="form-control" id="inputPassword" name="password" placeholder="password"/>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">login</button>

            <%
                if ((request.getAttribute("status")!=null)){
                    boolean status = (boolean) request.getAttribute("status");
                    String userEmail = (String) request.getAttribute("userEmail");

                    if (true){
                        session.setAttribute("userEmail", userEmail);
                        session.setAttribute("isLoggedIn", true);
                        session.setMaxInactiveInterval(30*60);

                        String redirectUrl = "index.jsp";
                        response.sendRedirect(redirectUrl);
                        out.print("<font color=\"green\">Login Successful</font><br>");
                    }else{
                        out.print("<font color=\"red\">Login failed!</font><br>");
                    }
                }
            %>
            <a href="register">New? Register</a><br>
        </form>
    </div>
</div>

</body>
</html>
