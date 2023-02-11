package lk.ijse.riceMil.dao.custom.impl;

import lk.ijse.riceMil.dao.custom.PurchaseOrderDAO;
import lk.ijse.riceMil.dto.PurchaseOrderDTO;
//import lk.ijse.riceMil.to.PurchaseOrder;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PurchaseOrderDAOImpl implements PurchaseOrderDAO {
    public boolean save(PurchaseOrderDTO to) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO purchaseOrder VALUES (?, ?, ?)";
        return CrudUtil.execute(sql, to.getpOrderId(), to.getDate(), to.getNic());

    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM purchaseOrder");
    }

    public PurchaseOrderDTO search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM purchaseOrder WHERE pOrderId = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new PurchaseOrderDTO(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3)


            );
        }
        return null;
    }

    public boolean Update(PurchaseOrderDTO to) throws ClassNotFoundException, SQLException {

        String sql = "Update purchaseOrder set date=?, nic=? Where pOrderId=?";
        return CrudUtil.execute(sql, to.getDate(), to.getpOrderId());

    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM purchaseOrder WHERE pOrderId='" + id + "'";
        return CrudUtil.execute(sql);
    }

    public int generateNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT pOrderId FROM purchaseOrder ORDER BY pOrderId DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return result.getInt(1)+1;
        }
        return 1;
    }

}
