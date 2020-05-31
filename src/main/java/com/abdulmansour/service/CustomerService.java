package com.abdulmansour.service;

import com.abdulmansour.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public Customer getCustomer(int customerId);

    public void deleteCustomer(Customer customer);

    List<Customer> searchCustomers(String search);
}
