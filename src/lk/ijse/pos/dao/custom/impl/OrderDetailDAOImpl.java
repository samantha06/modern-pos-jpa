package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.entity.OrderDetail;
import lk.ijse.pos.entity.OrderDetailPK;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    public boolean save(OrderDetail orderDetail) throws Exception {
        return CrudUtil.execute("INSERT INTO `OrderDetail` VALUES (?,?,?,?)", orderDetail.getOrderDetailPK().getOrderId(), orderDetail.getOrderDetailPK().getItemCode(), orderDetail.getQty(), orderDetail.getUnitPrice());
    }

    public boolean update(OrderDetail orderDetail) throws Exception {
        return CrudUtil.execute("UPDATE `OrderDetail` SET qty=?, unitPrice=? WHERE orderId=? AND itemCode=?", orderDetail.getQty(), orderDetail.getUnitPrice(), orderDetail.getOrderDetailPK().getOrderId(), orderDetail.getOrderDetailPK().getItemCode());
    }

    public boolean delete(OrderDetailPK id) throws Exception {
        return CrudUtil.execute("DELETE FROM `OrderDetail` WHERE orderId=? AND itemCode=?", id.getOrderId(), id.getItemCode());
    }

    public OrderDetail find(OrderDetailPK id) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM `OrderDetail` WHERE orderId=? AND itemCode=?", id.getOrderId(), id.getItemCode());
        if (rst.next()) {
            return new OrderDetail(rst.getInt(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4));
        }
        return null;
    }

    public List<OrderDetail> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM `OrderDetail`");
        List<OrderDetail> alOrderDetails = new ArrayList<>();
        while (rst.next()) {
            alOrderDetails.add(new OrderDetail(rst.getInt(1),
                    rst.getString(2),
                    rst.getInt(3),
                    rst.getDouble(4)));
        }
        return alOrderDetails;
    }

}
