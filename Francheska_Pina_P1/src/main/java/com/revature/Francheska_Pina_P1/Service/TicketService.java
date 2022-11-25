package com.revature.Francheska_Pina_P1.Service;

import com.revature.Francheska_Pina_P1.DAO.EmployeeDAO;
import com.revature.Francheska_Pina_P1.DAO.TicketDAO;
import com.revature.Francheska_Pina_P1.Model.Employee;
import com.revature.Francheska_Pina_P1.Model.Ticket;

import java.util.ArrayList;
import java.util.List;


public class TicketService {

    private final TicketDAO ticketDAO;
    private final EmployeeDAO employeeDAO;
    List<Ticket> ticketsList;

    public TicketService(TicketDAO ticketDAO, EmployeeDAO employeeDAO) {
        this.ticketDAO = ticketDAO;
        this.employeeDAO = employeeDAO;
    }




//    public TicketService() {
//        ticketsList = new ArrayList<>();
//    }

    public Ticket addEmployee(Ticket ticket){
       return ticketDAO.create(ticket);
    }

//    public void addEmployee(Ticket employee){
//        ticketsList.add(employee);
//    }

    public List<Ticket> getAllTicket(){
//        return ticketsList;
        return ticketDAO.findAll();

    }

    public Ticket getTicket(String name){
        return null;
    }


}

