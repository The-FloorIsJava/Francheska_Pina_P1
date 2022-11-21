package com.revature.Francheska_Pina_P1.DAO;

import com.revature.Francheska_Pina_P1.Model.Employee;
import com.revature.Francheska_Pina_P1.Util.ConnectionFactory;
import com.revature.Francheska_Pina_P1.Util.Interface.Crudable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements Crudable<Employee> {
    @Override
    public Employee create(Employee newEmployee) {
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){

            String sql = "insert into employee(empName, role, email, username, password) values (?, ? ,? ,? ,?)";
            // PreparedStatements prevent SQL injection
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // set the information for the ?
            preparedStatement.setString(1, newEmployee.getEmpName());
            preparedStatement.setString(2, newEmployee.getRole());
            preparedStatement.setString(3, newEmployee.getEmail());
            preparedStatement.setString(4, newEmployee.getUsername());
            preparedStatement.setString(5, newEmployee.getPassword());

            int checkInsert = preparedStatement.executeUpdate();

            if(checkInsert == 0){
                throw new RuntimeException("Customer was not added to database");
            }

            return newEmployee;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Employee> findAll() {
        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {
            List<Employee> employee = new ArrayList<>();
            String sql = "select * from employee";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                employee.add(convertSQLInfoToEmployee(resultSet));
            }
            return employee;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public boolean update(Employee updatedEmployee) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    private Employee convertSQLInfoToEmployee(ResultSet resultSet) throws SQLException{
        Employee employee = new Employee();

        employee.setEmpId(resultSet.getInt("empId"));
        employee.setEmpName(resultSet.getString("empName"));
        employee.setRole(resultSet.getString("role"));
        employee.setEmail(resultSet.getString("email"));
        employee.setUsername(resultSet.getString("username"));
        employee.setPassword(resultSet.getString("password"));

        return employee;
    }
}
