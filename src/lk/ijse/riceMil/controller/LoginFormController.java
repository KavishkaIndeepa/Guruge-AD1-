package lk.ijse.riceMil.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.riceMil.bo.BOFactory;
import lk.ijse.riceMil.bo.custom.EmployeeBO;
import lk.ijse.riceMil.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.riceMil.dao.custom.EmployeeDAO;
import lk.ijse.riceMil.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.riceMil.dto.EmployeeDTO;
//import lk.ijse.riceMil.to.Employee;
//import lk.ijse.riceMil.model.EmployeeModel;
import lk.ijse.riceMil.util.Navigation;
import lk.ijse.riceMil.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginFormController {
    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public Label lblInvalid;
    public Label lblInvalidPassword;
    public Label lblInvalidName;
    public JFXButton btnLog;

    private Matcher userNameMatcher;
    private Matcher pwMatcher;

    private void setPatterns() {

    }

    //EmployeeBOImpl employeeBO = new EmployeeBOImpl();
    EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.EMPLOYEE);

    public void initialize() {
        setPatterns();
    }

    public void UserNameOnAction(ActionEvent actionEvent) {
       txtPassword.requestFocus();
    }

    public void UserNameOnKeyType(KeyEvent keyEvent) {
        Pattern userNamePattern = Pattern.compile("(^[a-zA-Z0-9]{4,}$)");
        userNameMatcher = userNamePattern.matcher(txtUserName.getText());

        if(!userNameMatcher.matches()) {
//            System.out.println(txtUserName.getText());
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Paint.valueOf("Red"));
           lblInvalidName.setText("Invalid Username ..!");
        }else{
           txtUserName.setFocusColor(Paint.valueOf("blue"));
            lblInvalidName.setVisible(false);
        }
    }

    public void passwordOnAction(ActionEvent actionEvent) {
        btnLog.fire();
    }

    public void PasswordOnType(KeyEvent keyEvent) {
        Pattern pwPattern = Pattern.compile("^(?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[a-zA-Z]).{8,}$");
        pwMatcher = pwPattern.matcher(txtPassword.getText());

        if(!pwMatcher.matches()) {
//            System.out.println(txtUserName.getText());
            txtPassword.requestFocus();
            txtPassword.setFocusColor(Paint.valueOf("Red"));
            lblInvalidPassword.setText("Invalid Password ..!");
        }else{
            txtPassword.setFocusColor(Paint.valueOf("blue"));
            lblInvalidPassword.setVisible(false);
        }
    }

    public void logingOnAction(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
//        if (txtUserName.getText().equals("Admin") && txtPassword.getText().equals("HARSHANA!@#$1234se")){
//            Navigation.navigate(Routes.ADMIN_VIEW,pane);
//        }if(txtUserName.getText().equals("Cashier") && txtPassword.getText().equals("IMASHA!@#$1234im")){
//            Navigation.navigate(Routes.CASHIER_VIEW,pane);
//        }

       String userName= txtUserName.getText();
       String password=txtPassword.getText();


        EmployeeDTO employee =new EmployeeDTO(userName,password);

        boolean isVerify= employeeBO.chackEmployee(employee);
        if(txtUserName.getText().equals("Admin")& isVerify){
            new Alert(Alert.AlertType.CONFIRMATION, "Admin, Login Successfully!").show();
            Navigation.navigate(Routes.ADMIN_VIEW,pane);

        }else if (txtUserName.getText().equals("Cashier") & isVerify){
            new Alert(Alert.AlertType.CONFIRMATION, "Cashier, Login Successfully!").show();
            Navigation.navigate(Routes.CASHIER_VIEW,pane);

        }else {
            new Alert(Alert.AlertType.WARNING, "Incorrect Username or Password!").show();
        }




    }

    public void logOutOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }


}
