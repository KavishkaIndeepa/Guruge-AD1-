package lk.ijse.riceMil.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.riceMil.bo.BOFactory;
import lk.ijse.riceMil.bo.custom.AttendanceBO;
import lk.ijse.riceMil.bo.custom.ItemBO;
import lk.ijse.riceMil.bo.custom.OrderDeliverBO;
import lk.ijse.riceMil.bo.custom.PurchaseOrderBO;
import lk.ijse.riceMil.bo.custom.impl.ItemBOImpl;
import lk.ijse.riceMil.bo.custom.impl.OrderDeliverBOImpl;
import lk.ijse.riceMil.bo.custom.impl.PurchaseOrderBOImpl;
import lk.ijse.riceMil.controller.OrderDeliverFormController;
import lk.ijse.riceMil.dao.custom.ItemDAO;
import lk.ijse.riceMil.dao.custom.OrderDeliverDAO;
import lk.ijse.riceMil.dao.custom.PurchaseOrderDAO;
import lk.ijse.riceMil.dao.custom.PurchaseOrderDetailDAO;
import lk.ijse.riceMil.db.DBConnection;
import lk.ijse.riceMil.dto.PurchaseOrderDTO;
import lk.ijse.riceMil.dto.SupplierOrderDTO;
//import lk.ijse.riceMil.model.ItemModel;
//import lk.ijse.riceMil.model.OrderDeliverModel;
//import lk.ijse.riceMil.model.PurchaseOrderModel;
//import lk.ijse.riceMil.to.PurchaseOrder;
//import lk.ijse.riceMil.to.SupplierOrder;

import java.sql.SQLException;
import java.time.LocalDate;

public class PurchaseOrderDetailDAOImpl implements PurchaseOrderDetailDAO {

   // OrderDeliverBO orderDeliverBO = new OrderDeliverBOImpl();
   // PurchaseOrderBO purchaseOrderBO = new PurchaseOrderBOImpl();
   // ItemBO itemBO = new ItemBOImpl();

    ItemBO itemBO  = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.ITEM);
    OrderDeliverBO orderDeliverBO  = (OrderDeliverBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.ORDER_DELIVER);
    PurchaseOrderBO purchaseOrderBO  = (PurchaseOrderBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.PURCHASE_ORDER);

    public void purchaseOrder(SupplierOrderDTO supplierOrder, OrderDeliverFormController form) throws SQLException, ClassNotFoundException {

        try {

            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isOrderAdded = purchaseOrderBO.savePurchaseOrders(new PurchaseOrderDTO(supplierOrder.getPurchaseOrderId(), LocalDate.now().toString(), supplierOrder.getSupplierNic()));
            if (isOrderAdded) {
                boolean isUpdated = itemBO.increaseQty(supplierOrder.getDiliverDetails());
                if (isUpdated) {
                    boolean isOrderDetailAdded = orderDeliverBO.saveDeliverDetails(supplierOrder.getDiliverDetails());
                    if (isOrderDetailAdded) {
                        // form.clear();
                        new Alert(Alert.AlertType.CONFIRMATION, "Order Purchase!").show();
                        DBConnection.getInstance().getConnection().commit();
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            new Alert(Alert.AlertType.ERROR, "Order Not Purchase!").show();
        } catch (SQLException | ClassNotFoundException ignored) {
        } finally {
            try {
                DBConnection.getInstance().getConnection().setAutoCommit(true);
            } catch (SQLException | ClassNotFoundException ignored) {
            }
        }
    }
}
