package lk.ijse.riceMil.entity;

import java.util.ArrayList;

public class SupplierOrder {
    private String supplierNic;
    private int purchaseOrderId;
    private ArrayList<DeliverDetail> deliverDetails =new ArrayList<>();

    public String getSupplierNic() {
        return supplierNic;
    }

    public void setSupplierNic(String supplierNic) {
        this.supplierNic = supplierNic;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public ArrayList<DeliverDetail> getDiliverDetails() {
        return deliverDetails;
    }

    public void setDiliverDetails(ArrayList<DeliverDetail> deliverDetails) {
        this.deliverDetails = deliverDetails;
    }

    public SupplierOrder(String supplierNic, int purchaseOrderId, ArrayList<DeliverDetail> deliverDetails) {
        this.supplierNic = supplierNic;
        this.purchaseOrderId = purchaseOrderId;
        this.deliverDetails = deliverDetails;
    }

    @Override
    public String toString() {
        return "SupplierOrder{" +
                "supplierNic='" + supplierNic + '\'' +
                ", purchaseOrderId=" + purchaseOrderId +
                ", deliverDetails=" + deliverDetails +
                '}';
    }
}
