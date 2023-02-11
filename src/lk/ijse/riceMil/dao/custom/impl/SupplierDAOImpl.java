package lk.ijse.riceMil.dao.custom.impl;

import lk.ijse.riceMil.dao.custom.SupplierDAO;
import lk.ijse.riceMil.dto.SupplierDTO;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAOImpl implements SupplierDAO {
    public boolean save(SupplierDTO to) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO supplier VALUES(?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, to.getNic(), to.getName(), to.getAddress(),
                to.getTelNo(), to.getStatues());
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM supplier");
    }

    public SupplierDTO search(String id) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM supplier WHERE nic = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new SupplierDTO(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)


            );
        }
        return null;
    }

    public boolean Update(SupplierDTO to) throws ClassNotFoundException, SQLException {

        String sql ="Update supplier set name=?, address=? , telNo=? , statues=? Where nic=?";
        return CrudUtil.execute(sql, to.getName(), to.getAddress(), to.getTelNo(), to.getStatues(), to.getNic());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql ="DELETE FROM supplier WHERE nic='"+id+"'";
        return CrudUtil.execute(sql);
    }

    public ArrayList<String> loadSupplierNic() throws SQLException, ClassNotFoundException {
        String sql = "SELECT nic FROM Supplier";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> nicList = new ArrayList<>();

        while (result.next()) {
            nicList.add(result.getString(1));
        }
        return nicList;
    }
}
