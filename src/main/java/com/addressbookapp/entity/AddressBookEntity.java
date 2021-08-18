package com.addressbookapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class AddressBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String phoneNo;
    private LocalDate createdDate;
    private LocalDate updatedDate;

    public AddressBookEntity() {
        createdDate=LocalDate.now();
        updatedDate=LocalDate.now();
    }
}
