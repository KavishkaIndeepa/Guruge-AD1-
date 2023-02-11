package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.dto.PaymentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PaymentBO extends SuperBO {
    public boolean savePayment(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException;
    public PaymentDTO searchPayment(String id) throws SQLException, ClassNotFoundException;
    public boolean updatePayment(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException;
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException;
    public ResultSet getAllPayment() throws SQLException, ClassNotFoundException;
}
