package com.addressbookapp.controller;

import com.addressbookapp.dto.AddressBookDTO;
import com.addressbookapp.dto.ResponseDTO;
import com.addressbookapp.entity.AddressBookEntity;
import com.addressbookapp.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AddressBookController {

    @Autowired
    IAddressBookService addressBookService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookEntity addressBookEntity = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book Data Successfully!", addressBookEntity);
        log.info("Inside createAddressBookData() Method of AddressBookController Class");
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        log.info("Inside getAddressBookData() Method of AddressBookController Class");
        List<AddressBookEntity> addressBookEntityList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Fetched all AddressBook Data Successfully!!", addressBookEntityList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
