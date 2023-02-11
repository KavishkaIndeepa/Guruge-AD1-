package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.OrderBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.OrderDAO;
import lk.ijse.riceMil.dao.custom.impl.OrderDAOImpl;
import lk.ijse.riceMil.dto.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderBOImpl implements OrderBO {

   // OrderDAO dao = new OrderDAOImpl();
   OrderDAO dao = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);



    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return dao.save(orderDTO);

    }

    public OrderDTO searchOrder(String id) throws SQLException, ClassNotFoundException {
        return dao.search(id);

    }

    public boolean updateOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return dao.Update(orderDTO);

    }

    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);

    }

    public ResultSet getAllOrder() throws SQLException, ClassNotFoundException {
        return dao.getAll();

    }

    public int generateNextOrderID() throws SQLException, ClassNotFoundException {
        return dao.generateNextOrderId();

    }

    public boolean savePlaceOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        return dao.save(orderDTO);

    }

}
