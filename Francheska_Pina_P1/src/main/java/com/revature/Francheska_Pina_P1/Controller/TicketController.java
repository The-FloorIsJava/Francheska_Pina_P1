package com.revature.Francheska_Pina_P1.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Francheska_Pina_P1.DAO.TicketDAO;
import com.revature.Francheska_Pina_P1.Model.Employee;
import com.revature.Francheska_Pina_P1.Model.Ticket;
import com.revature.Francheska_Pina_P1.Service.TicketService;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class TicketController {
    TicketService ticketService;
    Javalin app;

    public TicketController(Javalin app) {
        ticketService = new TicketService(new TicketDAO());
        this.app = app;
    }

    public void ticketEndPoint(){
        app.post("ticket", this::postTicketHandler);
    }

    private void postTicketHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Ticket ticket = mapper.readValue(context.body(), Ticket.class);
        ticketService.addTicket(ticket);
        context.json(ticket);
    }
}
