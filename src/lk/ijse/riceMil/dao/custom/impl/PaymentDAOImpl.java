package lk.ijse.riceMil.dao.custom.impl;

import lk.ijse.riceMil.dao.custom.PaymentDAO;
//import lk.ijse.riceMil.to.Payment;
import lk.ijse.riceMil.dto.PaymentDTO;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDAOImpl implements PaymentDAO {
    public boolean save(PaymentDTO to) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO payment VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, to.getPaymentId(), to.getDate(), to.getPayment(), to.getNic());
    }
    public PaymentDTO search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM payment WHERE paymentId = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new PaymentDTO(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)

            );
        }
        return null;
    }
    public boolean Update(PaymentDTO to) throws ClassNotFoundException, SQLException {

        String sql = "Update payment set date=?, payment=?, nic=? Where paymentId=?";
        return CrudUtil.execute(sql, to.getDate(), to.getPayment(), to.getNic(), to.getPaymentId());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM payment WHERE paymentId='" + id + "'";
        return CrudUtil.execute(sql);
    }
    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM payment");
    }
}
