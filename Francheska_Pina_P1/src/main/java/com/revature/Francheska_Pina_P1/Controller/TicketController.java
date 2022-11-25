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
        app.get("ticket", this::getAllTicketHandler);
    }

    private void getAllTicketHandler(Context context) {
        List<Ticket>allTicket = ticketService.getAllTicket();
        context.json(allTicket);
    }

    private void postTicketHandler(Context context) throws JsonProcessingException {
        Employee employee = this.employeeService.getSessionEmployee();
        if(employee == null){
            context.json("You need to login to be able to submit");
            return;
        }
            ObjectMapper mapper = new ObjectMapper();
            Ticket ticket = mapper.readValue(context.body(), Ticket.class);
            ticketService.addEmployee(ticket);
            context.json(ticket);

    }
}
