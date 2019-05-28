package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.QueryDAO;
import lk.ijse.pos.entity.CustomEntity;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public List<CustomEntity> getOrdersTotal() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT id, SUM(qty * unitPrice) AS Total FROM `Order` INNER JOIN\n" +
                "  OrderDetail OD on `Order`.id = OD.orderId GROUP BY id");
        List<CustomEntity> al = new ArrayList<>();
        while(rst.next()){
            int id = rst.getInt(1);
            double total = rst.getDouble(2);
            al.add(new CustomEntity(id,total));
        }
        return al;
    }
}
