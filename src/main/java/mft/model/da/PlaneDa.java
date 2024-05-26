package mft.model.da;


import mft.model.entity.Plane;
import mft.model.tools.CRUD;
import mft.model.tools.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class PlaneDa implements AutoCloseable, CRUD<Plane> {
    private final Connection connection;

    @Override
    public void close() throws Exception {

    }

    private PreparedStatement preparedStatement;

    public PlaneDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Plane save(Plane plane) throws Exception {
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
