package com.revature.Francheska_Pina_P1.Service;

import com.revature.Francheska_Pina_P1.DAO.TicketDAO;
import com.revature.Francheska_Pina_P1.Model.Employee;
import com.revature.Francheska_Pina_P1.Model.Ticket;

import java.util.ArrayList;
import java.util.List;


public class TicketService {
//    private Ticket sessionTicket = null;
//    private final TicketDAO ticketDAO;
    List<Ticket> ticketsList;


    public TicketService() {
//        this.ticketDAO = ticketDAO;
        ticketsList = new ArrayList<>();
    }

    public void addEmployee(Ticket employee){
        ticketsList.add(employee);
    }

    public List<Ticket> getAllTicket(){
        return ticketsList;
    }


}

