package mft.model.da;


import mft.model.entity.Plane;
import mft.model.tools.CRUD;
import mft.model.tools.ConnectionProvider;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class PlaneDa implements AutoCloseable, CRUD<Plane> {
    private final Connection connection;
    private preparedStatment preparedStatment;

    public PlaneDa() throws SQLException {
        connection = ConnectionProvider .getConnectionProvider().getConnection();
    }

    @Override
    public void close() throws Exception {

    }

    private PreparedStatement preparedStatement;

    public PlaneDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Plane save(Plane plane) throws Exception {
        plane.setName(ConnectionProvider.getConnectionProvider().getNextname("plane_SEQ"));

        preparedStatement = connection.prepareStatement(
                "INSERT INTO PLANE ( NAME, AIRLINE, FLIGHTNUMBER, AIRCRAFTTYPE, ROUT, CAPACITY) VALUES (?,?,?,?,?,?)"
        );
        preparedStatement.setString(1, Plane.getname());
        preparedStatement.setAirline(2, Plane.getairline());
        preparedStatement.setString(3, Plane.getflightnumber());
        preparedStatement.setString(4, Plane.getaircrafttype().name());
        preparedStatement.setString(5, Date.valueOf(Plane.getrout()));
        preparedStatement.setInt(6, Plane.getcapicity().name());

        preparedStatement.execute();
        return null;
    }

    @Override
    public Plane edit(Plane plane) throws Exception {
        return null;
    }

    @Override
    public Plane remove(int id) throws Exception {
        return null;
    }

    @Override
    public List<Plane> findAll() throws Exception {
        return Collections.emptyList();
    }

    @Override
    public Plane findById(int id) throws Exception {
        return null;
    }
}
