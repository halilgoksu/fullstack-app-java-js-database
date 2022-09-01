package com.revature.Ticket.data;

// import from java.sql

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

// This class is all about creating and returning a connection to our database
// We're using the Factory Design Pattern as well as the singleton design pattern to return
// a singleton instance of the same connection whenever we want
public class TicketConnectionFactory {
    // singleton value, only one connection exists:
    // we use the static keyword to ensure that our connection only exists once (singleton)
    // because a static variable is attached to the class, it won't' be re-recreated every time we make a new instance of the
    // TicketConnectionFactory class
    private static Connection connection = null;

    // limit access to this class, we can make a private constructor so that Java doesn't create a default constructor:
    private TicketConnectionFactory() {

    }

    // this method is going to return the connection whenever we call this method:
    // This is the only method that we have access to, it handles the creation of the connection (Factory Design Pattern)
    public static Connection getConnection() {
        // check if the connection has been created
        if(connection == null) {
            System.out.println("Connection is being created");
            // If this if-statement triggers, then we know the connection hasn't been created yet
            // because it still has the default "null" value
            // Do the logic of creating the connection:

            // this helps us read information from a properties file, we just have to specify the name:
            // we just need the name here, not the .properties extension
            ResourceBundle bundle = ResourceBundle.getBundle("DbConfig");

            // reading in the information from the properties file
            // therefore, the credentials aren't stored in the Java code
            String url = bundle.getString("url");
            String user = bundle.getString("username");
            String password = bundle.getString("password");

            try {
                // this line of code makes sure that we load our driver before we make the connection:
                // TODO: look into this:
                Class.forName("org.postgresql.Driver");
                // pass in the credentials
                connection = DriverManager.getConnection(url, user, password);
            } catch(SQLException e) {
                // if something goes wrong with the connection, then we print an informative message:
                System.out.println("Something went wrong when creating the connection");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return connection;
    }



}
