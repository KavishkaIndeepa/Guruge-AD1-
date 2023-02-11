package lk.ijse.riceMil.dao.custom;

import lk.ijse.riceMil.dao.CrudDAO;
import lk.ijse.riceMil.dto.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<EmployeeDTO> {
//    public boolean save(EmployeeDTO employee) throws SQLException, ClassNotFoundException;
//    public EmployeeDTO search(String id) throws SQLException, ClassNotFoundException;
//    public boolean Update(EmployeeDTO employee) throws ClassNotFoundException, SQLException;
//    public boolean delete(String nic) throws SQLException, ClassNotFoundException;
//    public ResultSet getAll() throws SQLException, ClassNotFoundException;
    public  boolean chack(EmployeeDTO employee) throws SQLException, ClassNotFoundException;

    }
