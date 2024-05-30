package mft.model.da;

import mft.model.entity.Plane;
import mft.model.entity.enums.Airline;
import mft.model.tools.CRUD;
import mft.model.tools.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDa implements AutoCloseable, CRUD<Plane> {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public PlaneDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }


    @Override
    public Plane save(Plane plane) throws Exception {
        plane.setId(ConnectionProvider.getConnectionProvider().getNextId("plane_SEQ"));

        preparedStatement = connection.prepareStatement(
                "INSERT INTO PLANE ( ID,NAME,AIRLINE,FLIGHTNUMBER, AIRCRAFTTYPE, ROUTE, CAPACITY) VALUES (?,?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, plane.getId());
        preparedStatement.setString(2, plane.getName());
        preparedStatement.setString(3, String.valueOf(plane.getAirline()));
        preparedStatement.setString(4, plane.getFlightNumber());
        preparedStatement.setString(5, plane.getAircraftType());
        preparedStatement.setString(6, plane.getRoute());
        preparedStatement.setInt(7, plane.getCapacity());
        preparedStatement.execute();
        return plane;
    }

    @Override
    public Plane edit(Plane plane) throws Exception {
        preparedStatement = connection.prepareStatement(
                "update PLANE set id=?,NAME=?,AIRLINE=?,FLIGHTNUMBER=?,AIRCRAFTTYPE=?,ROUTE=?,capacity=? where id=?");
        preparedStatement.setInt(1, plane.getId());
        preparedStatement.setString(2, plane.getName());
        preparedStatement.setString(3, String.valueOf(plane.getAirline()));
        preparedStatement.setString(4, plane.getFlightNumber());
        preparedStatement.setString(5, plane.getAircraftType());
        preparedStatement.setString(6, plane.getRoute());
        preparedStatement.setInt(7, plane.getCapacity());
        preparedStatement.execute();
        return plane;
    }

    @Override
    public Plane remove(int id) throws Exception {
        preparedStatement = connection.prepareStatement(
                "delete from PLANE where id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        return null;
    }

    @Override
    public List<Plane> findAll() throws Exception {
        List<Plane> planeList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select*from plane order by id");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Plane plane = Plane
                    .builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .airline(Airline.valueOf(resultSet.getString("airline")))
                    .flightNumber(resultSet.getString("flightNumber"))
                    .aircraftType(resultSet.getString("airCraftType"))
                    .route(resultSet.getString("route"))
                    .capacity(resultSet.getInt("capacity"))
                    .build();
            planeList.add(plane);
        }
        return planeList;
    }


    @Override
    public Plane findById(int id) throws Exception {
        preparedStatement = connection.prepareStatement("select * from plane where id=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Plane plane = null;
        if (resultSet.next()) {
            plane = Plane
                    .builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .airline(Airline.valueOf(resultSet.getString("airline")))
                    .flightNumber(resultSet.getString("flightNumber"))
                    .aircraftType(resultSet.getString("airCraftType"))
                    .route(resultSet.getString("route"))
                    .capacity(resultSet.getInt("capacity"))
                    .build();

        }
        return plane;
    }


    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}



