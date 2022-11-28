package com.revature.Francheska_Pina_P1.Service;

import com.revature.Francheska_Pina_P1.DAO.EmployeeDAO;
import com.revature.Francheska_Pina_P1.DAO.TicketDAO;
import com.revature.Francheska_Pina_P1.Model.Employee;
import com.revature.Francheska_Pina_P1.Model.Ticket;

import java.util.List;


public class TicketService {

    private final TicketDAO ticketDAO;

    private Ticket sessionTicket = null;
    private final EmployeeDAO employeeDAO;
    List<Ticket> ticketsList;

    public TicketService(TicketDAO ticketDAO, EmployeeDAO employeeDAO) {
        this.ticketDAO = ticketDAO;
        this.employeeDAO = employeeDAO;
    }

    public Ticket addEmployee(Ticket ticket){
       return ticketDAO.create(ticket);
    }


    public boolean updateTicket(Ticket ticket){
        return ticketDAO.update(ticket);
    }

    public List<Ticket>getPendingTicket(Employee employee){
        return ticketDAO.findPendingTicket(employee);
    }

    public List<Ticket> getAllTicket(){
        return ticketDAO.findAll();

    }

    public Ticket getTicket(String name){
        return null;
    }

    public Ticket getSessionTicket(){
        return sessionTicket;
    }


}

