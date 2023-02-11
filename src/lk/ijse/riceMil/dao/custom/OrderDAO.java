package lk.ijse.riceMil.dao.custom;

import lk.ijse.riceMil.dao.CrudDAO;
import lk.ijse.riceMil.dto.OrderDTO;
//import lk.ijse.riceMil.to.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<OrderDTO> {
//    public boolean save(OrderDTO order) throws SQLException, ClassNotFoundException;
//    public OrderDTO search(String id) throws SQLException, ClassNotFoundException;
//    public boolean Update(OrderDTO order) throws ClassNotFoundException, SQLException;
//    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public int generateNextOrderId() throws SQLException, ClassNotFoundException;
//    public ResultSet getAll() throws SQLException, ClassNotFoundException;
}
