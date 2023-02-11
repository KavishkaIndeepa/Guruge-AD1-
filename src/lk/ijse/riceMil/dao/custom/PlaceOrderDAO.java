package lk.ijse.riceMil.dao.custom;

import lk.ijse.riceMil.controller.PlaceOrderFormController;
import lk.ijse.riceMil.dao.SuperDAO;
import lk.ijse.riceMil.dto.PlaceOrderDTO;

import java.sql.SQLException;

public interface PlaceOrderDAO extends SuperDAO {
    public void placeOrder(PlaceOrderDTO placeOrder, PlaceOrderFormController form) throws SQLException, ClassNotFoundException;

    }
