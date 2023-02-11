package lk.ijse.riceMil.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {
    private int paymentId;
    private Date date;
    private BigDecimal payment;
    private String nic;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
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

    public Payment(int paymentId, Date date, BigDecimal payment, String nic) {
        this.paymentId = paymentId;
        this.date = date;
        this.payment = payment;
        this.nic = nic;
    }

    public Payment() {
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", date=" + date +
                ", payment=" + payment +
                ", nic='" + nic + '\'' +
                '}';
    }
}
