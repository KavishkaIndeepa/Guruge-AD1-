package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.AttendanceBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.riceMil.dto.AttendanceDTO;
import lk.ijse.riceMil.entity.Attendance;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceBOImpl implements AttendanceBO {

    //AttendanceDAO dao = new AttendanceDAOImpl();
    AttendanceDAO dao = (AttendanceDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ATTENDANCE);
public boolean saveAttendance(AttendanceDTO dto) throws SQLException, ClassNotFoundException {
    return dao.save(new Attendance(dto.getAttendanceId(),dto.getName(),dto.getDate(),dto.getTime(),dto.getNic()));

}

public ResultSet getAllAttendance() throws SQLException, ClassNotFoundException {
    return dao.getAll();

}

public AttendanceDTO searchAttendance(String id) throws SQLException, ClassNotFoundException {
    Attendance ent= dao.search(id);
    return  new AttendanceDTO(String.valueOf(ent.getAttendanceId()),ent.getName(),String.valueOf(ent.getDate()),
            String.valueOf(ent.getTime()),ent.getNic());

}


}
