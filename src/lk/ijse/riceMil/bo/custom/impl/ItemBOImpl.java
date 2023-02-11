package lk.ijse.riceMil.bo.custom.impl;

import lk.ijse.riceMil.bo.custom.ItemBO;
import lk.ijse.riceMil.dao.DAOFactory;
import lk.ijse.riceMil.dao.custom.AttendanceDAO;
import lk.ijse.riceMil.dao.custom.ItemDAO;
import lk.ijse.riceMil.dao.custom.impl.ItemDAOImpl;
import lk.ijse.riceMil.dto.CartDetailDTO;
import lk.ijse.riceMil.dto.DeliverDetailDTO;
import lk.ijse.riceMil.dto.ItemDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

//    ItemDAO dao = new ItemDAOImpl();
ItemDAO dao = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);


    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return dao.save(itemDTO);
    }

    public ResultSet getAllItem() throws SQLException, ClassNotFoundException {
        return dao.getAll();

    }

    public boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return dao.Update(itemDTO);

    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return dao.delete(code);

    }

    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        return dao.search(code);

    }

    public ArrayList<String> loadItemCode() throws SQLException, ClassNotFoundException {
        return dao.loadItemCodes();
    }
    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        return dao.loadItemCodes();

    }
    public ItemDTO searchItems(String code) throws SQLException, ClassNotFoundException {
        return dao.search(code);

    }

    public boolean updateQtys(ArrayList<CartDetailDTO> cartDetailDTO) throws SQLException, ClassNotFoundException {
        return dao.updateQty(cartDetailDTO);

    }

    public boolean increaseQty(ArrayList<DeliverDetailDTO> deliverDetailDTO) throws SQLException, ClassNotFoundException {
        return dao.increaseQty(deliverDetailDTO);

    }



}
