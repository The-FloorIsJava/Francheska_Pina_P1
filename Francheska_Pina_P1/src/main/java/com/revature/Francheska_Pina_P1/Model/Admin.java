package com.revature.Francheska_Pina_P1.Model;

public class Admin {
    private int empId;
    private String empName;
    private String email;
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(String empName, String email, String username, String password) {
        this.empName = empName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Admin(int empId, String empName, String email, String username, String password) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Admin{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
