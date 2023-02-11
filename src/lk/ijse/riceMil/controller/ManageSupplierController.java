package lk.ijse.riceMil.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
//import lk.ijse.riceMil.to.Supplier;
import lk.ijse.riceMil.bo.BOFactory;
import lk.ijse.riceMil.bo.custom.AttendanceBO;
import lk.ijse.riceMil.bo.custom.SupplierBO;
import lk.ijse.riceMil.bo.custom.impl.SupplierBOImpl;
import lk.ijse.riceMil.dao.custom.SupplierDAO;
import lk.ijse.riceMil.dao.custom.impl.SupplierDAOImpl;
import lk.ijse.riceMil.dto.SupplierDTO;
import lk.ijse.riceMil.view.tm.SupplierTM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManageSupplierController implements Initializable {
    public AnchorPane pane;
    public TextField txtSupId;
    public TextField txtTelNO;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtStatues;
    public TextField txtNic;
    public TableView tblSupplier;
    public TableColumn colSupId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colTelNo;
    public TableColumn colStatues;
    public TableColumn colNic;


    private static ManageSupplierController Ad;
    public ManageSupplierController(){
        Ad = this;
    }
    public static ManageSupplierController getAd(){
        return Ad;
    }
    ObservableList<SupplierTM> supplierTMS= FXCollections.observableArrayList();

   // SupplierBO supplierBO = new SupplierBOImpl();

    SupplierBO supplierBO  = (SupplierBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.SUPPLIER);
    public void saveOnAction(ActionEvent actionEvent) {
        String nic= txtNic.getText();
        //String supId=txtSupId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String telNo=txtTelNO.getText();
        String statues=txtStatues.getText();

        SupplierDTO supplier =new SupplierDTO(nic,name,address,telNo,statues);
        try {
            boolean isAdded = supplierBO.saveSupplier(supplier);

            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Employee Added!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something happened!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        clear();
        setTable();
    }

    public void updateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String nic= txtNic.getText();
        //String supId=txtSupId.getText();
        String name=txtName.getText();
        String address=txtAddress.getText();
        String telNo=txtTelNO.getText();
        String statues=txtStatues.getText();

        SupplierDTO supplier =new SupplierDTO(nic,name,address,telNo,statues);

        boolean isUpdate= supplierBO.updateSupplier(supplier);

        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION, "Supplier Update Successful...!").show();
        }else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }

        clear();
        setTable();

    }

    public void deleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete=supplierBO.deleteSupplier(txtNic.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION, "Supplier Delete Successful...!").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }

        clear();
        setTable();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // colSupId.setCellValueFactory(new PropertyValueFactory<>("supId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colTelNo.setCellValueFactory(new PropertyValueFactory<>("telNo"));
        colStatues.setCellValueFactory(new PropertyValueFactory<>("statues"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

        setTable();

    }
    private void setTable(){
        tblSupplier.getItems().clear();
        try {
            ResultSet set= supplierBO.getAllSupplier();
            while (set.next()){
                supplierTMS.add(new SupplierTM(
                        set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getString(5)


                ));
                tblSupplier.setItems(supplierTMS);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clear(){
        txtNic.setText("");
        //txtSupId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtTelNO.setText("");
        txtStatues.setText("");
    }

    public void nicOnAction(ActionEvent actionEvent) {
        String nic = txtNic.getText();
        try {
            SupplierDTO supplier = supplierBO.searchSupplier(nic);
            if (supplier != null) {
                fillData(supplier);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void fillData(SupplierDTO supplier){

        txtNic.setText(supplier.getNic());
        //txtSupId.setText(supplier.getSupId());
        txtName.setText(supplier.getName());
        txtAddress.setText(supplier.getAddress());
        txtTelNO.setText(supplier.getTelNo());
        txtStatues.setText(supplier.getStatues());

    }

    public void clearOnAction(ActionEvent actionEvent) {
        clear();
    }
}
