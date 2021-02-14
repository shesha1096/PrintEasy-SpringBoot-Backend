package com.shesha.projects.springbootcrud.repositories;

import com.shesha.projects.springbootcrud.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query(value = "SELECT c FROM Customer c WHERE c.customerName = ?1")
    public List<Customer> findCustomerByName(String customerName);
}
