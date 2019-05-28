package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.entity.Item;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    public void save(Item item) throws Exception{
        session.save(item);
    }

    public void update(Item item)throws Exception{
        session.merge(item);
    }

    public void delete(String code)throws Exception{
        session.delete(session.load(Item.class, code));
    }

    public Item find(String code) throws Exception{
        return session.find(Item.class, code);
    }

    public List<Item> findAll() throws Exception{
        return session.createQuery("FROM Item", Item.class).list();
    }

}
