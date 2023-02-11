package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.dto.DeliverDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDeliverBO extends SuperBO {
    public boolean saveDeliverDetails(ArrayList<DeliverDetailDTO> deliverDetailDTO) throws SQLException, ClassNotFoundException;
}
