package mft.model.da;


import lombok.extern.log4j.Log4j;
import mft.model.entity.Plane;
import mft.model.tools.CRUD;
import mft.model.tools.ConnectionProvider;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
@Log4j

public class PlaneDa implements AutoCloseable, CRUD<Plane> {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public PlaneDa() throws SQLException {
        connection = ConnectionProvider .getConnectionProvider().getConnection();
    }



    @Override
    public Plane save(Plane plane) throws Exception {
//        plane.setId(ConnectionProvider.getConnectionProvider().getNextId("plane_SEQ"));

        preparedStatement = connection.prepareStatement(
                "INSERT INTO PLANE ( NAME, AIRLINE-id, FLIGHTNUMBER, AIRCRAFTTYPE, ROUT, CAPACITY) VALUES (?,?,?,?,?,?)"
        );
        preparedStatement.setString(1, plane.getName());
        preparedStatement.setString(2, plane.getAirline());
        preparedStatement.setString(3, plane.getFlightnumber());
        preparedStatement.setString(4, plane.getAircrafttype());
        preparedStatement.setString(5, Date.valueOf(plane.getRout()));
        preparedStatement.setInt(6, plane.getcapicity().nam());

        preparedStatement.execute();
        return null;
    }

    @Override
    public Plane edit(Plane plane) throws Exception {
        preparedStatement.setString(1, Plane.getName());
        preparedStatement.setString(2, Plane.getairline());
        preparedStatement.setString(3, Plane.getFlightnumber());
        preparedStatement.setString(4, Plane.getAircrafttype().name());
        preparedStatement.setString(5, Date.valueOf(Plane.getRout()));
        preparedStatement.setInt(6, Plane.getcapicity().name());

        preparedStatement.execute();
        return null;
    }

    @Override
    public Plane remove(int id) throws Exception {
        preparedStatement.setString(1, Plane.getName());
        preparedStatement.setString(2, Plane.getairline());
        preparedStatement.setString(3, Plane.getFlightnumber());
        preparedStatement.setString(4, Plane.getAircrafttype().name());
        preparedStatement.setString(5, Date.valueOf(Plane.getRout()));
        preparedStatement.setInt(6, Plane.getcapicity().name());

        preparedStatement.execute();
        return null;
    }

    @Override
    public List<Plane> findAll() throws Exception {
        preparedStatement.setString(1, Plane.getName());
        preparedStatement.setString(2, Plane.getairline());
        preparedStatement.setString(3, Plane.getFlightnumber());
        preparedStatement.setString(4, Plane.getAircrafttype().name());
        preparedStatement.setString(5, Date.valueOf(Plane.getRout()));
        preparedStatement.setInt(6, Plane.getcapicity().name());

        preparedStatement.execute();
        return Collections.emptyList();
    }

    @Override
    public Plane findById(int id) throws Exception {
        preparedStatement.setString(1, Plane.getName());
        preparedStatement.setString(2, Plane.getairline());
        preparedStatement.setString(3, Plane.getFlightnumber());
        preparedStatement.setString(4, Plane.getAircrafttype().name());
        preparedStatement.setString(5, Date.valueOf(Plane.getRout()));
        preparedStatement.setInt(6, Plane.getcapicity().name());

        preparedStatement.execute();
        return null;
    }

@Override
public void close() throws Exception {
    preparedStatement.close();
    connection.close();
}}
