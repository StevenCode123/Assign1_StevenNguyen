package com.sn.week2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sn.week2.RegisterDao;
import com.sn.week2.RegistrationClass;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().println("RegisterServlet is running!");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form parameters
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        String mobile = request.getParameter("mblnumber");
        String email = request.getParameter("email");

        boolean hasError = false;
        List<String> errorMessages = new ArrayList<>();

        // -------- Validation --------
        if (userName == null || userName.isEmpty()) {
            request.setAttribute("userNameError", "UserName can not be Blank");
            errorMessages.add("Username cannot be blank");
            hasError = true;
        } else if (userName.length() > 10) {
            request.setAttribute("userNameError", "Max 10 characters only");
            errorMessages.add("Username exceeds 10 characters");
            hasError = true;
        }

        if (password == null || password.isEmpty()) {
            request.setAttribute("passwordError", "Password can not be Blank");
            errorMessages.add("Password cannot be blank");
            hasError = true;
        } else if (!password.matches("[0-9$_]{1,10}")) {
            request.setAttribute("passwordError", "Only digits and $ or _ symbols allowed (max 10)");
            errorMessages.add("Password invalid format");
            hasError = true;
        }

        if (rePassword == null || !password.equals(rePassword)) {
            request.setAttribute("rePasswordError", "Enter correct password");
            errorMessages.add("Passwords do not match");
            hasError = true;
        }

        if (mobile == null || !mobile.matches("\\d{10}")) {
            request.setAttribute("mobileError", "Enter valid 10 digit mobile number");
            errorMessages.add("Mobile number invalid");
            hasError = true;
        }

        if (email == null || email.isEmpty()) {
            request.setAttribute("emailError", "Email Field can not be Blank");
            errorMessages.add("Email cannot be blank");
            hasError = true;
        }

        // -------- Logging & Forwarding --------
        if (hasError) {
            System.out.println("FORM REJECTED due to validation errors:");
            for (String msg : errorMessages) {
                System.out.println(" - " + msg);
            }
            request.getRequestDispatcher("RegistrationWeb.jsp").forward(request, response);
        } else {
            System.out.println("FORM SUCCESSFULLY SUBMITTED");
            System.out.println("Username: " + userName + ", Mobile: " + mobile + ", Email: " + email);

            // Insert into database
            RegistrationClass user = new RegistrationClass();
            user.setUserName(userName);
            user.setPassword(password);
            user.setMblnumber(mobile);
            user.setEmail(email);

            RegisterDao dao = new RegisterDao();
            boolean status = dao.insertUser(user);

            if (status) {
                response.sendRedirect("success.jsp");
            } else {
                response.getWriter().println("Database error occured");
            }
        }
    }
}
