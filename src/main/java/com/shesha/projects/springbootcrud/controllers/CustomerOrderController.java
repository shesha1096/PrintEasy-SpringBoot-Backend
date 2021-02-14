package com.shesha.projects.springbootcrud.controllers;

import com.shesha.projects.springbootcrud.entities.CustomerOrder;
import com.shesha.projects.springbootcrud.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @PostMapping("/addcustomerorder")
    public CustomerOrder saveOrder(@RequestBody CustomerOrder customerOrder)
    {
        return customerOrderService.saveCustomerOrder(customerOrder);
    }

    @PutMapping("/updatecustomerorder")
    public CustomerOrder updateOrder(@RequestBody CustomerOrder customerOrder)
    {
        return customerOrderService.updateOrder(customerOrder);
    }

    @GetMapping("/customerorders")
    public List<CustomerOrder> getAllOrders()
    {
        return customerOrderService.getCustomerOrders();
    }

    @GetMapping("/customerorders/find/{id}")
    public CustomerOrder getOrderById(@PathVariable int id)
    {
        return customerOrderService.findOrderById(id);
    }

    @GetMapping("/customerorders/{name}")
    public List<CustomerOrder> getOrdersByName(@PathVariable String name)
    {
        return customerOrderService.getOrdersByCustomerName(name);
    }

    @DeleteMapping("/customerorders/{id}")
    public String deleteOrder(@PathVariable int id)
    {
        return customerOrderService.deleteOrder(id);
    }
}
