package com.shesha.projects.springbootcrud.services;

import com.shesha.projects.springbootcrud.entities.Customer;
import com.shesha.projects.springbootcrud.entities.Industry;
import com.shesha.projects.springbootcrud.repositories.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndustryService {

    @Autowired
    private IndustryRepository industryRepository;

    public Industry saveIndustry(Industry industry)
    {
        return industryRepository.save(industry);
    }

    public String deleteIndustry(int industryId)
    {
        industryRepository.deleteById(industryId);
        return "Industry type deleted. ID: " + industryId;
    }

    public List<Industry> getAllIndustries()
    {
        return industryRepository.findAll();
    }

    public Industry getIndustryById(int id)
    {
        return industryRepository.findById(id).orElse(null);
    }

    public Industry updateIndustry(Industry industry)
    {
        Industry existingIndustry = industryRepository.findById(industry.getIndustryId()).orElse(null);
        existingIndustry.setCustomers((ArrayList<Customer>) industry.getCustomers());
        existingIndustry.setIndustryId(industry.getIndustryId());
        existingIndustry.setIndustryType(industry.getIndustryType());
        return industryRepository.save(existingIndustry);
    }

}
