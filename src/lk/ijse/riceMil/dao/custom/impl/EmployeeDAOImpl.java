package lk.ijse.riceMil.dao.custom.impl;

import lk.ijse.riceMil.dao.custom.EmployeeDAO;
import lk.ijse.riceMil.dto.EmployeeDTO;
//import lk.ijse.riceMil.to.Employee;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {
    public boolean save(EmployeeDTO to) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES(?, ?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, to.getNic(), to.getName(), to.getAddress(),
                to.getMobileNo(), to.getUserName(), to.getPassword());
    }

    public EmployeeDTO search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM employee WHERE nic = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new EmployeeDTO(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6)
            );
        }
        return null;
    }
    public boolean Update(EmployeeDTO to) throws ClassNotFoundException, SQLException {

        String sql ="Update employee set name=?, address=? , mobileNo=? , userName=? , password=? Where nic=?";
        return CrudUtil.execute(sql, to.getName(), to.getAddress(), to.getMobileNo(),
                to.getUserName(), to.getPassword(), to.getNic());
    }

    public boolean delete(String nic) throws SQLException, ClassNotFoundException {
        String sql ="DELETE FROM employee WHERE nic='"+nic+"'";
        return CrudUtil.execute(sql);
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM employee");
    }

    public  boolean chack(EmployeeDTO employee) throws SQLException, ClassNotFoundException {
        String sql="SELECT * FROM Employee WHERE userName=? AND password=?";
        ResultSet resultSet=CrudUtil.execute(sql, employee.getUserName(), employee.getPassword());
        return resultSet.next();
    }
}
