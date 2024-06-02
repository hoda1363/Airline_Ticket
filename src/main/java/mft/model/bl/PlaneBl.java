package mft.model.bl;

import mft.controller.exceptions.NoFlightFoundException;
import mft.model.da.FlightDa;
import mft.model.da.PlaneDa;
import mft.model.entity.Flight;
import mft.model.entity.Plane;
import mft.model.tools.CRUD;

public class PlaneBl implements CRUD<Plane> {
    public Plane findById(int id) throws Exception {
        try (PlaneDa planeDaDa = new PlaneDa()) {
           Plane plane = PlaneDa.;
            if (flight != null) {
                return flight;
            } else {
                throw new NoFlightFoundException();
            }
}
