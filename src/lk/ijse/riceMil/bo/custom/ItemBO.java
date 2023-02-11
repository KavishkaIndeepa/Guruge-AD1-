package lk.ijse.riceMil.bo.custom;

import lk.ijse.riceMil.bo.SuperBO;
import lk.ijse.riceMil.dto.CartDetailDTO;
import lk.ijse.riceMil.dto.DeliverDetailDTO;
import lk.ijse.riceMil.dto.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public ResultSet getAllItem() throws SQLException, ClassNotFoundException;
    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadItemCode() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException;
    public ItemDTO searchItems(String code) throws SQLException, ClassNotFoundException;
    public boolean updateQtys(ArrayList<CartDetailDTO> cartDetailDTO) throws SQLException, ClassNotFoundException;
    public boolean increaseQty(ArrayList<DeliverDetailDTO> deliverDetailDTO) throws SQLException, ClassNotFoundException;
}
