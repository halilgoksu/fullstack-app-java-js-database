package com.revature;

import com.revature.CreateLogin.data.PersonConnectionFactory;
import com.revature.Ticket.data.TicketConnectionFactory;



// Main class, this is the starting point of the project
// This class should be pretty bare-bones. We'll basically just be setting up our controller
public class App {
    public static void main(String[] args) {

        // call the menu method that we set up in our command line interface:
        PersonConnectionFactory.getConnection();
        TicketConnectionFactory.getConnection();



        System.out.println("App started");
    }
}
