package com.revature.Francheska_Pina_P1.Service;

import com.revature.Francheska_Pina_P1.DAO.EmployeeDAO;
import com.revature.Francheska_Pina_P1.DAO.TicketDAO;
import com.revature.Francheska_Pina_P1.Model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private Employee sessionEmployee = null;

    private final EmployeeDAO employeeDAO;
    private final TicketDAO ticketDAO;

    public EmployeeService(EmployeeDAO employeeDAO, TicketDAO ticketDAO){
        this.employeeDAO = employeeDAO;
        this.ticketDAO = ticketDAO;
    }

    // Add employees
    public Employee addEmployee(Employee employee){
       return employeeDAO.create(employee);
    }

    public Employee getEmployee(String name){
        return null;
    }


    public void removeEmployee(String name){

    }

    public List<Employee> getAllEmployee(){
        return employeeDAO.findAll();
    }

    // login from the user
    public void login(String username, String password) {
        sessionEmployee = employeeDAO.loginCheck(username, password);
    }

    // logs out the user
    public void logout(){
        sessionEmployee = null;
    }

    // get the employee session
    public Employee getSessionEmployee(){
        return sessionEmployee;
    }

}
