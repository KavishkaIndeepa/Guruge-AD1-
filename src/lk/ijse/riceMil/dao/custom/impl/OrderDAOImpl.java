package lk.ijse.riceMil.dao.custom.impl;

import lk.ijse.riceMil.dao.custom.OrderDAO;
import lk.ijse.riceMil.dto.OrderDTO;
//import lk.ijse.riceMil.to.Order;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAOImpl implements OrderDAO {
    public boolean save(OrderDTO to) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO orders VALUES(?, ?, ?)";
        return CrudUtil.execute(sql, to.getOrderId(), to.getDate(), to.getNic());

    }

    public OrderDTO search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM orders WHERE orderId = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new OrderDTO(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3)

            );
        }
        return null;
    }

    public boolean Update(OrderDTO to) throws ClassNotFoundException, SQLException {

        String sql = "Update orders set date=?, nic=? Where orderId=?";
        return CrudUtil.execute(sql, to.getDate(), to.getNic(), to.getOrderId());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM orders WHERE orderId='" + id + "'";
        return CrudUtil.execute(sql);
    }

    public int generateNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT orderId FROM Orders ORDER BY orderId DESC LIMIT 1";
        ResultSet result = CrudUtil.execute(sql);

        if (result.next()) {
            return result.getInt(1)+1;
        }
        return 1;
    }
    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM orders");
    }

}
