package com.example.servlet;

import com.example.User;
import com.example.Warehouse;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "GetUsersServlet", value = "/users")
public class GetUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<User> users = Warehouse.getInstance().getUsers();
        request.setAttribute("users", users);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/users.jsp");
        dispatcher.forward(request, response);
    }
}
