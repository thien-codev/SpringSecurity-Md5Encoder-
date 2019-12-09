/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.dao.CustomerDaoIF;
import com.mycompany.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XV
 */
@Service
public class CustomerService implements CustomerServiceIF{

    @Autowired
    CustomerDaoIF customerDaoIF; 
    
    @Override
    public List<Customer> getCustomers() {
	return (List)customerDaoIF.findAll();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
	customerDaoIF.save(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
	return customerDaoIF.findById(theId).get();
    }

    @Override
    public void deleteCustomer(int theId) {
	customerDaoIF.deleteById(theId);
    }
    
}
