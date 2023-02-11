package lk.ijse.riceMil.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Salary {
   private int salaryId;
   private Date date;
   private BigDecimal payment;
   private String nic;

    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Salary(int salaryId, Date date, BigDecimal payment, String nic) {
        this.salaryId = salaryId;
        this.date = date;
        this.payment = payment;
        this.nic = nic;
    }

    public Salary() {
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId=" + salaryId +
                ", date=" + date +
                ", payment=" + payment +
                ", nic='" + nic + '\'' +
                '}';
    }
}
