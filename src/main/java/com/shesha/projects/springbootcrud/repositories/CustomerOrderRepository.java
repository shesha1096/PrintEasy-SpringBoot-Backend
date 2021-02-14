package com.shesha.projects.springbootcrud.repositories;

import com.shesha.projects.springbootcrud.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Integer> {

    @Query(value ="SELECT c FROM CustomerOrder c WHERE c.customer.customerName = ?1")
    public List<CustomerOrder> findByCustomerName(String customerName);
}
