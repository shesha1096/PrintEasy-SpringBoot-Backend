package com.shesha.projects.springbootcrud.repositories;

import com.shesha.projects.springbootcrud.entities.Printer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrinterRepository extends JpaRepository<Printer, Integer> {

    @Query(value = "SELECT p FROM Printer p WHERE p.printerName = ?1")
    public List<Printer> findByName(String printerName);
}
