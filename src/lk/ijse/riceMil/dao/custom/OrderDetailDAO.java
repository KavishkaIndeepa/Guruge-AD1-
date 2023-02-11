package lk.ijse.riceMil.dao.custom;

import lk.ijse.riceMil.dao.CrudDAO;
import lk.ijse.riceMil.dto.CartDetailDTO;
//import lk.ijse.riceMil.to.CartDetail;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDetailDAO extends CrudDAO<CartDetailDTO> {
    public boolean saveOrderDetails(ArrayList<CartDetailDTO> cartDetails) throws SQLException, ClassNotFoundException;
//    boolean save(CartDetailDTO cartDetail) throws SQLException, ClassNotFoundException;
}
