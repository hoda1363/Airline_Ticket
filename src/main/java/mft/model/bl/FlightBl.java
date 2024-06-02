package mft.model.bl;

import mft.controller.exceptions.NoFlightFoundException;
import mft.model.da.FlightDa;

import mft.model.entity.Flight;
import mft.model.tools.CRUD;

import java.util.List;

public class FlightBl implements CRUD<Flight> {
    @Override
    public Flight save(Flight flight) throws Exception {
        try (FlightDa flightDa = new FlightDa()) {
            flightDa.save(flight);
            return flight;
        }
    }

    @Override
    public Flight edit(Flight flight) throws Exception {
        try (FlightDa flightDa = new FlightDa()) {
            if (flightDa.findById(flight.getId()) != null) {
                flightDa.edit(flight);
                return flight;
            } else {
                throw new NoFlightFoundException();
            }
        }
    }

    @Override
    public Flight remove(int id) throws Exception {

        try (FlightDa flightDa = new FlightDa()) {
            Flight flight = flightDa.findById(id);
            if (flight != null) {
                flightDa.remove(id);
                return flight;
            } else {
                throw new NoFlightFoundException();
            }
        }
    }

    @Override
    public List<Flight> findAll() throws Exception {
        try (FlightDa flightDa = new FlightDa()) {
            List<Flight> flightList = flightDa.findAll();
            if (!flightList.isEmpty()) {
                return flightList;
            } else {
                throw new NoFlightFoundException();
            }
        }
    }

    @Override
    public Flight findById(int id) throws Exception {
        try (FlightDa flightDa = new FlightDa()) {
            Flight flight = flightDa.findById(id);
            if (flight != null) {
                return flight;
            } else {
                throw new NoFlightFoundException();
            }
        }
    }

    public Flight findByFlightNumber(int flightNumber) throws Exception {
        try (FlightDa flightDa = new FlightDa()) {
            Flight flight = flightDa.findByFlightNumber(flightNumber);
            if (flight != null) {
                return flight;
            } else {
                throw new NoFlightFoundException();
            }

        }
    }
}

