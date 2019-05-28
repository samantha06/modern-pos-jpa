package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.entity.Order;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    public void save(Order order) throws Exception{
        session.save(order);
    }

    public void update(Order order)throws Exception{
        session.merge(order);
    }

    public void delete(Integer id)throws Exception{
        session.delete(session.load(Order.class, id));
    }

    public Order find(Integer id) throws Exception{
        return session.find(Order.class, id);
    }

    public List<Order> findAll() throws Exception{
        return session.createQuery("FROM lk.ijse.pos.entity.Order",Order.class).list();
    }

    @Override
    public int getLastOrderId() throws Exception {
        return session.createNativeQuery("SELECT id FROM `Order` ORDER BY id DESC LIMIT 1", Integer.class).uniqueResult();
    }
}
