package com.shesha.projects.springbootcrud.services;

import com.shesha.projects.springbootcrud.entities.Customer;
import com.shesha.projects.springbootcrud.entities.CustomerOrder;
import com.shesha.projects.springbootcrud.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public List<Customer> addCustomers(List<Customer> customerList)
    {
        return customerRepository.saveAll(customerList);
    }

    public String deleteCustomer(int customerId)
    {
        customerRepository.deleteById(customerId);
        return "Customer Deleted. ID: " + customerId;
    }

    public List<Customer> getCustomerByUserName(String customerName)
    {
        return customerRepository.findCustomerByName(customerName);
    }

    public Customer getCustomerById(int customerId)
    {
        return customerRepository.findById(customerId).orElse(null);
    }

    public Customer updateCustomer(Customer customer)
    {
        Customer existingCustomer = customerRepository.findById(customer.getCustomerId()).orElse(null);
        existingCustomer.setCustomerId(customer.getCustomerId());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setCompanyHeadquarters(customer.getCompanyHeadquarters());
        existingCustomer.setCompanyISO(customer.getCompanyISO());
        existingCustomer.setCompanySize(customer.getCompanySize());
        existingCustomer.setCustomerContacts(customer.getCustomerContacts());
        existingCustomer.setCustomerCountry(customer.getCustomerCountry());
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setCustomerOrders((ArrayList<CustomerOrder>) customer.getCustomerOrders());
        existingCustomer.setIndustry(customer.getIndustry());
        existingCustomer.setManagedBy(customer.getManagedBy());
        return customerRepository.save(existingCustomer);
    }

    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }
}
