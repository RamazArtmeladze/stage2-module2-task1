package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user parameters from the request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        // Create a new user
        User newUser = new User(firstName, lastName);

        // Add the user to the Warehouse
        Warehouse.getInstance().addUser(newUser);

        // Set the user as a request attribute
        request.setAttribute("user", newUser);

        // Forward to the /add page
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user parameters from the request
        String firstName = (String) request.getAttribute("firstName");
        String lastName = (String) request.getAttribute("lastName");

        // Check if required attributes are present
        if (firstName == null || lastName == null) {
            // Handle the case where attributes are not present (e.g., redirect to an error page)
            // Alternatively, you may want to set default values or handle this situation based on your application logic.
            response.sendRedirect("/error.jsp"); // Redirect to an error page
        } else {
            // Create a new user
            User newUser = new User(firstName, lastName);

            // Add the user to the Warehouse
            Warehouse.getInstance().addUser(newUser);

            // Set the user as a request attribute
            request.setAttribute("user", newUser);

            // Forward to the /add.jsp page
            request.getRequestDispatcher("/add.jsp").forward(request, response);
        }
    }
}
