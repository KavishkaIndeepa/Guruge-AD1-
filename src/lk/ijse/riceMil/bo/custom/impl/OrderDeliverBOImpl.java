package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.OrderDeliverBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.OrderDeliverDAO;
import lk.ijse.riceMil.dao.custom.impl.OrderDeliverDAOImpl;
import lk.ijse.riceMil.dto.DeliverDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDeliverBOImpl implements OrderDeliverBO {

    //OrderDeliverDAO dao = new OrderDeliverDAOImpl();
    OrderDeliverDAO dao = (OrderDeliverDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER_DELIVER);
    public boolean saveDeliverDetails(ArrayList<DeliverDetailDTO> deliverDetailDTO) throws SQLException, ClassNotFoundException {
        return dao.saveDeliverDetails(deliverDetailDTO);

    }
}
