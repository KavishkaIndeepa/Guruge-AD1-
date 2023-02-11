package lk.ijse.riceMil.dao.custom.impl;

import lk.ijse.riceMil.dao.custom.OrderDetailDAO;
import lk.ijse.riceMil.dto.CartDetailDTO;
//import lk.ijse.riceMil.to.CartDetail;
import lk.ijse.riceMil.dto.SupplierDTO;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    public boolean saveOrderDetails(ArrayList<CartDetailDTO> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetailDTO cartDetail : cartDetails) {
            if (!save(cartDetail)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean Update(CartDetailDTO to) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public CartDetailDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(CartDetailDTO to) throws SQLException, ClassNotFoundException {
        return false;
    }

}
