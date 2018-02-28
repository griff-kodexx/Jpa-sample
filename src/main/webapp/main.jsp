<%
    if (session.getAttribute("isLoggedIn") == null){
        out.print("<font color=\"red\">Log In First</font>");
        String redirectUrl = "index.jsp";
        response.sendRedirect(redirectUrl);
    }

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Clinic System</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/good.js"></script>
    <%@ include file="header.jsp" %>

</head>
<body>
<div class="container">
    <div class="card card-container">
        <p>Welcome to the clinic system. Use the menu bar for navigation purposes</p>
    </div>

</div>


</body>
</html>
