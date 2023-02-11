package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.SalaryBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.SalaryDAO;
import lk.ijse.riceMil.dao.custom.impl.SalaryDAOImpl;
import lk.ijse.riceMil.dto.SalaryDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryBOImpl implements SalaryBO {
//    SalaryDAO dao = new SalaryDAOImpl();
SalaryDAO dao = (SalaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SALARY);

    public boolean saveSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
        return dao.save(salaryDTO);

    }

    public ResultSet getAllSalary() throws SQLException, ClassNotFoundException {
        return dao.getAll();

    }

    public SalaryDTO searchSalary(String id) throws SQLException, ClassNotFoundException {
        return dao.search(id);

    }

    public boolean updateSalary(SalaryDTO salaryDTO) throws SQLException, ClassNotFoundException {
        return dao.Update(salaryDTO);

    }

    public boolean deleteSalary(String id) throws SQLException, ClassNotFoundException {
        return dao.delete(id);

    }


}
