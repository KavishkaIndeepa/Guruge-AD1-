package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.PurchaseOrderBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.PurchaseOrderDAO;
import lk.ijse.riceMil.dao.custom.impl.PurchaseOrderDAOImpl;
import lk.ijse.riceMil.dto.PurchaseOrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {
    //PurchaseOrderDAO dao = new PurchaseOrderDAOImpl();
    PurchaseOrderDAO dao = (PurchaseOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PURCHASE_ORDER);



    public boolean savePurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) throws SQLException, ClassNotFoundException {
        return dao.save(purchaseOrderDTO);

    }

    public ResultSet getAllPurchaseOrder() throws SQLException, ClassNotFoundException {
        return dao.getAll();

    }

    public PurchaseOrderDTO searchPurchaseOrder(String id ) throws SQLException, ClassNotFoundException {
        return dao.search(id);

    }

    public boolean updatePurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) throws SQLException, ClassNotFoundException {
        return dao.Update(purchaseOrderDTO);

    }

    public boolean deletePurchaseOrder(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);

    }

    public int generateNextOrderId() throws SQLException, ClassNotFoundException {
        return dao.generateNextOrderId();

    }

    public boolean savePurchaseOrders(PurchaseOrderDTO purchaseOrderDTO) throws SQLException, ClassNotFoundException {
        return dao.save(purchaseOrderDTO);

    }
}
