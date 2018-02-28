package Servlet;

import Entity.*;
import Logic.BusinessLogic.PatientBean;

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
@WebServlet(urlPatterns = "/paymentMaking")
public class PaymentMaking extends HttpServlet {
    @Inject
    private PatientBean patientBean;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Payment payment = new Payment();
        payment.setAmount(Double.valueOf(req.getParameter("amount")));
        payment.setInsurance(new Insurance(0));
        payment.setService(Service.valueOf(req.getParameter("service")));
        payment.setPatient(new Patient(Integer.valueOf(req.getParameter("patient"))));

        boolean status = patientBean.pay(payment);
        req.setAttribute("status", status);
        try {
            req.getRequestDispatcher("paymentMaking.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("allpatients", patientBean.getAllPatients());
        try {
            req.getRequestDispatcher("paymentMaking.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
