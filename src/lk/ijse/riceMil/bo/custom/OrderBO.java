package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.dto.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderBO extends SuperBO {
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
    public OrderDTO searchOrder(String id) throws SQLException, ClassNotFoundException;
    public boolean updateOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException;
    public ResultSet getAllOrder() throws SQLException, ClassNotFoundException;
    public int generateNextOrderID() throws SQLException, ClassNotFoundException;
    public boolean savePlaceOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
}
