package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.entity.Order;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    public boolean save(Order order) throws Exception{
        return CrudUtil.execute("INSERT INTO `Order` VALUES (?,?,?)",order.getId(), order.getDate(), order.getCustomerId());
    }

    public boolean update(Order order)throws Exception{
        return CrudUtil.execute("UPDATE `Order` SET date=?, customerId=? WHERE id=?", order.getDate(), order.getCustomerId(), order.getId());
    }

    public boolean delete(Integer id)throws Exception{
        return CrudUtil.execute("DELETE FROM `Order` WHERE id=?", id);
    }

    public Order find(Integer id) throws Exception{
        ResultSet rst = CrudUtil.execute("SELECT * FROM `Order` WHERE id=?",id);
        if (rst.next()) {
            return new Order(rst.getInt(1),
                    rst.getDate(2).toLocalDate(),
                    rst.getString(3));
        }
        return null;
    }

    public List<Order> findAll() throws Exception{
        ResultSet rst = CrudUtil.execute("SELECT * FROM `Order`");
        List<Order> alOrders = new ArrayList<>();
        while (rst.next()) {
            alOrders.add(new Order(rst.getInt(1),
                    rst.getDate(2).toLocalDate(),
                    rst.getString(3)));
        }
        return alOrders;
    }

    @Override
    public int getLastOrderId() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT id FROM `Order` ORDER BY id DESC LIMIT 1");
        if (rst.next()){
            return rst.getInt(1);
        }else{
            return 0;
        }
    }
}
