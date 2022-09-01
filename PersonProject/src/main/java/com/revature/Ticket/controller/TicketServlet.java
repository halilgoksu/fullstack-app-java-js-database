package com.revature.Ticket.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Ticket.entity.Ticket;
import com.revature.Ticket.service.TicketService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TicketServlet extends HttpServlet {

    // register, but also logging in:
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // print writer and ticket service intiliaze
        PrintWriter out = resp.getWriter();
        TicketService ticketService = new TicketService();

        // set up variables to store the ticket object from the body:
        ObjectMapper mapper = new ObjectMapper();
        Ticket ticket;

        // try to read in the credential information:
        try {
            // Object Mapper requires default constructor:
            ticket = mapper.readValue(req.getReader(), Ticket.class);
        }catch(Exception e) {
            e.printStackTrace();
            resp.sendError(400, "Invalid ticket format");
            return;
        }

        // either login or register:
        String authType = req.getParameter("auth");
        if(authType.equals("login")) {
            ticket = ticketService.login(ticket.getId(), ticket.getAmount());
        }
        else if (authType.equals("register")){
            ticket = ticketService.register(ticket);
        }
        else if (authType.equals("process")){
            ticket = ticketService.register(ticket);
        }

        // if invalid credentials, return error code:
        if(ticket == null) {
            resp.sendError(400, "Invalid credentials");
            return;
        }

        // otherwise print out the ticket:
        out.println(ticket.getName());

        // update the session with the ticket's id: (indicates if we are logged in/registered
        req.getSession().setAttribute("id", ticket.getId());
    }

}
