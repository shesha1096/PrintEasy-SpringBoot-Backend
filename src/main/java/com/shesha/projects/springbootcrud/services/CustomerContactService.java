package com.shesha.projects.springbootcrud.services;

import com.shesha.projects.springbootcrud.entities.CustomerContact;
import com.shesha.projects.springbootcrud.entities.CustomerOrder;
import com.shesha.projects.springbootcrud.repositories.CustomerContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerContactService {

    @Autowired
    private CustomerContactRepository customerContactRepository;

    public CustomerContact addCustomerContact(CustomerContact customerContact)
    {
        return customerContactRepository.save(customerContact);
    }

    public List<CustomerContact> findCustomerContactsByName(String customerContactName)
    {
        return customerContactRepository.findContactsByName(customerContactName);
    }

    public CustomerContact getContactById(int customerContactId)
    {
        return customerContactRepository.findById(customerContactId).orElse(null);
    }

    public String deleteContact(int id)
    {
        customerContactRepository.deleteById(id);
        return "Contact Deleted, ID: " + id;
    }

    public CustomerContact updateContactDetails(CustomerContact customerContact)
    {
        CustomerContact existingContact = customerContactRepository.getOne(customerContact.getCustomerContactId());
        existingContact.setCustomer(customerContact.getCustomer());
        existingContact.setCustomerAvailability(customerContact.getCustomerAvailability());
        existingContact.setCustomerContactId(customerContact.getCustomerContactId());
        existingContact.setCustomerContactName(customerContact.getCustomerContactName());
        existingContact.setCustomerEmail(customerContact.getCustomerEmail());
        existingContact.setCustomerOrders((ArrayList<CustomerOrder>) customerContact.getCustomerOrders());
        existingContact.setCustomerPhone(customerContact.getCustomerPhone());
        existingContact.setCustomerRole(customerContact.getCustomerRole());
        return customerContactRepository.save(existingContact);
    }

    public List<CustomerContact> getAllContacts()
    {
        return customerContactRepository.findAll();
    }

}
