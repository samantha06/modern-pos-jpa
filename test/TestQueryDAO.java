import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.DAOTypes;
import lk.ijse.pos.dao.custom.QueryDAO;
import lk.ijse.pos.entity.CustomEntity;

import java.util.List;

public class TestQueryDAO {

    public static void main(String[] args) throws Exception {

        QueryDAO dao = DAOFactory.getInstance().getDAO(DAOTypes.QUERY);
        List<CustomEntity> ordersTotal = dao.getOrdersTotal();
        for (CustomEntity entity : ordersTotal) {
            System.out.println("ID : " + entity.getOrderId() + " | Total : " + entity.getOrderTotal());
        }
    }

}
