package com.revature.Francheska_Pina_P1.Model;

public class Requests {
    private String username;
    private String password;
    private String type;
    private int empId;
    private int reqId;
    private String status;

    public Requests() {
    }

    public Requests(String username, String password, String type, int empId, int reqId, String status) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.empId = empId;
        this.reqId = reqId;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Requests{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", empId=" + empId +
                ", reqId=" + reqId +
                ", status='" + status + '\'' +
                '}';
    }
}
