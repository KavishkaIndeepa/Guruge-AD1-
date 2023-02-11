package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.EmployeeBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.EmployeeDAO;
import lk.ijse.riceMil.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.riceMil.dto.EmployeeDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {

    //EmployeeDAO dao = new EmployeeDAOImpl();
    EmployeeDAO dao = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);



    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
       return dao.save(employeeDTO);
    }

    public EmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException {
        return dao.search(id);

    }

    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return dao.Update(employeeDTO);
    }

    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);
    }

    public ResultSet getAllEmployee() throws SQLException, ClassNotFoundException {
        return dao.getAll();

    }

    public boolean chackEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return dao.chack(employeeDTO);

    }
}
