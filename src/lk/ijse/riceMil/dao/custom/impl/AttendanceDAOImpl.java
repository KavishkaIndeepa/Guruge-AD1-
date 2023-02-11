package lk.ijse.riceMil.dao.custom.impl;

import lk.ijse.riceMil.dao.custom.AttendanceDAO;
//import lk.ijse.riceMil.to.Attendance;
import lk.ijse.riceMil.dto.AttendanceDTO;
import lk.ijse.riceMil.dto.SupplierDTO;
import lk.ijse.riceMil.entity.Attendance;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceDAOImpl implements AttendanceDAO {
    public  boolean save(Attendance to) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Attendance VALUES(?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, to.getAttendanceId(), to.getName(), to.getDate(),
                to.getTime(), to.getNic());
    }

    public  ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM Attendance");
    }


    @Override

    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean Update(Attendance to) throws ClassNotFoundException, SQLException {
        return false;
    }

    public Attendance search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT  * FROM Attendance WHERE attendanceId = ?";
        ResultSet result = CrudUtil.execute(sql, id);

        if (result.next()) {
            return new Attendance(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)

            );
        }
        return null;
    }
}
