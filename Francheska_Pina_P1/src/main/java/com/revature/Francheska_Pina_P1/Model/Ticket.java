package com.revature.Francheska_Pina_P1.Model;

public class Ticket {
    private int reqId;
    private int empId;
    private String type;
    private double amount;
    private String status;

    public Ticket() {
    }

    public Ticket(int reqId, String type, double amount, String status) {
        this.reqId = reqId;
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public Ticket(int empId, int reqId, String type, double amount, String status) {
        this.empId = empId;
        this.reqId = reqId;
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public Ticket(int empId, String type, double amount) {
        this.empId = empId;
        this.type = type;
        this.amount = amount;
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
                "reqId=" + reqId +
                "empId=" + empId +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
