package lk.ijse.riceMil.dao.custom;

import lk.ijse.riceMil.dao.CrudDAO;
import lk.ijse.riceMil.dto.PurchaseOrderDTO;


import java.sql.ResultSet;
import java.sql.SQLException;

public interface PurchaseOrderDAO extends CrudDAO<PurchaseOrderDTO> {
//    public boolean save(PurchaseOrderDTO purchaseOrder) throws SQLException, ClassNotFoundException;
//    public ResultSet getAll() throws SQLException, ClassNotFoundException;
//    public PurchaseOrderDTO search(String id) throws SQLException, ClassNotFoundException;
//    public boolean Update(PurchaseOrderDTO purchaseOrder) throws ClassNotFoundException, SQLException;
//    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public int generateNextOrderId() throws SQLException, ClassNotFoundException;
}
