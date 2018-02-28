package Servlet;

import Entity.User;
import Logic.BusinessLogic.UserBean;

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
@WebServlet(urlPatterns = "/register")
public class UserRegistration extends HttpServlet {
    @Inject
    private UserBean userBean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response){

            User user = new User();

            user.setEmail(request.getParameter("email"));
            user.setFname(request.getParameter("firstName"));
            user.setLname(request.getParameter("lastName"));
            user.setPassword(request.getParameter("password"), true);

            boolean status = userBean.register(user);

            request.setAttribute("status", status);

        try {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("register.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
