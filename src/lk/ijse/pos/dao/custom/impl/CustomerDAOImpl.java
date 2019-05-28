package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    public boolean save(Customer customer) throws Exception{
        return CrudUtil.execute("INSERT INTO Customer VALUES (?,?,?)", customer.getId(), customer.getName(), customer.getAddress());
    }

    public boolean update(Customer customer)throws Exception{
        return CrudUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", customer.getName(), customer.getAddress(), customer.getId());
    }

    public boolean delete(String id)throws Exception{
        return CrudUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }

    public Customer find(String id) throws Exception{

        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer WHERE id=?", id);

        if (rst.next()) {
            return new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
        }
        return null;
    }

    public List<Customer> findAll() throws Exception{
        ResultSet rst = CrudUtil.execute("  SELECT * FROM Customer");
        List<Customer> alCustomers = new ArrayList<>();
        while (rst.next()) {
            alCustomers.add(new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)));
        }
        return alCustomers;
    }

    @Override
    public int count() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) FROM Customer");
        if (rst.next()){
            return rst.getInt(1);
        }
        return 0;
    }
}
