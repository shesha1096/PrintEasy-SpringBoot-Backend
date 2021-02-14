package com.shesha.projects.springbootcrud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    @Column(name="street_number")
    private String streetNumber;
    @Column(name="street_address")
    private String streetAddress;
    @Column(name = "state")
    private String state;
    @Column(name="country")
    private String country;
}
