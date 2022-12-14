package com.revature.Francheska_Pina_P1.Model;

public class Employee {
    private int empId;
    private String empName;
    private String role;
    private String email;
    private String username;
    private String password;

    public Employee() {
    }

    public Employee(String empName, String role, String email, String username, String password) {
        this.empName = empName;
        this.role = role;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Employee(int empId, String empName, String role, String email, String username, String password) {
        this.empId = empId;
        this.empName = empName;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
