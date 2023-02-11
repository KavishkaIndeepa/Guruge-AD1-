package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.dto.PurchaseOrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PurchaseOrderBO extends SuperBO {
    public boolean savePurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) throws SQLException, ClassNotFoundException;
    public ResultSet getAllPurchaseOrder() throws SQLException, ClassNotFoundException;
    public PurchaseOrderDTO searchPurchaseOrder(String id ) throws SQLException, ClassNotFoundException;
    public boolean updatePurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) throws SQLException, ClassNotFoundException;
    public boolean deletePurchaseOrder(String id) throws SQLException, ClassNotFoundException;
    public int generateNextOrderId() throws SQLException, ClassNotFoundException;
    public boolean savePurchaseOrders(PurchaseOrderDTO purchaseOrderDTO) throws SQLException, ClassNotFoundException;

}
