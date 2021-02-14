package com.shesha.projects.springbootcrud.repositories;

import com.shesha.projects.springbootcrud.entities.Industry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndustryRepository extends JpaRepository<Industry,Integer> {
}
