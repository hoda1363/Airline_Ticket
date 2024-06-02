package mft.model.da;


import lombok.extern.log4j.Log4j;
import mft.model.entity.Flight;
import mft.model.entity.Plane;
import mft.model.tools.CRUD;
import mft.model.tools.ConnectionProvider;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class FlightDa implements AutoCloseable, CRUD<Flight> {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public FlightDa() throws Exception {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Flight save(Flight flight) throws Exception {
        flight.setId(ConnectionProvider.getConnectionProvider().getNextId("FLIGHT_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO FLIGHT (ID,NAME,Flight_Number,COMPANY_NAME,START_TIME,END_TIME,PLANE_ID ) VALUES (FLIGHT_SEQ.nextval,?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, flight.getId());
        preparedStatement.setString(2, flight.getName());
        preparedStatement.setInt(3, flight.getFlightNumber());
        preparedStatement.setString(4, flight.getCompanyName());
        preparedStatement.setTimestamp(5, Timestamp.valueOf(flight.getStartTime()));
        preparedStatement.setTimestamp(6, Timestamp.valueOf(flight.getEndTime()));
        preparedStatement.setString(7, String.valueOf(flight.getPlane()));
        preparedStatement.execute();
        preparedStatement.execute();
        return flight;
    }


            @Override
            public Flight edit (Flight flight) throws Exception {
                preparedStatement = connection.prepareStatement(
                        "UPDATE FLIGHT SET ID=?,NAME=?, flight_Number=?, company_Name=?, start_Time =?, end_Time=?, planE_ID=? WHERE ID=?");

                preparedStatement.setInt(1, flight.getId());
                preparedStatement.setString(2, flight.getName());
                preparedStatement.setInt(3, flight.getFlightNumber());
                preparedStatement.setString(4, flight.getCompanyName());
                preparedStatement.setTimestamp(5, Timestamp.valueOf(flight.getStartTime()));
                preparedStatement.setTimestamp(6, Timestamp.valueOf(flight.getEndTime()));
                preparedStatement.setString(7, String.valueOf(flight.getPlane()));
                preparedStatement.execute();
                preparedStatement.execute();
                return flight;
            }
            @Override
            public Flight remove(int id) throws Exception {
                preparedStatement = connection.prepareStatement(
                        "DELETE FROM FLIGHT WHERE ID=?"
                );
                preparedStatement.setInt(1, id);
                preparedStatement.execute();
                return null;
            }
            @Override
            public List<Flight> findAll() throws Exception {
                List<Flight> flightList = new ArrayList<>();
                preparedStatement = connection.prepareStatement("SELECT * FROM FLIGHT ORDER BY ID");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Flight flight = Flight
                            .builder()
                            .id(resultSet.getInt("ID"))
                            .name(resultSet.getString("NAME"))
                            .flightNumber(resultSet.getInt("flight_number"))
                            .companyName(resultSet.getString("company_name"))
                            .startTime(resultSet.getTimestamp("Start_Time").toLocalDateTime())
                            .endTime(resultSet.getTimestamp("END_Time").toLocalDateTime())
                            .plane(Plane.builder().id(resultSet.getInt("plane_id")).build())
                            .build();
                    flightList.add(flight);
                }
                return flightList;
            }
            @Override
            public Flight findById(int id) throws Exception {
                preparedStatement = connection.prepareStatement("select * from FLIGHT where id=?");
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
              Flight flight = null;
                if (resultSet.next()){
                  flight=Flight
                     .builder()
                            .id(resultSet.getInt("ID"))
                            .name(resultSet.getString("NAME"))
                            .flightNumber(resultSet.getInt("flight_number"))
                            .companyName(resultSet.getString("company_name"))
                            .startTime(resultSet.getTimestamp("Start_Time").toLocalDateTime())
                            .endTime(resultSet.getTimestamp("END_Time").toLocalDateTime())
                            .plane(Plane.builder().id(resultSet.getInt("plane_id")).build())
                            .build();
                }
                return flight;
                }

    public Flight findByFlightNumber(int flight_number) throws Exception {
        preparedStatement = connection.prepareStatement("select * from FLIGHT where FLIGHT_NUMBER=?");
        preparedStatement.setInt(1, flight_number);
        ResultSet resultSet = preparedStatement.executeQuery();
        Flight flight = null;
        if (resultSet.next()) {
            flight = Flight
                    .builder()
                    .id(resultSet.getInt("ID"))
                    .name(resultSet.getString("NAME"))
                    .flightNumber(resultSet.getInt("flight_number"))
                    .companyName(resultSet.getString("company_name"))
                    .startTime(resultSet.getTimestamp("Start_Time").toLocalDateTime())
                    .endTime(resultSet.getTimestamp("END_Time").toLocalDateTime())
                    .plane(Plane.builder().id(resultSet.getInt("plane_id")).build())
                    .build();
        }
        return flight;
    }
            @Override
public void close() throws Exception {
    preparedStatement.close();
    connection.close();
    }
}
