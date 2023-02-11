package lk.ijse.riceMil.entity;

import java.util.Date;

public class Order {
     private int orderId;
     private Date date;
     private String nic;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Order(int orderId, Date date, String nic) {
        this.orderId = orderId;
        this.date = date;
        this.nic = nic;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", date=" + date +
                ", nic='" + nic + '\'' +
                '}';
    }
}
