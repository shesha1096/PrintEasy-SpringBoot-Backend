package com.shesha.projects.springbootcrud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name="customer_id")
    private int customerId;
    @ManyToOne
    @JoinColumn(name = "industry_id",nullable = false)
    private Industry industry;
    @ManyToOne
    @JoinColumn(name = "managed_by",nullable = false)
    private User managedBy;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_country")
    private String customerCountry;
    @Column(name = "company_size")
    private String companySize;
    @Column(name = "company_iso")
    private String companyISO;
    @Column(name = "company_headquarters")
    private String companyHeadquarters;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "customer")
    private List<CustomerContact> customerContacts;
    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrders;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public User getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(User managedBy) {
        this.managedBy = managedBy;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCountry() {
        return customerCountry;
    }

    public void setCustomerCountry(String customerCountry) {
        this.customerCountry = customerCountry;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanyISO() {
        return companyISO;
    }

    public void setCompanyISO(String companyISO) {
        this.companyISO = companyISO;
    }

    public String getCompanyHeadquarters() {
        return companyHeadquarters;
    }

    public void setCompanyHeadquarters(String companyHeadquarters) {
        this.companyHeadquarters = companyHeadquarters;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<CustomerContact> getCustomerContacts() {
        return customerContacts;
    }

    public void setCustomerContacts(List<CustomerContact> customerContacts) {
        this.customerContacts = customerContacts;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(ArrayList<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
