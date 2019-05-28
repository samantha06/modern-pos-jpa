package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;
import org.hibernate.Session;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private Session session;

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    public void save(Customer customer) throws Exception {
        session.save(customer);
    }

    public void update(Customer customer) throws Exception {
        session.merge(customer);
    }

    public void delete(String id) throws Exception {
        session.delete(session.load(Customer.class, id));
    }

    public Customer find(String id) throws Exception {
        return session.find(Customer.class, id);
    }

    public List<Customer> findAll() throws Exception {
        return session.createQuery("FROM Customer").list();
    }

    @Override
    public int count() throws Exception {
        return session.createNativeQuery("SELECT COUNT(*) FROM Customer", Integer.class)
                .uniqueResult();
    }

}
