/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.entity.Customer;
import com.mycompany.service.CustomerServiceIF;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo webservice
 *
 * @author XV
 */
@RestController
@RequestMapping("/rest/customer")
public class CustomerRestController {

    @Autowired
    private CustomerServiceIF customerService;

    @GetMapping()
    public Object listCustomers() {
	return customerService.getCustomers();
    }

    @PostMapping()
    public Object saveCustomer(@RequestBody Customer customer) {
	customerService.saveCustomer(customer);
	return new HashMap<String, String>() {
	}.put("message", "sucess");
    }

    @PutMapping()
    public Object updateCustomer(@RequestBody Customer customer) {
	
	HashMap rt = new HashMap();
	try {
	    customerService.getCustomer(customer.getId());
	    customerService.saveCustomer(customer);
	    rt.put("message", "success");
	} catch (Exception e) {
	   rt.put("message", "can not find customer"); 
	}
	
	return rt;
    }
    
    @DeleteMapping(value = "/{id}" )
    public String deleteCustomer(@PathVariable("id") int id) {
	if (customerService.getCustomer(id) == null) {
	    return new HashMap<String, String>() {
	    }.put("message", "Customer Not Found");
	} else {
	    customerService.deleteCustomer(id);
	    return new HashMap<String, String>() {
	    }.put("message", "sucess");
	}
    }
}
