package mft.model.da;

import mft.model.entity.Flight;
import mft.model.entity.Person;
import mft.model.entity.Ticket;
import mft.model.entity.enums.Airline;
import mft.model.tools.CRUD;
import mft.model.tools.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDa implements AutoCloseable, CRUD<Ticket> {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public TicketDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Ticket save(Ticket ticket) throws Exception {
        ticket.setId(ConnectionProvider.getConnectionProvider().getNextId("TICKET_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO TICKET (ID,DATETIME,SOURCE,DESTINATION,DURATION,CONFIRM,FLIGHT_ID,AIRLINE) VALUES (?,?,?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1,ticket.getId());
        preparedStatement.setTimestamp(2, Timestamp.valueOf(ticket.getDateTime()));
        preparedStatement.setString(3, ticket.getSource());
        preparedStatement.setString(4, ticket.getDestination());
        preparedStatement.setTime(5, Time.valueOf(ticket.getDuration()));
        preparedStatement.setBoolean(6,ticket.isConfirm());
        preparedStatement.setInt(7,ticket.getFlight().getId());
        preparedStatement.setString(8,String.valueOf(ticket.getAirline()));
        preparedStatement.execute();
        return ticket;
    }

    @Override
    public Ticket edit(Ticket ticket) throws Exception {
        preparedStatement = connection.prepareStatement(
               "UPDATE TICKET SET ID=?,DATETIME=?,SOURCE=?,DESTINATION=?,DURATION=?,CONFIRM=?,FLIGHT_ID=?,AIRLINE=? WHERE ID=?"
        );
        preparedStatement.setInt(1,ticket.getId());
        preparedStatement.setTimestamp(2, Timestamp.valueOf(ticket.getDateTime()));
        preparedStatement.setString(3, ticket.getSource());
        preparedStatement.setString(4, ticket.getDestination());
        preparedStatement.setTime(5, Time.valueOf(ticket.getDuration()));
        preparedStatement.setBoolean(6,ticket.isConfirm());
        preparedStatement.setInt(7,ticket.getFlight().getId());
        preparedStatement.setString(8,String.valueOf(ticket.getAirline()));
        preparedStatement.execute();
        return ticket;


    }

    @Override
    public Ticket remove(int id) throws Exception {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM TICKET WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        return null;
    }

    @Override
    public List<Ticket> findAll() throws Exception {
        List<Ticket> ticketList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("SELECT * FROM TICKET ORDER BY ID");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Ticket ticket = Ticket
                    .builder()
                    .id(resultSet.getInt("ID"))
                    .dateTime(resultSet.getTimestamp("dateTime").toLocalDateTime())
                    .source(resultSet.getString("sorce"))
                    .destination(resultSet.getString("destination"))
                    .duration(resultSet.getTime("duration").toLocalTime())
                    .confirm(resultSet.getBoolean("confirm"))
                    .flight(Flight.builder().id(resultSet.getInt("FLIGHT_ID")).build())
                    .airline(Airline.valueOf(resultSet.getString("airline")))
                    .build();

            ticketList.add(ticket);
        }

        return ticketList;
    }

    @Override
    public Ticket findById(int id) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT * FROM TICKET where ID=?");
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Ticket ticket = null;
        if (resultSet.next()) {
            ticket = Ticket
                    .builder()
                    .id(resultSet.getInt("ID"))
                    .dateTime(resultSet.getTimestamp("dateTime").toLocalDateTime())
                    .source(resultSet.getString("sorce"))
                    .destination(resultSet.getString("destination"))
                    .duration(resultSet.getTime("duration").toLocalTime())
                    .confirm(resultSet.getBoolean("confirm"))
                    .flight(Flight.builder().id(resultSet.getInt("FLIGHT_ID")).build())
                    .airline(Airline.valueOf(resultSet.getString("airline")))
                    .build();
        }
        return ticket;
    }
    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
