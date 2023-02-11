package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.OrderDetailBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.OrderDetailDAO;
import lk.ijse.riceMil.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.riceMil.dto.CartDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailBOImpl implements OrderDetailBO {

//    OrderDetailDAO dao = new OrderDetailDAOImpl();
OrderDetailDAO dao = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DETAIL);

    public boolean saveOrderDetails(ArrayList<CartDetailDTO> cartDetailDTO) throws SQLException, ClassNotFoundException {
        return dao.saveOrderDetails(cartDetailDTO);

    }


}
