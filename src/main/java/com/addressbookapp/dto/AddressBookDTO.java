package com.addressbookapp.dto;

import lombok.Data;

@Data
public class AddressBookDTO {
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String phoneNo;
}
