package lk.ijse.riceMil.dao.custom;

import lk.ijse.riceMil.dao.CrudDAO;
import lk.ijse.riceMil.dto.DeliverDetailDTO;
//import lk.ijse.riceMil.to.DeliverDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDeliverDAO extends CrudDAO<DeliverDetailDTO> {
    public boolean saveDeliverDetails(ArrayList<DeliverDetailDTO> deliverDetails) throws SQLException, ClassNotFoundException;
//    boolean save(DeliverDetailDTO deliverDetail) throws SQLException, ClassNotFoundException;
}
