package com.revature.Ticket.service;

import com.revature.Ticket.data.DaoFactory;
import com.revature.Ticket.data.TicketDao;
import com.revature.Ticket.entity.Ticket;

// Service classes contain business logic of what's going on:
public class TicketService {

    // we take in a Ticket object with just name and password
    public Ticket register(Ticket ticket) {
        // we want to send back data from database
        // inserting this new ticket into the database:
        TicketDao ticketDao = DaoFactory.getTicketDao();
        Ticket ticket1 = ticketDao.insert(ticket);
        return ticket1;
    }

    // return a ticket object if the id and amount match what's in the database
    // otherwise, we can return null:
    public Ticket login(int id, String amount) {
        // business logic where we check the amount:
        // first let's get the ticket from the database:
        TicketDao ticketDao = DaoFactory.getTicketDao();
        Ticket ticket = ticketDao.getById(id);
        if (amount.equals(ticket.getAmount())) {
            // if they match, we return the ticket
            return ticket;
        }
        // if passwords don't match, return null, indicating that the amount is incorrect
        return null;
    }

}
