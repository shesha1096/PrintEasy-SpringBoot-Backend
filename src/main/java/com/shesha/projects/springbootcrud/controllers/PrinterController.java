package com.shesha.projects.springbootcrud.controllers;

import com.shesha.projects.springbootcrud.entities.Printer;
import com.shesha.projects.springbootcrud.services.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PrinterController {

    @Autowired
    private PrinterService printerService;

    @PostMapping(value = "/addprinter",headers = {
            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Printer savePrinter(@RequestBody Printer printer)
    {
        System.out.println(printer.getPrinterName());
        return printerService.savePrinter(printer);
    }

    @GetMapping("/printers")
    public ResponseEntity<List<Printer>> getAllPrinters()
    {
        return ResponseEntity.ok(printerService.getAllPrinters());
    }

    @GetMapping("/printers/{name}")
    public List<Printer> getPrintersByName(@PathVariable String name)
    {
        return printerService.getPrinterByName(name);
    }

    @PutMapping("/updateprinter")
    public Printer updatePrinter(@RequestBody Printer printer)
    {
        return printerService.updatePrinter(printer);
    }

    @DeleteMapping("/printers{id}")
    public String deletePrinter(@PathVariable int id)
    {
        return printerService.deletePrinter(id);
    }

    @GetMapping("/printers/find/{id}")
    public Printer getPrinterById(@PathVariable int id)
    {
        return printerService.getPrinterById(id);
    }
}
