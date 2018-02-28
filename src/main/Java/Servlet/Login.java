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
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Inject
    private UserBean userBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

            User user = new User();
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"), true);

            boolean status = userBean.login(user);
            request.setAttribute("status", status);
            request.setAttribute("userEmail", user.getEmail());
            try {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect("login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
