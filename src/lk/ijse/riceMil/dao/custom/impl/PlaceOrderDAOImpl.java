package lk.ijse.riceMil.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.riceMil.bo.BOFactory;
import lk.ijse.riceMil.bo.custom.AttendanceBO;
import lk.ijse.riceMil.bo.custom.ItemBO;
import lk.ijse.riceMil.bo.custom.OrderBO;
import lk.ijse.riceMil.bo.custom.OrderDetailBO;
import lk.ijse.riceMil.bo.custom.impl.ItemBOImpl;
import lk.ijse.riceMil.bo.custom.impl.OrderBOImpl;
import lk.ijse.riceMil.bo.custom.impl.OrderDetailBOImpl;
import lk.ijse.riceMil.controller.PlaceOrderFormController;
import lk.ijse.riceMil.dao.custom.*;
import lk.ijse.riceMil.db.DBConnection;
import lk.ijse.riceMil.dto.OrderDTO;
import lk.ijse.riceMil.dto.PlaceOrderDTO;
//import lk.ijse.riceMil.model.ItemModel;
//import lk.ijse.riceMil.model.OrderDetailModel;
//import lk.ijse.riceMil.model.OrderModel;
//import lk.ijse.riceMil.to.PlaceOrder;

import java.sql.SQLException;
import java.time.LocalDate;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {

    //OrderDetailBO orderDetailBO = new OrderDetailBOImpl();
    // OrderBO orderBO = new OrderBOImpl();
    // ItemBO itemBO = new ItemBOImpl();

    ItemBO itemBO = (ItemBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.ITEM);
    OrderDetailBO orderDetailBO = (OrderDetailBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.ORDER_DETAIL);
    OrderBO orderBO = (OrderBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.ORDER);

    public void placeOrder(PlaceOrderDTO placeOrder, PlaceOrderFormController form) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean isOrderAdded = orderBO.savePlaceOrder(new OrderDTO(placeOrder.getOrderId(), LocalDate.now().toString(), placeOrder.getCustomerNic()));
            if (isOrderAdded) {
                boolean isUpdated = itemBO.updateQtys(placeOrder.getOrderDetail());
                if (isUpdated) {
                    boolean isOrderDetailAdded = orderDetailBO.saveOrderDetails(placeOrder.getOrderDetail());
                    if (isOrderDetailAdded) {
                        //form.clear();
                        new Alert(Alert.AlertType.CONFIRMATION, "Order Placed!").show();
                        DBConnection.getInstance().getConnection().commit();
                    }
                }
            }
            DBConnection.getInstance().getConnection().rollback();
            new Alert(Alert.AlertType.ERROR, "Order Not Placed!").show();
        } catch (SQLException | ClassNotFoundException ignored) {
        } finally {
            try {
                DBConnection.getInstance().getConnection().setAutoCommit(true);
            } catch (SQLException | ClassNotFoundException ignored) {
            }
        }
    }
}
