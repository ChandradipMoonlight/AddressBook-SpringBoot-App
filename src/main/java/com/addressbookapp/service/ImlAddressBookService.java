package com.addressbookapp.service;

import com.addressbookapp.dto.AddressBookDTO;
import com.addressbookapp.entity.AddressBookEntity;
import com.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImlAddressBookService implements IAddressBookService{

    @Autowired
    AddressBookRepository addressBookRepository;

    @Override
    public AddressBookEntity createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookEntity addressBookEntity = new AddressBookEntity(addressBookDTO);
        return addressBookRepository.save(addressBookEntity);
    }

    @Override
    public List<AddressBookEntity> getAddressBookData() {
        return addressBookRepository.findAll();
    }
}
