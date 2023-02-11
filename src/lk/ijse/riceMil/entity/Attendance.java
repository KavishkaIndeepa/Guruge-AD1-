package lk.ijse.riceMil.entity;

import java.sql.Time;
import java.util.Date;

public class Attendance {
    private int attendanceId;
    private String name;
    private Date date;
    private Time time;
    private String nic;

    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Attendance(int attendanceId, String name, Date date, Time time, String nic) {
        this.attendanceId = attendanceId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.nic = nic;
    }

    public Attendance(String string, String resultString, String s, String string1, String nic) {

    }

    @Override
    public String toString() {
        return "Attendance{" +
                "attendanceId=" + attendanceId +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", nic='" + nic + '\'' +
                '}';
    }
}
