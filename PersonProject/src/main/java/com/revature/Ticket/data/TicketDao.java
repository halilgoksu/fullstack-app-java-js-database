package com.revature.Ticket.data;

import com.revature.Ticket.entity.Ticket;

public interface TicketDao {
    public Ticket insert (Ticket ticket);
    public Ticket getById(int id);
}
