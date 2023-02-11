package lk.ijse.riceMil.dto;

//import lk.ijse.riceMil.to.DeliverDetail;

import java.util.ArrayList;

public class SupplierOrderDTO {
    private String supplierNic;
    private int purchaseOrderId;
    private ArrayList<DeliverDetailDTO> deliverDetails =new ArrayList<>();

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

    public ArrayList<DeliverDetailDTO> getDiliverDetails() {
        return deliverDetails;
    }

    public void setDiliverDetails(ArrayList<DeliverDetailDTO> deliverDetails) {
        this.deliverDetails = deliverDetails;
    }

    public SupplierOrderDTO(String supplierNic, int purchaseOrderId, ArrayList<DeliverDetailDTO> deliverDetails) {
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
