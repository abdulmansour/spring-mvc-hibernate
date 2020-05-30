package com.abdulmansour.dao;

import com.abdulmansour.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//always add @Repository to DAO implementations
@Repository
public class CustomerDAOImpl implements CustomerDAO {

    // inject the sessionFactory from the config file; bean id = 'sessionFactory'
    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomers() {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create getCustomers query
        Query<Customer> query = currentSession.createQuery("from Customer as c order by lastName", Customer.class);

        //execute and get result list
        List<Customer> customers = query.getResultList();

        //return result list
        return customers;
    }

    public void saveCustomer(Customer customer) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //save or update the customer to db
        currentSession.saveOrUpdate(customer);
    }

    public Customer getCustomer(int customerId) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //get the customer with the passed in customerId
        Customer customer = currentSession.get(Customer.class, customerId);

        return customer;
    }

}
