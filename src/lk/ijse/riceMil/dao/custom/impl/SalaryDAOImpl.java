package lk.ijse.riceMil.dao.custom.impl;

import lk.ijse.riceMil.dao.custom.SalaryDAO;
import lk.ijse.riceMil.dto.SalaryDTO;
//import lk.ijse.riceMil.to.Salary;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaryDAOImpl implements SalaryDAO {
    public boolean save(SalaryDTO to) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Salary VALUES(?, ?, ?, ?)";
        return CrudUtil.execute(sql, to.getSalaryId(), to.getDate(), to.getPayment(), to.getNic() );
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Salary");
    }

    public SalaryDTO search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM Salary WHERE salaryId = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new SalaryDTO(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)


            );
        }
        return null;
    }

    public boolean Update(SalaryDTO to) throws ClassNotFoundException, SQLException {

        String sql = "Update Salary set date=?, payment=?, nic=? Where salaryId=?";
        return CrudUtil.execute(sql, to.getDate(), to.getPayment(), to.getNic(), to.getSalaryId());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM salary WHERE salaryId='" + id + "'";
        return CrudUtil.execute(sql);
    }
}
