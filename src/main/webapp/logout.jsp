<%--
  Created by IntelliJ IDEA.
  User: kodexx
  Date: 2/12/18
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (session.getAttribute("isLoggedIn") == null){
        out.print("<font color=\"red\">Log In First</font>");
        String redirectUrl = "index.jsp";
        response.sendRedirect(redirectUrl);
    }else{
        session.invalidate();
        out.print("Logout successful");
        String redirectUrl = "index.jsp";
        response.sendRedirect(redirectUrl);
    }

%>
<html>
<head>
    <title>logout</title>
</head>
<body>
</body>
</html>
