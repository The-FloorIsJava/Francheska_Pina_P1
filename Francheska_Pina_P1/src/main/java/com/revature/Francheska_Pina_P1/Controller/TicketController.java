package com.revature.Francheska_Pina_P1.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Francheska_Pina_P1.DAO.TicketDAO;
import com.revature.Francheska_Pina_P1.Model.Employee;
import com.revature.Francheska_Pina_P1.Model.Ticket;
import com.revature.Francheska_Pina_P1.Service.EmployeeService;
import com.revature.Francheska_Pina_P1.Service.TicketService;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class TicketController {
    TicketService ticketService;
    EmployeeService employeeService;
    Javalin app;

    public TicketController(Javalin app, EmployeeService employeeService, TicketService ticketService) {
        this.employeeService = employeeService;
        this.ticketService = ticketService;
        this.app = app;
    }

    public void ticketEndPoint(){
        app.post("ticket", this::postTicketHandler);
        app.get("ticket/manager/pending", this::getAllPendingTicket);
        app.put("ticket/manager", this::putManagerTicketHandler);
        app.get("ticket/status",this::getViewTicketStatus);
    }

    // Were employees views all their ticket status
    private void getViewTicketStatus(Context context) {
        Employee employee = employeeService.getSessionEmployee();
        if(employee == null){
            context.json("You need to login to view pending ticket");
            return;
        }
        List<Ticket>pendingTicket = ticketService.getTicketStatus(employee);
        if(pendingTicket == null){
            context.json("You have no ticket");
            return;
        }

        context.json(pendingTicket);

    }

    // were manager update ticker
    private void putManagerTicketHandler(Context context) throws JsonProcessingException {
        Employee employee = employeeService.getSessionEmployee();
        if(employee == null){
            context.json("You need to login to be able to view this page");
            return;
        }

        String user = employeeService.getSessionEmployee().getRole();
        if(user.equals("manager")){
            ObjectMapper mapper = new ObjectMapper();
            Ticket ticket = mapper.readValue(context.body(), Ticket.class);
            ticketService.updateTicket(ticket);
            context.json(ticket);
            context.json("You were able to update the ticket status");
        }else {
            context.json("Nice try, but that won't work");
        }
    }

    // Only the manager can see the pending list from the employees
    private void getAllPendingTicket(Context context) {
        Employee employee = employeeService.getSessionEmployee();
        if(employee == null){
            context.json("You need to login to be able to view this page");
            return;
        }

        String user = employeeService.getSessionEmployee().getRole();
        if(user.equals("manager")){
            List<Ticket>allTicket = ticketService.getAllPendingTicket();
            context.json(allTicket);
        }else{
            context.json("You are not allow to view this");
        }

    }

    // post the ticket created by user
    private void postTicketHandler(Context context) throws JsonProcessingException {
        Employee employee = employeeService.getSessionEmployee();
        if(employee == null){
            context.json("You need to login to be able to submit");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        Ticket ticket = mapper.readValue(context.body(), Ticket.class);
        ticketService.addEmployee(ticket);
        context.json(ticket);
        context.json("You created a ticket");


    }
}
