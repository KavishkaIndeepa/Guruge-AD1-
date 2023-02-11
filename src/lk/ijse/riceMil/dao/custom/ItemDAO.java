package lk.ijse.riceMil.dao.custom;

import lk.ijse.riceMil.dao.CrudDAO;
import lk.ijse.riceMil.dto.CartDetailDTO;
import lk.ijse.riceMil.dto.DeliverDetailDTO;
import lk.ijse.riceMil.dto.ItemDTO;
//import lk.ijse.riceMil.to.CartDetail;
//import lk.ijse.riceMil.to.DeliverDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAO extends CrudDAO<ItemDTO> {
//    public boolean save(ItemDTO item) throws SQLException, ClassNotFoundException;
//    public  boolean delete(String id) throws SQLException, ClassNotFoundException;
//    public ResultSet getAll() throws SQLException, ClassNotFoundException;
//    public ItemDTO search(String code) throws SQLException, ClassNotFoundException;
//    public boolean Update(ItemDTO item) throws ClassNotFoundException, SQLException;
    public boolean updateQty(ArrayList<CartDetailDTO> cartDetails) throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException;
    public boolean increaseQty(ArrayList<DeliverDetailDTO> deliverDetails) throws SQLException, ClassNotFoundException;
    boolean increaseQty(int code, int qty) throws SQLException, ClassNotFoundException;

    }
