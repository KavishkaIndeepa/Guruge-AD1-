package lk.ijse.riceMil.dao.custom.impl;

import lk.ijse.riceMil.dao.custom.ItemDAO;
import lk.ijse.riceMil.dto.*;
//import lk.ijse.riceMil.to.CartDetail;
//import lk.ijse.riceMil.to.DeliverDetail;
//import lk.ijse.riceMil.to.Item;
import lk.ijse.riceMil.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    public boolean save(ItemDTO to) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO item VALUES(?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, to.getCode(), to.getDescription(), to.getUnitePrice(), to.getUpdateDate(),
                to.getQtyOnHand());
    }

    public ResultSet getAll() throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("SELECT * FROM item");

    }

    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {

        String sql = "SELECT  * FROM item WHERE code = ?";
        ResultSet result = CrudUtil.execute(sql, code);

        if (result.next()) {
            return new ItemDTO(
                    result.getInt(1),
                    result.getString(2),
                    result.getDouble(3),
                    result.getString(4),
                    result.getInt(5)

            );
        }
        return null;
    }

    public boolean Update(ItemDTO to) throws ClassNotFoundException, SQLException {

        String sql = "Update item set description=?, unitPrice=?, updatedate=? , qtyOnHand=? Where code=?";
        return CrudUtil.execute(sql, to.getDescription(), to.getUnitePrice(), to.getUpdateDate(), to.getQtyOnHand(),
                to.getCode());
    }

    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM item WHERE code='" + id + "'";
        return CrudUtil.execute(sql);
    }
//to do complete

    public boolean updateQty(ArrayList<CartDetailDTO> cartDetails) throws SQLException, ClassNotFoundException {
        for (CartDetailDTO cartDetail : cartDetails) {
            if (!updateQty(cartDetail.getCode(), cartDetail.getQtyOnHand())) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("true");
        return true;
    }
// " "
    public boolean updateQty(int code, int qut) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET qtyOnHand = qtyOnHand - ? WHERE code = ?";
        return CrudUtil.execute(sql, qut, code);
    }

    public ArrayList<String> loadItemCodes() throws SQLException, ClassNotFoundException {
        String sql = "SELECT code FROM Item";
        ResultSet result = CrudUtil.execute(sql);

        ArrayList<String> codeList = new ArrayList<>();

        while (result.next()) {
            codeList.add(result.getString(1));
        }
        return codeList;
    }
//""
    public boolean increaseQty(ArrayList<DeliverDetailDTO> deliverDetails) throws SQLException, ClassNotFoundException {
        for (DeliverDetailDTO deliverDetail : deliverDetails) {
            if (!increaseQty(deliverDetail.getCode(), deliverDetail.getQtyOnHand())) {
                return false;
            }
        }
        return true;
    }
//""
    public boolean increaseQty(int code, int qty) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Item SET qtyOnHand = qtyOnHand + ? WHERE code = ?";
        return CrudUtil.execute(sql, qty, code);
    }


}
