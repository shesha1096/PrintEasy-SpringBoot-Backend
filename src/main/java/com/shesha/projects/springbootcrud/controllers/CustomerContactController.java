package com.shesha.projects.springbootcrud.controllers;

import com.shesha.projects.springbootcrud.entities.Customer;
import com.shesha.projects.springbootcrud.entities.CustomerContact;
import com.shesha.projects.springbootcrud.services.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerContactController {

    @Autowired
    private CustomerContactService customerContactService;

    @PostMapping("/addcustomercontact")
    public CustomerContact addCustomerContact(@RequestBody CustomerContact customerContact)
    {
        return customerContactService.addCustomerContact(customerContact);
    }

    @PutMapping("/updatecustomercontact")
    public CustomerContact editCustomerContact(@RequestBody CustomerContact customerContact)
    {
        return customerContactService.updateContactDetails(customerContact);
    }

    @GetMapping("/customercontacts/{name}")
    public List<CustomerContact> getContactsByName(@PathVariable String name)
    {
        return customerContactService.findCustomerContactsByName(name);
    }

    @GetMapping("customercontacts/find/{id}")
    public CustomerContact getCustomerContact(@PathVariable int id)
    {
        return customerContactService.getContactById(id);
    }

    @DeleteMapping("/deletecontact/{id}")
    public String deleteCustomerContact(@PathVariable int id)
    {
        return customerContactService.deleteContact(id);
    }

    @GetMapping("/customercontacts")
    public List<CustomerContact> getAllContacts()
    {
        return customerContactService.getAllContacts();
    }
}
