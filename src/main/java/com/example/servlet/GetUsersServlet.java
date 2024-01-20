package com.example.servlet;

import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get users from the Warehouse
        Warehouse warehouse = Warehouse.getInstance();
        request.setAttribute("users", warehouse.getUsers());

        // Forward to the /users page
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}
