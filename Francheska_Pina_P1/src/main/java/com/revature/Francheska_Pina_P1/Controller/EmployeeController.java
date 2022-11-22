package com.revature.Francheska_Pina_P1.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Francheska_Pina_P1.DAO.EmployeeDAO;
import com.revature.Francheska_Pina_P1.Model.Employee;
import com.revature.Francheska_Pina_P1.Service.EmployeeService;
import com.revature.Francheska_Pina_P1.Util.DTO.LoginCreds;
import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

public class EmployeeController {
    EmployeeService employeeService;
    Javalin app;


    public EmployeeController(Javalin app){
        employeeService = new EmployeeService(new EmployeeDAO());
        this.app = app;
    }

    public void employeeEndpoint(){
        app.get("hello", this::helloHandler);
        app.post("employee",this::postEmployeeHandler);
        app.get("employee", this::getAllEmployeeHandler);
        app.post("employee/{name}",this::getSpecificEmployeeHandler);
        app.post("login", this::login);
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
    }

    public void helloHandler(Context ctx){
        ctx.result("Hello Welcome to Disney");
    }

    private void login(Context context) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        LoginCreds loginCreds = mapper.readValue(context.body(), LoginCreds.class);
        employeeService.login(loginCreds.getUsername(), loginCreds.getPassword());
        context.json("You are log in");
    }
}
