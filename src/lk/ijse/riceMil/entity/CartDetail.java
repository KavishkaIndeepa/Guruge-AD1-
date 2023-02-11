package lk.ijse.riceMil.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CartDetail {
    private int orderId;
    private int code;
    private String description;
    private BigDecimal unitPrice;
    private Date updateDate;
    private int qtyOnHand;


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public CartDetail(int orderId, int code, String description, BigDecimal unitPrice, Date updateDate, int qtyOnHand) {
        this.orderId = orderId;
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.updateDate = updateDate;
        this.qtyOnHand = qtyOnHand;
    }

    public CartDetail() {
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "orderId=" + orderId +
                ", code=" + code +
                ", description='" + description + '\'' +
                ", unitPrice=" + unitPrice +
                ", updateDate=" + updateDate +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
