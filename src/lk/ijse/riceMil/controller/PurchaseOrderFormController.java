package lk.ijse.riceMil.controller;

import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.riceMil.bo.BOFactory;
import lk.ijse.riceMil.bo.custom.AttendanceBO;
import lk.ijse.riceMil.bo.custom.PurchaseOrderBO;
import lk.ijse.riceMil.bo.custom.impl.PurchaseOrderBOImpl;
import lk.ijse.riceMil.dao.custom.PurchaseOrderDAO;
import lk.ijse.riceMil.dao.custom.impl.PurchaseOrderDAOImpl;
import lk.ijse.riceMil.dto.PurchaseOrderDTO;
//import lk.ijse.riceMil.to.PurchaseOrder;
//import lk.ijse.riceMil.model.PurchaseOrderModel;
import lk.ijse.riceMil.view.tm.PurchaseOrderTM;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PurchaseOrderFormController implements Initializable {
    public AnchorPane pane;
    public TextField txtItemName;
    public TextField txtSearchPurchaseOrder;
    public TableView <PurchaseOrderTM>tblPurchaseOrder;
    public TableColumn colPurchaseOrderId;
    public TableColumn colDate;

    public TextField txtQty;
    public JFXDatePicker txtDate;
//    public TableColumn colNic;
    public TextField txtNic;
    public Label labDate;
    public TableColumn ColNic;
    public TableColumn colId;
    ObservableList<PurchaseOrderTM> purchaseOrderTMS= FXCollections.observableArrayList();

   // PurchaseOrderBO purchaseOrderBO = new PurchaseOrderBOImpl();
   PurchaseOrderBO purchaseOrderBO  = (PurchaseOrderBO) BOFactory.getBoFactory().getBo(BOFactory.BOType.PURCHASE_ORDER);

private static PurchaseOrderFormController Ad;
public PurchaseOrderFormController(){
    Ad = this;
}
public static PurchaseOrderFormController getAd(){
    return Ad;
}

    public void saveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       int pOrderId= Integer.parseInt(txtSearchPurchaseOrder.getText());
       String date= String.valueOf(txtDate.getValue());
       String nic=txtNic.getText();

       PurchaseOrderDTO purchaseOrder = new PurchaseOrderDTO(pOrderId,date,nic);
        try {
            boolean isAdded = purchaseOrderBO.savePurchaseOrder(purchaseOrder);
            setTable();
            if (isAdded) {
                new Alert(Alert.AlertType.CONFIRMATION, "Purchase Order Added!").show();
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

        int pOrderId= Integer.parseInt(txtSearchPurchaseOrder.getText());
        String date= String.valueOf(txtDate.getValue());
        String nic=txtNic.getText();

        PurchaseOrderDTO purchaseOrder = new PurchaseOrderDTO(pOrderId,date,nic);

        boolean isUpdate= purchaseOrderBO.updatePurchaseOrder(purchaseOrder);
        setTable();
        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION, "Purchase Order Update Successful...!").show();
        }else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }

        clear();
        setTable();
    }

    public void deleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDelete=purchaseOrderBO.deletePurchaseOrder(txtSearchPurchaseOrder.getText());

        if(isDelete){
            new Alert(Alert.AlertType.CONFIRMATION, "Purchase Order Delete Successful...!").show();

        }else {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
        }
        setTable();
        clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

       colId.setCellValueFactory(new PropertyValueFactory<>("id"));
       colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
       ColNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

        setTable();

    }

    private void setTable(){
        tblPurchaseOrder.getItems().clear();
        try {
            ResultSet set= purchaseOrderBO.getAllPurchaseOrder();
            while (set.next()){
                purchaseOrderTMS.add(new PurchaseOrderTM(
                        set.getInt(1),
                        set.getString(2),
                        set.getString(3)

                ));
                tblPurchaseOrder.setItems(purchaseOrderTMS);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void idOnAction(ActionEvent actionEvent) {
        String pOrderId = txtSearchPurchaseOrder.getText();
        try {
            PurchaseOrderDTO purchaseOrder = purchaseOrderBO.searchPurchaseOrder(pOrderId);
            if (purchaseOrder != null) {
                fillData(purchaseOrder);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void fillData(PurchaseOrderDTO purchaseOrder){
        txtSearchPurchaseOrder.setText(String.valueOf(purchaseOrder.getpOrderId()));
        labDate.setText(purchaseOrder.getDate());
        txtDate.setVisible(false);
        txtNic.setText(purchaseOrder.getNic());

    }
    public void clear(){
        txtSearchPurchaseOrder.setText("");
        labDate.setText("");
        txtDate.setVisible(true);
        txtNic.setText("");

    }

    public void clearOnAction(ActionEvent actionEvent) {
        clear();
    }
}
