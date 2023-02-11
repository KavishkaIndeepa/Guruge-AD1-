package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.CustomerBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.CustomerDAO;
import lk.ijse.riceMil.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.riceMil.dto.CustomerDTO;
import lk.ijse.riceMil.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    //CustomerDAO dao = new CustomerDAOImpl();
    CustomerDAO dao = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

public ArrayList<String> loadCustomerNic() throws SQLException, ClassNotFoundException {
    return dao.loadCustomerNic();

}

public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
    Customer ent= dao.search(id);
    return new CustomerDTO(ent.getNic(), ent.getName(), ent.getAddress(),ent.getTelNo());

}

public CustomerDTO searchCustomerNic(String id) throws SQLException, ClassNotFoundException {
    Customer ent= dao.search(id);
    return new CustomerDTO(ent.getNic(), ent.getName(), ent.getAddress(),ent.getTelNo());

}

public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
    return dao.save(new Customer(dto.getNic(),dto.getName(),dto.getAddress(),dto.getTelNo()));
}

public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
    return dao.Update(new Customer(dto.getNic(),dto.getName(),dto.getAddress(),dto.getTelNo()));
}

public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
    return dao.delete(id);
}

public ResultSet getAllCustomer() throws SQLException, ClassNotFoundException {
    return dao.getAll();
}

public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
    return dao.save(new Customer(dto.getNic(),dto.getName(),dto.getAddress(),dto.getTelNo()));

}

}

