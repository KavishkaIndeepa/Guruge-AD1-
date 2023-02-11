package lk.ijse.riceMil.dao.custom;

import lk.ijse.riceMil.dao.CrudDAO;
import lk.ijse.riceMil.dto.CustomerDTO;
import lk.ijse.riceMil.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {
//    public boolean delete(String id) throws SQLException, ClassNotFoundException;
//    public boolean Update(CustomerDTO customer) throws ClassNotFoundException, SQLException;
//    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException;
//    public ResultSet getAll() throws SQLException, ClassNotFoundException;
//    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException;
public ArrayList<String> loadCustomerNic() throws SQLException, ClassNotFoundException;
}
