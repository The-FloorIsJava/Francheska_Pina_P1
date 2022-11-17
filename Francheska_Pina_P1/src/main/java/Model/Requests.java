package Model;

public class Requests {
    private int reqId;
    private int empId;
    private String type;
    private int amount;
    private String status;

    public Requests() {
    }

    public Requests(int empId, String type, int amount, String status) {
        this.empId = empId;
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public Requests(int reqId, int empId, String type, int amount, String status) {
        this.reqId = reqId;
        this.empId = empId;
        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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
        return "Requests{" +
                "reqId=" + reqId +
                ", empId=" + empId +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
