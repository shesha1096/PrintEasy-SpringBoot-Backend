package com.shesha.projects.springbootcrud.repositories;

import com.shesha.projects.springbootcrud.entities.CustomerContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerContactRepository extends JpaRepository<CustomerContact,Integer> {

    @Query(value ="SELECT c FROM CustomerContact c WHERE c.customerContactName = ?1")
    public List<CustomerContact> findContactsByName(String customerContactName);

}
