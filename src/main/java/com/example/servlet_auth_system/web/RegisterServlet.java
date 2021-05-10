package com.example.servlet_auth_system.web;

import com.example.servlet_auth_system.DAO.ConnectionPro;
import com.example.servlet_auth_system.DAO.UserDao;
import com.example.servlet_auth_system.Models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        Long phone = request.getContextPath("phone");
        //make user object
        User userModel = new User(name, email, password);

        //create a database model
        UserDao regUser = new UserDao(ConnectionPro.getConnection());
        if (regUser.saveUser(userModel)) {
            response.sendRedirect("index.jsp");
        } else {
            String errorMessage = "User Available";
            HttpSession regSession = request.getSession();
            regSession.setAttribute("RegError", errorMessage);
            response.sendRedirect("register.jsp");
        }

    }

}