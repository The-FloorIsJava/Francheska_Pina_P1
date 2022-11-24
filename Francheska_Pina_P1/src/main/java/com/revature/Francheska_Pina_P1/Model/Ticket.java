package com.revature.Francheska_Pina_P1.Model;

public class Ticket {
    private int empId;
    private int reqId;
    private String username;
    private String password;
    private String type;
    private double amount;
    private String status;

    public Ticket() {
    }

    public Ticket(int reqId, String username, String password, String type, double amount, String status) {
        this.reqId = reqId;
        this.username = username;
        this.password = password;
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public Ticket(int empId, int reqId, String username, String password, String type, double amount, String status) {
        this.empId = empId;
        this.reqId = reqId;
        this.username = username;
        this.password = password;
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                ", reqId=" + reqId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
