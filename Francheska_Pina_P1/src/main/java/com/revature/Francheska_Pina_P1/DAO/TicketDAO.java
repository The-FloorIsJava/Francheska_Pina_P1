package com.revature.Francheska_Pina_P1.DAO;

import com.revature.Francheska_Pina_P1.Model.Ticket;
import com.revature.Francheska_Pina_P1.Util.ConnectionFactory;
import com.revature.Francheska_Pina_P1.Util.Interface.Crudable;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TicketDAO implements Crudable<Ticket> {
    @Override
    public Ticket create(Ticket newTicket){
        try(Connection connection = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "insert into ticket(empID, type, amount) values (?, ? ,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,newTicket.getEmpId());
            preparedStatement.setString(2,newTicket.getType());
            preparedStatement.setDouble(3,newTicket.getAmount());

            int checkInsert = preparedStatement.executeUpdate();

            if(checkInsert == 0){
                throw new RuntimeException("Your ticket was not added to database");
            }


            return newTicket;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ticket> findAll() {
        return null;
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
    public boolean update(Ticket updatedObject) {
        return false;
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
