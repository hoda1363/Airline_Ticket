package mft.model.bl;

import lombok.Getter;

import mft.controller.exceptions.NoPersonFoundException;
import mft.controller.exceptions.NoTicketFoundException;
import mft.model.da.TicketDa;
import mft.model.entity.Ticket;
import mft.model.entity.enums.Airline;
import mft.model.tools.CRUD;
import java.time.LocalDateTime;
import java.util.List;


    public class TicketBl implements CRUD<Ticket> {
        @Getter
        private static TicketBl ticketBl = new TicketBl();

        private TicketBl() {
        }

        @Override
        public Ticket save(Ticket ticket) throws Exception {
            try (TicketDa ticketDa = new TicketDa()) {
                ticketDa.save(ticket);
                return ticket;
            }
        }

        @Override
        public Ticket edit(Ticket ticket) throws Exception {
            try (TicketDa ticketDa = new TicketDa()) {
                if (ticketDa.findById(ticket.getId()) != null) {
                    ticketDa.edit(ticket);
                    return ticket;
                } else {
                    throw new NoTicketFoundException();
                }
            }
        }

        @Override
        public Ticket remove(int id) throws Exception {
            try (TicketDa ticketDa = new TicketDa()) {
                Ticket ticket = ticketDa.findById(id);
                if (ticket != null) {
                    ticketDa.remove(id);
                    return ticket;
                } else {
                    throw new NoPersonFoundException();
                }
            }
        }

        @Override
        public List<Ticket> findAll() throws Exception {
            try (TicketDa ticketDa = new TicketDa()) {
                List<Ticket> ticketList = ticketDa.findAll();
                if (!ticketList.isEmpty()) {
                    return ticketList;
                } else {
                    throw new NoTicketFoundException();
                }

            }
        }

        public Ticket findById(int id) throws Exception {
            try (TicketDa ticketDa = new TicketDa()) {
                Ticket ticket = ticketDa.findById(id);
                if (ticket != null) {
                    return ticket;
                } else {
                    throw new NoTicketFoundException();
                }
            }

        }

        public Ticket findByAirline(Airline airline) throws Exception {
            try (TicketDa ticketDa = new TicketDa()){
                Ticket ticket = ticketDa.findByAirline(airline);
                if (ticket!= null) {
                    return ticket;
                } else {
                    throw new NoTicketFoundException();
                }
            }
        }
        public Ticket findByFlightId(int flightId) throws Exception {
            try (TicketDa ticketDa = new TicketDa()) {
                Ticket ticket = ticketDa.findByFlightId(flightId);
                if (ticket != null) {
                    return ticket;

                } else {
                    throw new NoTicketFoundException();
                }

            }
        }
        public Ticket findBySource(String source) throws Exception {
            try (TicketDa ticketDa = new TicketDa()){
                Ticket ticket = ticketDa.findBySource(source);
                if (ticket!= null) {
                    return ticket;

                }else {
                    throw new NoTicketFoundException();
                }
            }
        }



        public Ticket findByDestination(String destination) throws Exception {
            try (TicketDa ticketDa = new TicketDa()){
                Ticket ticket = ticketDa.findByDestination(destination);
                if (ticket!= null) {
                    return ticket;

                }else {
                    throw new NoTicketFoundException();
                }
            }
        }

        public Ticket findByDateTime(LocalDateTime dateTime) throws Exception {
            try (TicketDa ticketDa = new TicketDa()){
                Ticket ticket = ticketDa.findByDateTime(dateTime);
                if (ticket!= null) {
                    return ticket;

                }else {
                    throw new NoTicketFoundException();
                }
            }
        }

}


