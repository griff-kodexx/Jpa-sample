package Servlet;

import Entity.Department;
import Entity.Doctor;
import Entity.Gender;
import Logic.BusinessLogic.DoctorBean;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kodexx on 2/22/18.
 */
@WebServlet(urlPatterns = "/doctorRegistration")
public class DoctorRegistration extends HttpServlet {
    @Inject
    private DoctorBean doctorBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String redirectUrl = "doctorRegistration.jsp";
        try {
            response.sendRedirect(redirectUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(request.getParameter("fname"));
        doctor.setLastName(request.getParameter("lname"));
        doctor.setDateOfBirth(Integer.parseInt(request.getParameter("dob")));
        doctor.setIdNumber(Integer.parseInt(request.getParameter("idNumber")));
        doctor.setGender(Gender.valueOf(request.getParameter("gender")));
        doctor.setPhoneNumber(Integer.parseInt(request.getParameter("phone")));
        doctor.setEmail(request.getParameter("email"));
        doctor.setDoctorSpeciality(new Department()); //should loop in a drop down list
        if (request.getParameter("contract").equals("contracted")){
            doctor.setContracted(true);
        }else{
            doctor.setContracted(false);
        }

        boolean status = doctorBean.register(doctor);

        request.setAttribute("status", status);
        try {
            request.getRequestDispatcher("doctorRegistration.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
