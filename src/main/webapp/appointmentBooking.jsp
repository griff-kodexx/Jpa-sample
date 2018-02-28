<%@ page import="Entity.Doctor" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.Patient" %>
<%--
  Created by IntelliJ IDEA.
  User: kodexx
  Date: 2/15/18
  Time: 8:10 AM
  To change this template use File | Settings | File Templates.
--%>
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
    <%@ include file="header.jsp"%>
    <title>Book an Appointment</title>

</head>
<body>
<div class="container">
    <div class="card card-container">
        <p class="text-info">Book an appointment</p>
        <form  class="form-signin" action="appointmentBooking" method="post">

            Patient :
            <select class="custom-select" name ="patient" required>
                <%
                    if (request.getAttribute("allpatients")!=null){
                        for (Patient p: (ArrayList<Patient>) request.getAttribute("allpatients")) {
                            out.print("<option value="+p.getId()+">"+p.getFirstName()+" "+p.getLastName()+"</option>");
                        }
                    }

                %>
            </select><br>

            Doctor :
            <select class="custom-select" name="doctor" required>
                <%
                    if (request.getAttribute("alldoctors")!= null){
                        for (Doctor k: (ArrayList<Doctor>) request.getAttribute("alldoctors")) {
                            out.print("<option value="+k.getId()+">"+k.getFirstName()+" "+k.getLastName()+"</option>");
                        }
                    }


                %>
            </select><br>
            <div>
                <label for="date">Date</label>
                <input  type="date" name="date" id="date" class="form-control" required/><br>
            </div>
            <div>
                <label for="time">Time</label>
                <input  type="time" name="time" id="time" class="form-control" required/><br>
            </div>
            <button class="btn btn-lg btn-primary btn-block btn-signin">book</button>
            <%
                if (request.getAttribute("status") != null){
                    if ((boolean) request.getAttribute("status")){
                        out.print("<font color=\"green\">Appointment booking Successful</font><br>");
                    }else{
                        out.print("<font color=\"red\">Appointment booking failed!</font><br>");
                    }
                }
            %>
        </form>
    </div>
</div>

</body>
</html>
