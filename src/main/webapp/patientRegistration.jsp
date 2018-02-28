<%
    if (session.getAttribute("isLoggedIn") == null){
        out.print("<font color=\"red\">Log In First</font>");
        String redirectUrl = "index.jsp";
        response.sendRedirect(redirectUrl);
    }

%>

<html>
<head>
    <%@ include file="header.jsp" %>
    <title>Patient Registration</title>
</head>
<body>
<div class="container">
<div class="card card-container">
        <p class="text-info">Register a patient</p>
        <form class="form-signin" method="post" action="patientRegistration">

            First Name: <input class="form-control" placeholder="first name" type="text" name="fname" required /> &nbsp&nbsp
            Last Name: <input class="form-control" placeholder="last name" type="text" name="lname" required /><br>
            Id Number: <input class="form-control" placeholder="ID Number" type="number" name="idNumber" required />&nbsp&nbsp
            Date Of Birth: <input class="form-control" placeholder="Date of Birth" type="text" name="dob" required/><br>
            Gender: <select name="gender" required>
                        <option value="male">male</option>
                        <option value="female">female</option>
                    </select>&nbsp&nbsp
            Phone Number: <input class="form-control" placeholder="Phone Number" type="number" name="phone" required /><br>
            NextOfKin Name: <input class="form-control" placeholder="Next of kin" type="text" name="nextOfKinName"  />&nbsp&nbsp
            NextOfKin Phone: <input class="form-control" placeholder="Next of kin phone" type="number" name="nextOfKinPhone"/><br>
            Insurance:  <select name="insurance" >
                <option value="none" >None</option>
                <option value="britam" >britam</option>
                <option value="NHIF">NHIF</option>
            </select>

            <button class="btn btn-primary btn-block btn-signin" type="submit">Register</button>

            <%
                if (request.getAttribute("status")!=null){
                    boolean status = (boolean) request.getAttribute("status");
                    if (status){
                        out.print("<font color=\"green\">Registration Successful</font><br>");
                    }else{
                        out.print("<font color=\"red\">Registration failed!</font><br>");
                    }
                }

            %>
        </form>

</div>
</div>
</body>
</html>
