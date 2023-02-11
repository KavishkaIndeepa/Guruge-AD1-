package lk.ijse.riceMil.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.riceMil.bo.BOFactory;
import lk.ijse.riceMil.bo.custom.AttendanceBO;
import lk.ijse.riceMil.bo.custom.impl.AttendanceBOImpl;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.impl.AttendanceDAOImpl;
import lk.ijse.riceMil.dto.AttendanceDTO;
//import lk.ijse.riceMil.model.AttendanceModel;
//import lk.ijse.riceMil.to.Attendance;
import lk.ijse.riceMil.entity.Attendance;
import lk.ijse.riceMil.view.tm.AttendanceTM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AttendanceFormController implements Initializable {
    public AnchorPane pane;
    public TextField txtNic;
    public TextField txtAttendanceId;
    public TextField txtName;
    public JFXDatePicker txtDate;
    public TableView tblAttendance;
    public TableColumn colAttendanceId;
    public TableColumn colName;
    public TableColumn colDate;
    public TableColumn colTime;
    public TableColumn colNic;
    public Label lblDate;
    public Label lblTime;
    public JFXTimePicker txtTime;

    private static AttendanceFormController Ad;
    public AttendanceFormController(){
        Ad = this;
    }
    public static AttendanceFormController getAd(){
        return Ad;
    }
    ObservableList<AttendanceTM> attendanceTMS= FXCollections.observableArrayList();
  // AttendanceBOImpl attendanceBO = new AttendanceBOImpl();
//    AttendanceBO attendanceBO  = new AttendanceBOImpl();
AttendanceBO attendanceBO  = (AttendanceBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.ATTENDANCE);


    public void saveOnAction(ActionEvent actionEvent) {
        String attendanceId=txtAttendanceId.getText();
        String name=txtName.getText();
        String date= String.valueOf(txtDate.getValue());
        String time= String.valueOf(txtTime.getValue());
        String nic=txtNic.getText();


       AttendanceDTO attendance =new AttendanceDTO(attendanceId,name,date,time,nic);
        try {

            boolean isAdded = attendanceBO.saveAttendance(attendance);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
          setTable();
        clear();
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void idOnAction(ActionEvent actionEvent) {
        String attendanceId = txtAttendanceId.getText();
        try {
            AttendanceDTO attendance = attendanceBO.searchAttendance(attendanceId);
            if (attendance != null) {
                fillData(attendance);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearOnAction(ActionEvent actionEvent) {
        clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colAttendanceId.setCellValueFactory(new PropertyValueFactory<>("attendanceId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("time"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

        setTable();

    }

    private void setTable(){
        tblAttendance.getItems().clear();
        try {
            ResultSet set= attendanceBO.getAllAttendance();
            while (set.next()){
                attendanceTMS.add(new AttendanceTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5)


                ));
               tblAttendance.setItems(attendanceTMS);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void fillData(AttendanceDTO attendance){

        txtAttendanceId.setText(attendance.getAttendanceId());
        txtName.setText(attendance.getName());
        lblDate.setText(attendance.getDate());
        txtDate.setVisible(false);
        lblTime.setText(attendance.getTime());
        txtTime.setVisible(false);
        txtNic.setText(attendance.getNic());

    }
    public void clear(){
        txtAttendanceId.setText("");
        txtName.setText("");
        lblDate.setText("");
        txtDate.setVisible(true);
        lblTime.setText("");
        txtTime.setVisible(true);
        txtNic.setText("");


    }
}
