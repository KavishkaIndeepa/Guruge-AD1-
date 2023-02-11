package lk.ijse.riceMil.entity;

import java.math.BigDecimal;
import java.util.Date;

public class DeliverDetail {
    private int purchaseOrderId;
    private int code;
    private String Description;
    private BigDecimal unitPrice;
    private Date updateDate;
    private int QtyOnHand;


    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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
        return QtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        QtyOnHand = qtyOnHand;
    }

    public DeliverDetail(int purchaseOrderId, int code, String description, BigDecimal unitPrice, Date updateDate, int qtyOnHand) {
        this.purchaseOrderId = purchaseOrderId;
        this.code = code;
        Description = description;
        this.unitPrice = unitPrice;
        this.updateDate = updateDate;
        QtyOnHand = qtyOnHand;
    }

    public DeliverDetail() {

    }

    @Override
    public String toString() {
        return "DeliverDetail{" +
                "purchaseOrderId=" + purchaseOrderId +
                ", code=" + code +
                ", Description='" + Description + '\'' +
                ", unitPrice=" + unitPrice +
                ", updateDate=" + updateDate +
                ", QtyOnHand=" + QtyOnHand +
                '}';
    }
}
