package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.dto.CartDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailBO extends SuperBO {
    public boolean saveOrderDetails(ArrayList<CartDetailDTO> cartDetailDTO) throws SQLException, ClassNotFoundException;
}
