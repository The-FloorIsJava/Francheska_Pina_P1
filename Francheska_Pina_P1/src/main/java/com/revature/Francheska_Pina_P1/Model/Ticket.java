package com.revature.Francheska_Pina_P1.Model;

public class Ticket {
    private int empId;
    private int reqID;
    private String username;
    private String password;
    private double amount;
    private String status;

    public Ticket() {
    }

    public Ticket(int reqID, String username, String password, double amount, String status) {
        this.reqID = reqID;
        this.username = username;
        this.password = password;
        this.amount = amount;
        this.status = status;
    }

    public Ticket(int empId, int reqID, String username, String password, String type, double amount, String status) {
        this.empId = empId;
        this.reqID = reqID;
        this.username = username;
        this.password = password;
        this.amount = amount;
        this.status = status;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getReqID() {
        return reqID;
    }

    public void setReqID(int reqID) {
        this.reqID = reqID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "empId=" + empId +
                ", reqID=" + reqID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
