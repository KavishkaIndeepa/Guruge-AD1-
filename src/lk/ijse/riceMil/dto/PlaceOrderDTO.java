package lk.ijse.riceMil.dto;

//import lk.ijse.riceMil.to.CartDetail;

import java.util.ArrayList;

public class PlaceOrderDTO {
    private String customerNic;
    private int orderId;
    private ArrayList<CartDetailDTO> orderDetail=new ArrayList<>();

    public String getCustomerNic() {
        return customerNic;
    }

    public void setCustomerNic(String customerNic) {
        this.customerNic = customerNic;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<CartDetailDTO> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(ArrayList<CartDetailDTO> orderDetail) {
        this.orderDetail = orderDetail;
    }

    public PlaceOrderDTO(String customerNic, int orderId, ArrayList<CartDetailDTO> orderDetail) {
        this.customerNic = customerNic;
        this.orderId = orderId;
        this.orderDetail = orderDetail;
    }

    public PlaceOrderDTO() {
    }

    @Override
    public String toString() {
        return "PlaceOrder{" +
                "customerNic='" + customerNic + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderDetail=" + orderDetail +
                '}';
    }
}
