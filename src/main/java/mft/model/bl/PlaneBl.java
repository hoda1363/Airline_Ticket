package mft.model.bl;

import lombok.Getter;
import mft.controller.exceptions.NoPersonFoundException;
import mft.controller.exceptions.NoPlaneFoundException;
import mft.model.da.PersonDa;
import mft.model.da.PlaneDa;
import mft.model.entity.Person;
import mft.model.entity.Plane;
import mft.model.tools.CRUD;
import java.util.Collections;
import java.util.List;

public class PlaneBl implements CRUD<Plane> {



        @Getter
        private static PlaneBl planeBl = new PlaneBl();

    private Plane() {
        }

        @Override
        public Plane save(Plane plane) throws Exception {
            try (PlaneDa planeBl = new PlaneDa()){
                planeBl.save(plane);
                return plane;
            }

    }

    @Override
    public Plane edit(Plane plane) throws Exception {
        try (PlaneDa planeDa = new PlaneDa()) {
                if (planeDa.findById(plane.getId()) != null) {
                    planeDa.edit(plane);
                    return plane;
                } else {
                    throw new NoPlaneFoundException();
                }
            }

    }

    @Override
    public Plane remove(int id) throws Exception {
            try (PlaneDa planeDa = new PlaneDa()) {
                Plane plane = planeDa.findById(id);
                if (plane != null) {
                    planeDa.remove(id);
                    return plane;
                } else {
                    throw new NoPlaneFoundException();
                }
            }

    }

    @Override
    public List<Plane> findAll() throws Exception {
        try (PlaneDa planeDa = new PlaneDa()) {
            List<Plane> planeList = planeDa.findAll();
            if (!planeList.isEmpty()) {
                return planeList;
            } else {
                throw new NoPlaneFoundException();
            }
        }

    }

    @Override
    public Plane findById(int id) throws Exception {
        try (PlaneDa planeDa = new PlaneDa()) {
            Plane plane = planeDa.findById(id);
            if (plane != null) {
                return plane;
            } else {
                throw new NoPersonFoundException();
            }
        }

    }
}