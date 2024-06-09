package mft.controller;

import mft.model.entity.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson() {
        Person person = Person
                .builder()
                .id(1)
                .name("")
                .family("")
                .nationalId("12345")
                .birthDate(null)
                .build();
        return Response.status(201).entity(person).build();
    }
}
