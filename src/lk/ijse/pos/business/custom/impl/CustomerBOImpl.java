package lk.ijse.pos.business.custom.impl;

import lk.ijse.pos.business.custom.CustomerBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.DAOTypes;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerBOImpl implements CustomerBO {

    private CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOTypes.CUSTOMER);

//    public CustomerBOImpl(){
//        String dao = DAOFactory.getInstance().<String>getDAO(DAOTypes.CUSTOMER);
//    }

    @Override
    public CustomerDTO getCustomerById(String id) throws Exception {
        Customer customer = customerDAO.find(id);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
    }

    public List<CustomerDTO> getAllCustomers() throws Exception {
        return customerDAO.findAll().stream().map(customer -> new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress())).collect(Collectors.toList());

    }

    public boolean saveCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.save(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        return customerDAO.update(new Customer(dto.getId(), dto.getName(), dto.getAddress()));
    }

    public boolean removeCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

}
