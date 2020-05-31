package com.abdulmansour.service;

import com.abdulmansour.dao.CustomerDAO;
import com.abdulmansour.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    //inject customer dao; dao communicates with db, service communicates with multiple daos, controller communicates with single service
    @Autowired
    private CustomerDAO customerDAO;

    //service will commit and close sessions autonomously by making calls to daos
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Transactional
    public Customer getCustomer(int customerId) {
        return customerDAO.getCustomer(customerId);
    }

    @Transactional
    public void deleteCustomer(Customer customer) {
        customerDAO.deleteCustomer(customer);
    }


}
