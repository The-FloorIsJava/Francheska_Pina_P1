package com.revature.Francheska_Pina_P1.Service;

import com.revature.Francheska_Pina_P1.DAO.EmployeeDAO;
import com.revature.Francheska_Pina_P1.Model.Employee;

import java.util.List;

public class EmployeeService {

    private Employee sessionEmployee = null;

    private final EmployeeDAO employeeDAO;

    public EmployeeService(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

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

    public void login(String username, String password) {
        sessionEmployee = employeeDAO.loginCheck(username, password);
    }

    public void logout(){
        sessionEmployee = null;
    }

    public Employee getSessionEmployee(){
        return sessionEmployee;
    }

}
