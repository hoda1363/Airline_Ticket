package mft.model.bl;

import lombok.Getter;
import mft.controller.exceptions.NoPersonFoundException;
import mft.controller.exceptions.NoTicketFoundException;
import mft.model.da.PersonDa;
import mft.model.da.TicketDa;
import mft.model.entity.Person;
import mft.model.entity.Ticket;
import mft.model.tools.CRUD;

public class TicketBl implements CRUD<Ticket> {
    @Getter
    private static TicketBl ticketBl = new TicketBl();

    private TicketBl() {
    }

    @Override
    public Ticket save(Ticket ticket) throws Exception {
        try (TicketDa ticketDaDa = new TicketDa()) {
            ticketDa.save(ticket);
            return Ticket;
        }
}
@Override
public Ticket edit(Ticket ticket) throws Exception {
    try (TicketDa ticketDa = new TicketDa()) {
        if (ticketDa.findById(ticket.getId()) != null) {
            ticketDa.edit(ticket);
            return Ticket;
        } else {
            throw new NoTicketFoundException();
        }
    }}
   @Override
    public Ticket remove(int id) throws Exception {
        try (TicketDa ticketDa = new TicketDa()) {
            Ticket ticket = ticketDa.findById(id);
            if (ticket!= null) {
                ticketDa.remove(id);
                return Ticket;
            } else {
                throw new NoPersonFoundException();
            }
        }