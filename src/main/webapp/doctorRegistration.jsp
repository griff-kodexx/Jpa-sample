
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("isLoggedIn") == null){
        out.print("<font color=\"red\">Log In First</font>");
        String redirectUrl = "index.jsp";
        response.sendRedirect(redirectUrl);
    }


%>

<html>
<head>
    <title>Doctor Registration</title>
    <%@ include file="header.jsp" %>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <p class="text-info">Register a doctor</p>
        <form class="form-signin" action="doctorRegistration" method="post">
            Id Number: <input class="form-control" type="number" name="idNumber" required /><br>
            First Name: <input class="form-control" type="text" name="fname" required /><br>
            Last Name: <input class="form-control" type="text" name="lname" required /><br>
            Date Of Birth: <input class="form-control" type="number" name="dob" required/><br>
            Gender:
            <select name="gender" required>
                <option value="male">male</option>
                <option value="female">female</option>
            </select><br>
            Phone Number: <input class="form-control" type="number" name="phone" /><br>
            Email: <input class="form-control" type="email" name="email" /><br>
            Speciality: <input class="form-control" type="text" name="speciality" required/><br>
            Contract Type:
            <select name="contract" required>
                <option value="resident">Resident</option>
                <option value="contracted">Contracted</option>
            </select><br>

            <button class="btn btn-primary btn-block btn-signin" type="submit" >Register</button>
            <%
                if (request.getAttribute("status")!=null){

                    if ((boolean)request.getAttribute("status")){
                        out.print("<br><font color=\"green\">Registration of Doctor successful</font><br>");
                    }else{
                        out.print("<font color=\"red\">Registration of Doctor failed!</font>");
                    }
                }

            %>
        </form>
    </div>
</div>



</body>
</html>
