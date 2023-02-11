package lk.ijse.riceMil.dao;

import lk.ijse.riceMil.dto.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CrudDAO <T>extends SuperDAO{
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean Update(T to) throws ClassNotFoundException, SQLException;
    public T search(String id) throws SQLException, ClassNotFoundException;
    public ResultSet getAll() throws SQLException, ClassNotFoundException;
    public boolean save(T to) throws SQLException, ClassNotFoundException;
}
