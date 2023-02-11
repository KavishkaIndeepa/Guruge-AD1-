package lk.ijse.riceMil.entity;

import java.util.Date;

public class PurchaseOrder {
   private int pOrderId;
   private Date date;
   private String nic;

    public int getpOrderId() {
        return pOrderId;
    }

    public void setpOrderId(int pOrderId) {
        this.pOrderId = pOrderId;
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

    public PurchaseOrder(int pOrderId, Date date, String nic) {
        this.pOrderId = pOrderId;
        this.date = date;
        this.nic = nic;
    }

    public PurchaseOrder() {
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "pOrderId=" + pOrderId +
                ", date=" + date +
                ", nic='" + nic + '\'' +
                '}';
    }
}
