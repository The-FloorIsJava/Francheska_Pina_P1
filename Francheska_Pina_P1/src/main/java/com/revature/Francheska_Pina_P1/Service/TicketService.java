package com.revature.Francheska_Pina_P1.Service;

import com.revature.Francheska_Pina_P1.DAO.TicketDAO;
import com.revature.Francheska_Pina_P1.Model.Ticket;

import java.util.List;


public class TicketService {
    private Ticket sessionTicket = null;
    private final TicketDAO ticketDAO;
//    List<Ticket>ticketsList;


    public TicketService(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public Ticket addTicket(Ticket ticket){
        return ticketDAO.create(ticket);
    }
}

