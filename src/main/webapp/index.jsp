<%--
  Created by IntelliJ IDEA.
  User: kodexx
  Date: 2/12/18
  Time: 9:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clinic System</title>
</head>
<body>
<%
    if (session.getAttribute("isLoggedIn") == null) {
        out.print("<font color=\"green\">Please log in first</font>");
        String redirectUrl = "login.jsp";
        response.sendRedirect(redirectUrl);
    }else{
        out.print("here");
        String redirectUrl = "main.jsp";
        response.sendRedirect(redirectUrl);
    }

%>

</body>
</html>
