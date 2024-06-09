package mft.controller;


import jdk.nashorn.internal.objects.annotations.Getter;
import mft.model.entity.Person;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.ws.rs.Path;
import javax.xml.ws.Response;
import java.awt.*;

@Path("/person")
public class PersonController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson() {
        Person person = Person
                .builder()
                .id()
                .name()
                .family()
                .nationalid()
                .birthdate();
                return Response .Status (201).entity(person).build();
    }

@POST
Public person save(

    )
