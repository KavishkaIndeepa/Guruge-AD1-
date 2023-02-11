package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.dto.AttendanceDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface AttendanceBO extends SuperBO {
    public boolean saveAttendance(AttendanceDTO attendanceDTO) throws SQLException, ClassNotFoundException;
    public ResultSet getAllAttendance() throws SQLException, ClassNotFoundException;
    public AttendanceDTO searchAttendance(String id) throws SQLException, ClassNotFoundException;
}
