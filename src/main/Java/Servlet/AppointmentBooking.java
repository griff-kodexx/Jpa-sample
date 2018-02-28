package Servlet;

import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;
import Logic.BusinessLogic.DoctorBean;
import Logic.BusinessLogic.PatientBean;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by kodexx on 2/19/18.
 */
@WebServlet(urlPatterns = "/appointmentBooking")
public class AppointmentBooking extends HttpServlet {

    @Inject
    private DoctorBean doctorBean;
    @Inject
    private PatientBean patientBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        Appointment appointment = new Appointment();


        appointment.setTime(request.getParameter("time"));
        appointment.setDate(request.getParameter("date"));
        appointment.setDoctor(new Doctor(Integer.parseInt(request.getParameter("doctor"))));
        appointment.setPatient(new Patient(Integer.parseInt(request.getParameter("patient"))));

        boolean status = patientBean.book(appointment);
        request.setAttribute("status", status);

        try {
            request.getRequestDispatcher("appointmentBooking.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        request.setAttribute("alldoctors", doctorBean.getAllDoctors());
        request.setAttribute("allpatients", patientBean.getAllPatients());
        try {
            request.getRequestDispatcher("appointmentBooking.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
