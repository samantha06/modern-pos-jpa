package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.entity.Item;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    public boolean save(Item item) throws Exception{
        return CrudUtil.execute("INSERT INTO Item VALUES (?,?,?,?)",item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }

    public boolean update(Item item)throws Exception{
        return CrudUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(), item.getCode());
    }

    public boolean delete(String code)throws Exception{
        return CrudUtil.execute("DELETE FROM Item WHERE code=?",code);
    }

    public Item find(String code) throws Exception{
        ResultSet rst = CrudUtil.execute("SELECT * FROM Item WHERE code=?",code);
        if (rst.next()) {
            return new Item(rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getInt(4));
        }
        return null;
    }

    public List<Item> findAll() throws Exception{
        ResultSet rst = CrudUtil.execute("SELECT * FROM Item");
        List<Item> alItems = new ArrayList<>();
        while (rst.next()) {
            alItems.add(new Item(rst.getString(1),
                    rst.getString(2),
                    rst.getDouble(3),
                    rst.getInt(4)));
        }
        return alItems;
    }

}
