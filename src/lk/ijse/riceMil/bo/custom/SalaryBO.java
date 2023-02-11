package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.dto.SalaryDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SalaryBO extends SuperBO {
    public boolean saveSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;
    public ResultSet getAllSalary() throws SQLException, ClassNotFoundException;
    public SalaryDTO searchSalary(String id) throws SQLException, ClassNotFoundException;
    public boolean updateSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteSalary(String id) throws SQLException, ClassNotFoundException;
}
