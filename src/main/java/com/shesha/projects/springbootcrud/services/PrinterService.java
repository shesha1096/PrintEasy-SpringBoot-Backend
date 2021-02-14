package com.shesha.projects.springbootcrud.services;

import com.shesha.projects.springbootcrud.entities.Printer;
import com.shesha.projects.springbootcrud.repositories.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrinterService {

    @Autowired
    private PrinterRepository printerRepository;

    public Printer savePrinter(Printer printer)
    {
        return printerRepository.save(printer);
    }

    public List<Printer> getAllPrinters()
    {
        return printerRepository.findAll();
    }

    public Printer getPrinterById(int printerId)
    {
        return printerRepository.findById(printerId).orElse(null);
    }

    public List<Printer> getPrinterByName(String printerName)
    {
        return printerRepository.findByName(printerName);
    }

    public String deletePrinter(int printerId)
    {
        printerRepository.deleteById(printerId);
        return "Printer Deleted. ID: " + printerId;
    }

    public Printer updatePrinter(Printer printer)
    {
        Printer existingPrinter = printerRepository.getOne(printer.getPrinterId());
        existingPrinter.setPrinterDescription(printer.getPrinterDescription());
        existingPrinter.setPrinterId(printer.getPrinterId());
        existingPrinter.setPrinterName(printer.getPrinterName());
        return printerRepository.save(existingPrinter);
    }
}
