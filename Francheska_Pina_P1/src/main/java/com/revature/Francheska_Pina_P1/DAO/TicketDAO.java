package com.revature.Francheska_Pina_P1.DAO;

import com.revature.Francheska_Pina_P1.Model.Employee;
import com.revature.Francheska_Pina_P1.Model.Ticket;
import com.revature.Francheska_Pina_P1.Util.ConnectionFactory;
import com.revature.Francheska_Pina_P1.Util.Interface.Crudable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO implements Crudable<Ticket> {
    @Override
    public Ticket create(Ticket newTicket){
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "insert into ticket (empId, type, amount) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,newTicket.getEmpId());
//            preparedStatement.setInt(2, newTicket.getReqId());
            preparedStatement.setString(2,newTicket.getType());
            preparedStatement.setDouble(3,newTicket.getAmount());
            int checkInsert = preparedStatement.executeUpdate();

            if(checkInsert == 0){
                throw new RuntimeException("Your ticket was not added to the database");
            }

            return newTicket;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ticket>findPendingTicket(Employee pendingTicket){


        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {
            List<Ticket> pendingticket = new ArrayList<>();
            String sql = " select * from ticket where empId = ? and status = 'processing' ";
//            String sql = "SELECT ticket.empid FROM ticket INNER JOIN employee ON ticket.empid = employee.empid";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pendingTicket.getEmpId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                pendingticket.add(convertSQLInfoToTicket(resultSet));
            }
            return pendingticket;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Ticket> findAll() {
        try (Connection connection = ConnectionFactory.getConnectionFactory().getConnection()) {
            List<Ticket> ticket = new ArrayList<>();
            String sql = "select * from ticket";
//            String sql = "SELECT ticket.empid FROM ticket INNER JOIN employee ON ticket.empid = employee.empid";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                ticket.add(convertSQLInfoToTicket(resultSet));
            }
            return ticket;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Ticket findById(int id) {
        return null;
    }

    @Override
    public Ticket findByUsername(String username) {
        return null;
    }

    @Override
    public boolean update(Ticket updatedTicket) {
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "UPDATE ticket SET status = ? where reqId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updatedTicket.getStatus());
            preparedStatement.setInt(2,updatedTicket.getReqId());

            int checkInsert = preparedStatement.executeUpdate();

            if(checkInsert == 0){
                throw new RuntimeException("The ticket was not updated");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        return false;
    }



    private Ticket convertSQLInfoToTicket(ResultSet resultSet)throws SQLException{
        Ticket ticket = new Ticket();
        ticket.setEmpId(resultSet.getInt("empId"));
        ticket.setReqId(resultSet.getInt("reqId"));
        ticket.setType(resultSet.getString("type"));
        ticket.setAmount(resultSet.getDouble("amount"));
        ticket.setStatus(resultSet.getString("status"));
        return ticket;
    }
}
