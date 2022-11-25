package com.revature.Francheska_Pina_P1;

import com.revature.Francheska_Pina_P1.Controller.EmployeeController;
import com.revature.Francheska_Pina_P1.Controller.TicketController;
import com.revature.Francheska_Pina_P1.DAO.EmployeeDAO;
import com.revature.Francheska_Pina_P1.DAO.TicketDAO;
import com.revature.Francheska_Pina_P1.Service.EmployeeService;
import com.revature.Francheska_Pina_P1.Service.TicketService;
import io.javalin.Javalin;

public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(8081);

        EmployeeService employeeService = new EmployeeService(new EmployeeDAO(), new TicketDAO());
        TicketService ticketService = new TicketService(new TicketDAO(), new EmployeeDAO());

        new EmployeeController(app, employeeService, ticketService).employeeEndpoint();
        new TicketController(app, employeeService, ticketService).ticketEndPoint();
//        TicketController ticketController = new TicketController(employeeService);
//        ticketController.ticketEndPoint(app);
    }
}
