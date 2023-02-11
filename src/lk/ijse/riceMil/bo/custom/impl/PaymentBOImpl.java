package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.PaymentBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.PaymentDAO;
import lk.ijse.riceMil.dao.custom.impl.PaymentDAOImpl;
import lk.ijse.riceMil.dto.PaymentDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentBOImpl implements PaymentBO {

//    PaymentDAO dao = new PaymentDAOImpl();
PaymentDAO dao = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);


    public boolean savePayment(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException {
        return dao.save(paymentDTO);

    }

    public PaymentDTO searchPayment(String id) throws SQLException, ClassNotFoundException {
        return dao.search(id);

    }

    public boolean updatePayment(PaymentDTO paymentDTO) throws SQLException, ClassNotFoundException {
        return dao.Update(paymentDTO);

    }

    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);

    }

    public ResultSet getAllPayment() throws SQLException, ClassNotFoundException {
        return dao.getAll();

    }
}
