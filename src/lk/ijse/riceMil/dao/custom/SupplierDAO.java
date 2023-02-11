package lk.ijse.riceMil.dao.custom;

import lk.ijse.riceMil.dao.CrudDAO;
import lk.ijse.riceMil.dto.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDAO extends CrudDAO<SupplierDTO> {
//    public boolean save(SupplierDTO supplier) throws SQLException, ClassNotFoundException;
//    public ResultSet getAll() throws SQLException, ClassNotFoundException;
//    public SupplierDTO search(String id) throws SQLException, ClassNotFoundException;
//    public boolean Update(SupplierDTO supplier) throws ClassNotFoundException, SQLException;
//    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadSupplierNic() throws SQLException, ClassNotFoundException;

}
