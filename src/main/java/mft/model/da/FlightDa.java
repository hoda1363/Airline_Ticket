package mft.model.da;


import lombok.extern.log4j.Log4j;
import mft.model.entity.Flight;
import mft.model.entity.Person;


import mft.model.tools.CRUD;
import mft.model.tools.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import java.sql.Date;

@Log4j
public class FlightDa implements AutoCloseable, CRUD<Flight> {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public FlightDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public save(Flight flight) throws Exception {
        flight.setId(ConnectionProvider.getConnectionProvider().getNextId("PERSON_SEQ"));

        preparedStatement = connection.prepareStatement(
                "INSERT INTO PERSON (ID, flightNumber, companyName, startTime, endTime, plan) VALUES (?,?,?,?,?)"
        );
        preparedStatement.setInt(1, Flight.getId());
        preparedStatement.setString(2, Flight.getFlightnumber());
        preparedStatement.setString(3, Flight.getCompanyName());
        preparedStatement.setString(4, Flight.grtStartTime());
        preparedStatement.setDate(5, Flight.getEndTIME));
        preparedStatement.setString(6, Flight.getPlane.name());

        preparedStatement.execute();
        save(Flight flight) throws Exception {
            flight.setId(ConnectionProvider.getConnectionProvider().getNextId("PERSON_SEQ"));

            preparedStatement = connection.prepareStatement();
            preparedStatement.execute();


            @Override
            public Person edit (Flight flight) throws Exception {
                preparedStatement = connection.prepareStatement(
                        "UPDATE PERSON SET ID=?, flightNumber=?, companyName=?, startTime =?, endTime=?, plan=? WHERE ID=?"
                );
                preparedStatement.setString(1, Flight.getID());
                preparedStatement.setString(2, Flight.getFLightNumber());
                preparedStatement.setString(3, Flight.getcompanyNme.name());
                preparedStatement.setDate(4, (Flight.startTime()));
                preparedStatement.setDate(5, Flight.endTime());

                preparedStatement.setInt(9, Flight.flight.Name());
                preparedStatement.execute();
                return Flight;
            }
            @Override
            public Flight remove(int id) throws Exception {
                preparedStatement = connection.prepareStatement(
                        "DELETE FROM PERSON WHERE ID=?"
                );
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                return null;
            }
