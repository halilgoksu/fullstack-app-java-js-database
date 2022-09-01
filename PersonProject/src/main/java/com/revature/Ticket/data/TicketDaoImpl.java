package com.revature.Ticket.data;

import com.revature.Ticket.entity.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

// this class is going to interact with the ticket table:
public class TicketDaoImpl implements TicketDao {

    Connection connection;

    public TicketDaoImpl() {
        // we're using the same exact connection factory as our pet dao class because
        // it's the same database
        connection = TicketConnectionFactory.getConnection();
    }


    @Override
    public Ticket insert(Ticket ticket) {
        Logger logger = LoggerFactory.getLogger("Ticket Dao Impl");
        String sql = "insert into ticket values(default, ?, ?, ? );";
        try {
            // preparing our statement and indicating that we want the generated id:
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, ticket.getName());
            preparedStatement.setString(2, ticket.getAmount());
            preparedStatement.setString(3, ticket.getDescription());



            int count = preparedStatement.executeUpdate();

            if (count == 1) {
                logger.info("Ticket added succesfully");
            }
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            ticket.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            logger.warn("Something went wrong with the insert");
            return null;
        }
        return ticket;
    }

    @Override
    public Ticket getById(int id) {
        Logger logger = LoggerFactory.getLogger("Ticket Dao Impl");
        String sql = "select * from ticket where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1 , id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                int idDb = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String amount = resultSet.getString("amount");
                String description = resultSet.getString("description");



                return new Ticket(idDb, name, amount,description);
            }
            else {
                logger.warn("Ticket might not exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn("SQL Exception occurred");
        }
        return null;
    }
}
