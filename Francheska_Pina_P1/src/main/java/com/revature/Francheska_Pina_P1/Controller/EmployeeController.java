package com.revature.Francheska_Pina_P1.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Francheska_Pina_P1.DAO.EmployeeDAO;
import com.revature.Francheska_Pina_P1.Model.Employee;
import com.revature.Francheska_Pina_P1.Service.EmployeeService;
import com.revature.Francheska_Pina_P1.Service.TicketService;
import com.revature.Francheska_Pina_P1.Util.DTO.LoginCreds;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class EmployeeController {
    EmployeeService employeeService;
    TicketService ticketService;
    Javalin app;


    public EmployeeController(Javalin app, EmployeeService employeeService, TicketService ticketService){
        this.employeeService = employeeService;
        this.ticketService = ticketService;
        this.app = app;
    }

    public void employeeEndpoint(){
        app.get("hello", this::helloHandler);
        app.post("employee",this::postEmployeeHandler);
        app.get("employee", this::getAllEmployeeHandler);
        app.post("employee/{name}",this::getSpecificEmployeeHandler);
        app.post("login", this::loginHandler);
        app.delete("logout", this::logoutHandler);
    }



    // gets a specific employee name
    private void getSpecificEmployeeHandler(Context context){
        String name = context.pathParam("name");
        Employee employee = employeeService.getEmployee(name);
        context.json(employee);
    }

    private void getAllEmployeeHandler(Context context){
        List<Employee>allEmployee = employeeService.getAllEmployee();
        context.json(allEmployee);

    }

    private void postEmployeeHandler(Context context) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Employee employee = mapper.readValue(context.body(), Employee.class);
        employeeService.addEmployee(employee);
        context.json(employee);

        String user = employeeService.getSessionEmployee().getUsername();
        if(user == null){
            context.json("Please try a different username");
        }else {
            context.json("User was added to the system");
        }


    }

    public void helloHandler(Context ctx){
        ctx.result("Hello Welcome to Disney");
    }

    private void loginHandler(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        LoginCreds loginCreds = mapper.readValue(context.body(), LoginCreds.class);
        employeeService.login(loginCreds.getUsername(), loginCreds.getPassword());
        String user = employeeService.getSessionEmployee().getUsername();
        if(user.equals(user)){
            context.json("You love pokemon");
        }else{
            context.json("Employer has successfully logged in");

        }


        context.json( user + " has successfully logged in");
    }

    private void logoutHandler(Context context){
        String employerUser = employeeService.getSessionEmployee().getUsername();
        employeeService.logout();
        context.json(employerUser + "  has logged out");

    }
}
