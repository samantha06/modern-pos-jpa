package lk.ijse.pos.business.custom.impl;

import lk.ijse.pos.business.custom.OrderBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.DAOTypes;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailDTO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.Order;
import lk.ijse.pos.entity.OrderDetail;

import java.sql.Connection;

public class OrderBOImpl implements OrderBO {

    private OrderDAO orderDAO = DAOFactory.getInstance().getDAO(DAOTypes.ORDER);
    private OrderDetailDAO orderDetailDAO = DAOFactory.getInstance().getDAO(DAOTypes.ORDER_DETAIL);
    private ItemDAO itemDAO = DAOFactory.getInstance().getDAO(DAOTypes.ITEM);

    public boolean placeOrder(OrderDTO order) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        boolean result = false;

        try {

            // Begin Transaction
            connection.setAutoCommit(false);

            result = orderDAO.save(new Order(order.getOrderId(), order.getOrderDate(), order.getCustomerId()));

            if (!result) {
                connection.rollback();
                return false;
            }

            for (OrderDetailDTO dto : order.getOrderDetails()) {

                result = orderDetailDAO.save(new OrderDetail(dto.getOrderId(), dto.getItemCode(), dto.getQty(), dto.getUnitPrice()));

                if (!result) {
                    connection.rollback();
                    return false;
                }

                Item item = itemDAO.find(dto.getItemCode());
                int qty = item.getQtyOnHand() - dto.getQty();
                item.setQtyOnHand(qty);
                result = itemDAO.update(item);

                if (!result) {
                    connection.rollback();
                    return false;
                }
            }

            connection.commit();
            return true;

        } catch (Throwable ex){
            connection.rollback();
            throw ex;
        } finally {
            connection.setAutoCommit(true);
        }
    }

    public int generateOrderId() throws Exception {
        return orderDAO.getLastOrderId() + 1;
    }

}
