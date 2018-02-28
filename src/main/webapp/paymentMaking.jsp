<%@ page import="Entity.Patient" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kodexx
  Date: 2/22/18
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp"%>
    <title>Make a Payment</title>
</head>
<body>
<div class="container">
    <div class="card card-container">
        <p class="text-info">Make a Payment</p>
        <form class="form-signin" action="paymentMaking" method="post">
            Patient:
            <select class="custom-select" name ="patient" required>
                <%
                    if (request.getAttribute("allpatients")!=null){
                        for (Patient p: (ArrayList<Patient>) request.getAttribute("allpatients")) {
                            out.print("<option value="+p.getId()+">"+p.getFirstName()+" "+p.getLastName()+"</option>");
                        }
                    }

                %>
            </select><br>
            Service:
            <select class="custom-select" name ="service" required>
               <option>radiology</option>
            </select><br>
            <div>
                <label>Amount</label>
                <input type="number" name="amount" id="amount" class="form-control" required/>
            </div>
            Insurance:
            <select class="custom-select" name ="insurance" required>
                <option>britam</option> <%--must be a dynamic selection--%>
            </select><br>
            <button class="btn btn-lg btn-primary btn-block btn-signin">Save</button>
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
