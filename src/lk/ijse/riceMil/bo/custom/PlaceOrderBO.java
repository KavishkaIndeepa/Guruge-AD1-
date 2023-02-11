package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.controller.PlaceOrderFormController;
import lk.ijse.riceMil.dto.PlaceOrderDTO;

import java.sql.SQLException;

public interface PlaceOrderBO extends SuperBO {
    public void placeOrderForm(PlaceOrderDTO placeOrderDTO, PlaceOrderFormController placeOrderFormController) throws
            SQLException, ClassNotFoundException;
}
