package com.shesha.projects.springbootcrud.controllers;

import com.shesha.projects.springbootcrud.entities.Industry;
import com.shesha.projects.springbootcrud.services.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @PostMapping("/addindustry")
    public Industry saveIndustry(@RequestBody Industry industry)
    {
        return industryService.saveIndustry(industry);
    }

    @DeleteMapping("/industries/{id}")
    public String deleteIndustry(@PathVariable int id)
    {
        return industryService.deleteIndustry(id);
    }

    @GetMapping("/industries")
    public ResponseEntity<List<Industry>> getAllIndustries()
    {
        return ResponseEntity.ok(industryService.getAllIndustries());
    }

    @PutMapping("/updateindustry")
    public Industry updateIndustry(@RequestBody Industry industry)
    {
        return industryService.updateIndustry(industry);
    }

    @GetMapping("/industries/find/{id}")
    public Industry getIndustryById(@PathVariable int id)
    {
        return industryService.getIndustryById(id);
    }

}
