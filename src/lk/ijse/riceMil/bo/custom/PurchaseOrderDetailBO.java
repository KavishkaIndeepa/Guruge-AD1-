package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.controller.OrderDeliverFormController;
import lk.ijse.riceMil.dto.SupplierOrderDTO;

import java.sql.SQLException;

public interface PurchaseOrderDetailBO extends SuperBO {
    public void purchaseOrderForm(SupplierOrderDTO supplierOrderDTO, OrderDeliverFormController form) throws SQLException, ClassNotFoundException;
}
