package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.PlaceOrderBO;
import lk.ijse.riceMil.controller.PlaceOrderFormController;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.PlaceOrderDAO;
import lk.ijse.riceMil.dao.custom.impl.PlaceOrderDAOImpl;
import lk.ijse.riceMil.dto.PlaceOrderDTO;

import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {

//    PlaceOrderDAO dao = new PlaceOrderDAOImpl();
PlaceOrderDAO dao = (PlaceOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PLACE_ORDER);

    public void placeOrderForm(PlaceOrderDTO  placeOrderDTO, PlaceOrderFormController placeOrderFormController)
            throws SQLException, ClassNotFoundException {
        dao.placeOrder(placeOrderDTO,placeOrderFormController);
    }
}
