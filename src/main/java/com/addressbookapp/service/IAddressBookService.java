package com.addressbookapp.service;

import com.addressbookapp.dto.AddressBookDTO;
import com.addressbookapp.entity.AddressBookEntity;

import java.util.List;

public interface IAddressBookService {
    AddressBookEntity createAddressBookData(AddressBookDTO addressBookDTO);

    List<AddressBookEntity> getAddressBookData();
}
