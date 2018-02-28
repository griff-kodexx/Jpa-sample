package Servlet;

import Entity.Gender;
import Entity.Insurance;
import Entity.Patient;
import Logic.BusinessLogic.PatientBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kodexx on 2/21/18.
 */
@WebServlet(urlPatterns = "/patientRegistration")
public class PatientRegistration extends HttpServlet {
    @Inject
    private PatientBean patientBean;
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("patientRegistration.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        Patient patient = new Patient();
        patient.setDateOfBirth(request.getParameter("dob"));
        patient.setFirstName(request.getParameter("fname"));
        patient.setLastName(request.getParameter("lname"));
        if (request.getParameter("gender").equals("male")){
            patient.setGender(Gender.male);
        }else{
            patient.setGender(Gender.female);
        }
        patient.setPhoneNumber(request.getParameter("phone"));
        patient.setIdNumber(request.getParameter("idNumber"));
        patient.setInsurance(new Insurance(0));
        patient.setNextOfKinName(request.getParameter("nextOfKinName"));
        patient.setNextOfKinPhone(request.getParameter("nextOfKinPhone"));

        boolean status = patientBean.register(patient);
        request.setAttribute("status",status);
        try {
            request.getRequestDispatcher("patientRegistration.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
