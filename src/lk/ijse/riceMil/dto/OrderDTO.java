package lk.ijse.riceMil.dto;

public class OrderDTO {
    private int orderId;
    private String date;
    private String nic;



    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public OrderDTO(int orderId, String date, String nic) {
        this.orderId = orderId;
        this.date = date;
        this.nic = nic;
    }



    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", date='" + date + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}
