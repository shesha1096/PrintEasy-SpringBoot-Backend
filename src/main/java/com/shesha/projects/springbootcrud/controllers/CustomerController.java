package com.shesha.projects.springbootcrud.controllers;

import com.shesha.projects.springbootcrud.entities.Customer;
import com.shesha.projects.springbootcrud.services.CustomerService;
import org.atmosphere.config.service.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        return customerService.addCustomer(customer);
    }

    @PutMapping("/updatecustomer")
    public Customer editCustomer(@RequestBody Customer customer)
    {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable int id)
    {
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/customers/find/{id}")
    public Customer getCustomerById(@PathVariable int id)
    {
        return customerService.getCustomerById(id);
    }

    @GetMapping("/customers/{name}")
    public List<Customer> getCustomersByName(@PathVariable String name)
    {
        return customerService.getCustomerByUserName(name);
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }
}
