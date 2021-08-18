package com.addressbookapp.builder;

import com.addressbookapp.dto.AddressBookDTO;
import com.addressbookapp.entity.AddressBookEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressBookBuilder {
    public AddressBookEntity buildDO(AddressBookDTO addressBookDTO) {
        AddressBookEntity addressBookEntity = new AddressBookEntity();
        BeanUtils.copyProperties(addressBookDTO, addressBookEntity);
        return addressBookEntity;
    }
}
