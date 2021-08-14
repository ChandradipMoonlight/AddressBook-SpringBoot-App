package com.addressbookapp.entity;

import com.addressbookapp.dto.AddressBookDTO;
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

    public AddressBookEntity(AddressBookDTO addressBookDTO) {
        this.name =addressBookDTO.getName();
        this.address=addressBookDTO.getAddress();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zip=addressBookDTO.getZip();
        this.email=addressBookDTO.getEmail();
        this.phoneNo=addressBookDTO.getPhoneNo();
        this.createdDate=LocalDate.now();
        this.updatedDate=LocalDate.now();
    }

    public AddressBookEntity() {

    }
}
