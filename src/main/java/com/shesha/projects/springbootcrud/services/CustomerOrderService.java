package com.shesha.projects.springbootcrud.services;

import com.shesha.projects.springbootcrud.entities.CustomerOrder;
import com.shesha.projects.springbootcrud.repositories.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public CustomerOrder saveCustomerOrder(CustomerOrder customerOrder)
    {
        return customerOrderRepository.save(customerOrder);
    }

    public CustomerOrder findOrderById(int orderId)
    {
        return customerOrderRepository.findById(orderId).orElse(null);
    }

    public String deleteOrder(int orderId)
    {
        customerOrderRepository.deleteById(orderId);
        return "Order Deleted. ID: " + orderId;
    }

    public List<CustomerOrder> getOrdersByCustomerName(String customerName)
    {
        return customerOrderRepository.findByCustomerName(customerName);
    }

    public CustomerOrder updateOrder(CustomerOrder customerOrder)
    {
        CustomerOrder existingOrder = customerOrderRepository.getOne(customerOrder.getCustomerOrderId());
        existingOrder.setCustomer(customerOrder.getCustomer());
        existingOrder.setCustomerContact(customerOrder.getCustomerContact());
        existingOrder.setCustomerOrderId(customerOrder.getCustomerOrderId());
        existingOrder.setOrderQuantity(customerOrder.getOrderQuantity());
        existingOrder.setOrderStatus(customerOrder.getOrderStatus());
        existingOrder.setPrinter(customerOrder.getPrinter());
        existingOrder.setUser(customerOrder.getUser());
        return customerOrderRepository.save(existingOrder);
    }

    public List<CustomerOrder> getCustomerOrders()
    {
        return customerOrderRepository.findAll();
    }
}
