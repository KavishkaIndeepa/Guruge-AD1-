package lk.ijse.riceMil.dao.custom.impl;

import lk.ijse.riceMil.dao.custom.OrderDeliverDAO;
import lk.ijse.riceMil.dto.DeliverDetailDTO;
//import lk.ijse.riceMil.to.DeliverDetail;
import lk.ijse.riceMil.dto.SupplierDTO;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDeliverDAOImpl implements OrderDeliverDAO {
    public  boolean saveDeliverDetails(ArrayList<DeliverDetailDTO> deliverDetails) throws SQLException, ClassNotFoundException {
        for (DeliverDetailDTO deliverDetail : deliverDetails) {
            if (!save(deliverDetail)) {
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
    public boolean Update(DeliverDetailDTO to) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public DeliverDetailDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(DeliverDetailDTO to) throws SQLException, ClassNotFoundException {
        return false;
    }


}
