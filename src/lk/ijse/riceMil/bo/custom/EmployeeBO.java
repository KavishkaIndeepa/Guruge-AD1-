package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.dto.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {
    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    public EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException;
    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;
    public ResultSet getAllEmployee() throws SQLException, ClassNotFoundException;
    public boolean chackEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
}
