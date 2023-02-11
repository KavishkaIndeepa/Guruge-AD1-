package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.SupplierBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.SupplierDAO;
import lk.ijse.riceMil.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.riceMil.dto.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBOImpl implements SupplierBO {
    //SupplierDAO dao = new SupplierDAOImpl();
    SupplierDAO dao = (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);


    public boolean saveSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return dao.save(supplierDTO);

    }

    public ResultSet getAllSupplier() throws SQLException, ClassNotFoundException {
        return dao.getAll();

    }

    public SupplierDTO searchSupplier(String id) throws SQLException, ClassNotFoundException {
        return dao.search(id);

    }

    public boolean updateSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return dao.Update(supplierDTO);

    }

    public boolean deleteSupplier(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);

    }

    public SupplierDTO searchSupplierNic(String id) throws SQLException, ClassNotFoundException {
        return dao.search(id);

    }

    public ArrayList<String> loadSupplierNic() throws SQLException, ClassNotFoundException {
        return dao.loadSupplierNic();

    }

    public boolean addSupplier(SupplierDTO supplierDTO) throws SQLException, ClassNotFoundException {
        return dao.save(supplierDTO);

    }


}
