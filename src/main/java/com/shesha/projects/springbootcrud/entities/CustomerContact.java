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
@Table(name="CUSTOMER_CONTACT")
public class CustomerContact {
    @Id
    @GeneratedValue
    @Column(name = "customer_contact_id")
    private int customerContactId;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @Column(name = "customer_role")
    private String customerRole;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "customer_email")
    private String customerEmail;
    @Column(name = "customer_contact_name")
    private String customerContactName;
    @Column(name = "customer_availability")
    private String customerAvailability;
    @OneToMany(mappedBy = "customerContact")
    private List<CustomerOrder> customerOrders;

    public int getCustomerContactId() {
        return customerContactId;
    }

    public void setCustomerContactId(int customerContactId) {
        this.customerContactId = customerContactId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerRole() {
        return customerRole;
    }

    public void setCustomerRole(String customerRole) {
        this.customerRole = customerRole;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerContactName() {
        return customerContactName;
    }

    public void setCustomerContactName(String customerContactName) {
        this.customerContactName = customerContactName;
    }

    public String getCustomerAvailability() {
        return customerAvailability;
    }

    public void setCustomerAvailability(String customerAvailability) {
        this.customerAvailability = customerAvailability;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(ArrayList<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
