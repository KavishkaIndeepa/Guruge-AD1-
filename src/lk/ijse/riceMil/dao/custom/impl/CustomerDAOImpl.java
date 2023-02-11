package lk.ijse.riceMil.dao.custom.impl;


import lk.ijse.riceMil.dao.custom.CustomerDAO;
import lk.ijse.riceMil.dto.CustomerDTO;
import lk.ijse.riceMil.entity.Customer;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CustomerDAOImpl implements CustomerDAO {

    public  ArrayList<String> loadCustomerNic() throws SQLException, ClassNotFoundException {
        String sql = "SELECT nic FROM Customer";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> nicList = new ArrayList<>();

        while (result.next()) {
            nicList.add(result.getString(1));
        }
        return nicList;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql ="DELETE FROM Customer WHERE nic='"+id+"'";
       return CrudUtil.execute(sql);
    }

    @Override
    public boolean Update(Customer to) throws ClassNotFoundException, SQLException {
        String sql ="Update Customer set name=?, address=? , telNo=? Where nic=?";
        return CrudUtil.execute(sql, to.getName(), to.getAddress(), to.getTelNo(), to.getNic());
    }

    @Override
    public Customer search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Customer WHERE nic = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );
        }
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Customer");
    }

    @Override
    public boolean save(Customer to) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, to.getNic(), to.getName(), to.getAddress(), to.getTelNo());
    }
}
