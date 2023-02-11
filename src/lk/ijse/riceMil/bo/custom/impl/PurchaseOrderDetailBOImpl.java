package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.PurchaseOrderDetailBO;
import lk.ijse.riceMil.controller.OrderDeliverFormController;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.OrderDeliverDAO;
import lk.ijse.riceMil.dao.custom.PurchaseOrderDetailDAO;
import lk.ijse.riceMil.dao.custom.impl.PurchaseOrderDetailDAOImpl;
import lk.ijse.riceMil.dto.SupplierOrderDTO;

import java.sql.SQLException;

public class PurchaseOrderDetailBOImpl implements PurchaseOrderDetailBO {

//    PurchaseOrderDetailDAO dao = new PurchaseOrderDetailDAOImpl();
PurchaseOrderDetailDAO dao = (PurchaseOrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PURCHASE_ORDER_DETAIL);

    public void purchaseOrderForm(SupplierOrderDTO supplierOrderDTO, OrderDeliverFormController form) throws
            SQLException, ClassNotFoundException {
        dao.purchaseOrder(supplierOrderDTO,form);
    }
}

