package mft.model.da;

import lombok.extern.log4j.Log4j;
import mft.model.entity.Person;
import mft.model.tools.CRUD;
import mft.model.tools.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class PersonDa implements AutoCloseable, CRUD<Person> {
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public PersonDa() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    @Override
    public Person save(Person person) throws Exception {
        person.setId(ConnectionProvider.getConnectionProvider().getNextId("PERSON_SEQ"));

        preparedStatement = connection.prepareStatement(
                "INSERT INTO PERSON_TBL (ID, NAME, FAMILY,national_Id,BIRTH_DATE) VALUES (?,?,?,?,?)"
        );
        preparedStatement.setInt(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.setString(4, person.getNationalId());
        preparedStatement.setDate(5, Date.valueOf(person.getBirthDate()));
        preparedStatement.execute();
        return person;
    }

    @Override
    public Person edit(Person person) throws Exception {
        preparedStatement = connection.prepareStatement(
                "UPDATE PERSON_TBL SET NAME=?,FAMILY=?,national_Id=?,BIRTH_DATE=? WHERE ID=?"
        );
        preparedStatement.setInt(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.setString(4, person.getNationalId());
        preparedStatement.setDate(5, Date.valueOf(person.getBirthDate()));
        preparedStatement.execute();
        return person;
    }

    @Override
    public Person remove(int id) throws Exception {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM PERSON_TBL WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        return null;
    }

    @Override
    public List<Person> findAll() throws Exception {
        List<Person> personList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON_TBL ORDER BY ID");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Person person = Person
                    .builder()
                    .id(resultSet.getInt("ID"))
                    .name(resultSet.getString("NAME"))
                    .family(resultSet.getString("FAMILY"))
                    .family(resultSet.getString("national_Id"))
                    .birthDate(resultSet.getDate("BIRTH_DATE").toLocalDate())
                    .build();

            personList.add(person);
        }

        return personList;
    }

    @Override
    public Person findById(int id) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON_TBL WHERE ID=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Person person = null;
        if (resultSet.next()) {
            person = Person
                    .builder()
                    .id(resultSet.getInt("ID"))
                    .name(resultSet.getString("NAME"))
                    .family(resultSet.getString("FAMILY"))
                    .family(resultSet.getString("national_Id"))
                    .birthDate(resultSet.getDate("BIRTH_DATE").toLocalDate())
                    .build();
        }
        return person;
    }

    public List<Person> findByFamily(String family) throws Exception {
        List<Person> personList = new ArrayList<>();

        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON_TBL WHERE FAMILY LIKE? ORDER BY ID");
        preparedStatement.setString(1, family + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Person person = Person
                    .builder()
                    .id(resultSet.getInt("ID"))
                    .name(resultSet.getString("NAME"))
                    .family(resultSet.getString("FAMILY"))
                    .family(resultSet.getString("national_Id"))
                    .birthDate(resultSet.getDate("BIRTH_DATE").toLocalDate())
                    .build();
            personList.add(person);
        }

        return personList;
    }
    public Person findByNationalId(String nationalId) throws Exception {
        preparedStatement = connection.prepareStatement("SELECT * FROM PERSON_TBL WHERE national_Id=?");
        preparedStatement.setString(1,nationalId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Person person = null;
        if (resultSet.next()) {
            person = Person
                    .builder()
                    .id(resultSet.getInt("ID"))
                    .name(resultSet.getString("NAME"))
                    .family(resultSet.getString("FAMILY"))
                    .family(resultSet.getString("national_Id"))
                    .birthDate(resultSet.getDate("BIRTH_DATE").toLocalDate())
                    .build();
        }
        return person;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
