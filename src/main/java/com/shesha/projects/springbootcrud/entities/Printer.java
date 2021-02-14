package com.shesha.projects.springbootcrud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PRINTER")

public class Printer {
    @Id
    @GeneratedValue
    @Column(name = "printer_id")
    private int printerId;
    @Column(name="printer_name")
    private String printerName;
    @Column(name="printer_description")
    private String printerDescription;

    public int getPrinterId() {
        return printerId;
    }

    public void setPrinterId(int printerId) {
        this.printerId = printerId;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getPrinterDescription() {
        return printerDescription;
    }

    public void setPrinterDescription(String printerDescription) {
        this.printerDescription = printerDescription;
    }
}
