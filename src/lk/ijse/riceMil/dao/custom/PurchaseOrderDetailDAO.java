package lk.ijse.riceMil.dao.custom;

import lk.ijse.riceMil.controller.OrderDeliverFormController;
import lk.ijse.riceMil.dao.SuperDAO;
import lk.ijse.riceMil.dto.SupplierOrderDTO;

import java.sql.SQLException;

public interface PurchaseOrderDetailDAO extends SuperDAO {
    public void purchaseOrder(SupplierOrderDTO supplierOrder, OrderDeliverFormController form) throws SQLException, ClassNotFoundException;
}
