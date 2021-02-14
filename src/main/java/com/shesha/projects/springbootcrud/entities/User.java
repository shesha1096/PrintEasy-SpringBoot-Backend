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
@Table(name="USER")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;
    @Column(name = "username")
    private String userName;
    @Column(name = "staff_email_id")
    private String emailId;
    @Column(name = "staff_first_name")
    private String firstName;
    @Column(name = "staff_last_name")
    private String lastName;
    @Column(name = "date_created")
    private String dateCreated;
    @Column(name = "staff_password")
    private String userPassword;
    @Column(name = "is_admin")
    private String isAdmin;
    @Column(name = "user_group")
    private String userGroup;
    @OneToMany(mappedBy = "managedBy")
    private List<Customer> customers;
    @OneToMany(mappedBy = "user")
    private List<CustomerOrder> customerOrders;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(ArrayList<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
