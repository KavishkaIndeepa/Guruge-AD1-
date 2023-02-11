package lk.ijse.riceMil.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.riceMil.bo.BOFactory;
import lk.ijse.riceMil.bo.custom.SupplierBO;
import lk.ijse.riceMil.bo.custom.impl.SupplierBOImpl;
import lk.ijse.riceMil.dao.custom.SupplierDAO;
import lk.ijse.riceMil.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.riceMil.dto.SupplierDTO;
//import lk.ijse.riceMil.to.Supplier;
import lk.ijse.riceMil.model.SupplierModel;

import java.sql.SQLException;

public class AddSupplierController {
    public AnchorPane pane;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtTelNo;
    public TextField txtNic;
    public TextField txtStatues;

    private static AddSupplierController Ad;
    public AddSupplierController(){
        Ad = this;
    }
    public static AddSupplierController getAd(){
        return Ad;
    }

    //SupplierBO supplierBO = new SupplierBOImpl();
    SupplierBO supplierBO  = (SupplierBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.SUPPLIER);

    public void addOnAction(ActionEvent actionEvent) {
        String nic= txtNic.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String telNo=txtTelNo.getText();
        String statues=txtStatues.getText();

        SupplierDTO supplier =new SupplierDTO(nic,name,address,telNo,statues);
        try {
            boolean isAdded = supplierBO.addSupplier(supplier);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
