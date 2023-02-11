package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.dto.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBO extends SuperBO {
    public boolean saveSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;
    public ResultSet getAllSupplier() throws SQLException, ClassNotFoundException;
    public SupplierDTO searchSupplier(String id) throws SQLException, ClassNotFoundException;
    public boolean updateSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException;
    public SupplierDTO searchSupplierNic(String id) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadSupplierNic() throws SQLException, ClassNotFoundException;
    public boolean addSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException;


}
